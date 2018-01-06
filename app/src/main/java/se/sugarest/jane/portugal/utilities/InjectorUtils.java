package se.sugarest.jane.portugal.utilities;

import android.content.Context;

import se.sugarest.jane.portugal.data.PortugalDataSource;
import se.sugarest.jane.portugal.data.PortugalRepository;
import se.sugarest.jane.portugal.data.database.PortugalDataBase;
import se.sugarest.jane.portugal.ui.mainScreenList.ItemViewModel;
import se.sugarest.jane.portugal.ui.mainScreenList.ItemViewModelFactory;

/**
 * This class provides static methods to inject the various classes needed for the app
 * <p>
 * Created by jane on 18-1-6.
 */

public class InjectorUtils {

    private static PortugalRepository provideRepository(Context context) {
        PortugalDataBase dataBase = PortugalDataBase.getInstance(context.getApplicationContext());
        AppExecutors executors = AppExecutors.getInstance();
        PortugalDataSource dataSource = PortugalDataSource.getInstance(executors, context);
        return PortugalRepository.getInstance(dataBase.portugalDao(), dataSource, executors);
    }

    public static ItemViewModelFactory providePortugalViewModelFactory(Context context) {
        PortugalRepository repository = provideRepository(context.getApplicationContext());
        return new ItemViewModelFactory(repository);
    }
}
