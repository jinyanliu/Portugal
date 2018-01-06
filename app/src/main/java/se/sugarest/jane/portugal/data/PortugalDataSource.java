package se.sugarest.jane.portugal.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;

import java.util.List;

import se.sugarest.jane.portugal.data.database.CityEntry;
import se.sugarest.jane.portugal.utilities.AppExecutors;

/**
 * This class provides an API for doing all operations with the dummy data
 * <p>
 * Created by jane on 18-1-5.
 */

public class PortugalDataSource {

    private static final String LOG_TAG = PortugalDataSource.class.getSimpleName();

    private static final Object LOCK = new Object();
    private static PortugalDataSource sInstance;

    private final MutableLiveData<List<CityEntry>> mDummyData_CityEntry = new MutableLiveData<>();

    private final AppExecutors mExecutors;

    private Context mContext;

    private PortugalDataSource(AppExecutors executors, Context context) {
        mExecutors = executors;
        mContext = context;
    }

    public static PortugalDataSource getInstance(AppExecutors executors, Context context) {
        Log.d(LOG_TAG, "Getting the data source.");
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = new PortugalDataSource(executors, context);
                Log.d(LOG_TAG, "Made new data source.");
            }
        }
        return sInstance;
    }

    LiveData<List<CityEntry>> getCityEntryList() {
        return mDummyData_CityEntry;
    }

    void fetchData_CityEntry() {
        mExecutors.diskIO().execute(()->{
            PortugalDummyData portugalDummyData = new PortugalDummyData();
            mDummyData_CityEntry.postValue(portugalDummyData.getDummyListCityEntries(mContext));
        });
    }
}
