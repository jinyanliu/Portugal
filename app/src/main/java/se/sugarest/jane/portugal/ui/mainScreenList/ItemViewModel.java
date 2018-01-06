package se.sugarest.jane.portugal.ui.mainScreenList;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import se.sugarest.jane.portugal.data.PortugalRepository;
import se.sugarest.jane.portugal.data.database.CityEntry;

/**
 * Created by jane on 18-1-5.
 */

public class ItemViewModel extends ViewModel {
    private final LiveData<List<CityEntry>> mCityEntries;

    ItemViewModel(PortugalRepository repository) {
        mCityEntries = repository.getCityEntryList();
    }

    LiveData<List<CityEntry>> getCityEntries() {
        return mCityEntries;
    }
}
