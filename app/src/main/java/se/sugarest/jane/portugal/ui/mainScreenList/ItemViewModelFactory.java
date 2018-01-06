package se.sugarest.jane.portugal.ui.mainScreenList;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import se.sugarest.jane.portugal.data.PortugalRepository;

/**
 * Factory class for {@link ItemViewModel}.
 * Created by jane on 18-1-5.
 */
public class ItemViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final PortugalRepository mRepository;

    public ItemViewModelFactory(PortugalRepository repository){
        this.mRepository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ItemViewModel(mRepository);
    }
}
