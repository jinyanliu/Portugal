package se.sugarest.jane.portugal.data;

import android.arch.lifecycle.LiveData;
import android.util.Log;

import java.util.List;

import se.sugarest.jane.portugal.data.database.CityEntry;
import se.sugarest.jane.portugal.data.database.PortugalDao;
import se.sugarest.jane.portugal.utilities.AppExecutors;

/**
 * This class handles data operations in the app. Acts as mediator between {@link PortugalDataSource}
 * and {@link PortugalDao}
 * Created by jane on 18-1-5.
 */

public class PortugalRepository {

    private static final String LOG_TAG = PortugalRepository.class.getSimpleName();

    private static final Object LOCK = new Object();
    private static PortugalRepository sInstance;
    private final PortugalDao mPortugalDao;
    private final PortugalDataSource mPortugalDataSource;
    private final AppExecutors mExecutors;

    private PortugalRepository(PortugalDao portugalDao,
                               PortugalDataSource portugalDataSource,
                               AppExecutors executors) {
        mPortugalDao = portugalDao;
        mPortugalDataSource = portugalDataSource;
        mExecutors = executors;

        getAndSaveCityEntries();

    }

    private void getAndSaveCityEntries() {

        LiveData<List<CityEntry>> dataCityEntryList = mPortugalDataSource.getCityEntryList();

        dataCityEntryList.observeForever(newData -> {
            mExecutors.diskIO().execute(() -> {
                mPortugalDao.deleteCityEntries();
                mPortugalDao.bulkInsertCityEntry(newData);
            });
        });
    }

    public synchronized static PortugalRepository getInstance(
            PortugalDao portugalDao, PortugalDataSource portugalDataSource,
            AppExecutors executors) {
        Log.d(LOG_TAG, "Getting the repository");
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = new PortugalRepository(portugalDao, portugalDataSource, executors);
                Log.d(LOG_TAG, "Made new repository");
            }
        }
        return sInstance;
    }

    private synchronized void initializeData_CityEntry() {
        mExecutors.diskIO().execute(() -> {
            startFetchData_CityEntry();
        });
    }

    public LiveData<List<CityEntry>> getCityEntryList() {
        initializeData_CityEntry();
        return mPortugalDao.getCityEntries();
    }

    private void startFetchData_CityEntry() {
        mPortugalDataSource.fetchData_CityEntry();
    }

}
