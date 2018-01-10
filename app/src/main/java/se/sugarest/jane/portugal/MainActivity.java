package se.sugarest.jane.portugal;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import se.sugarest.jane.portugal.data.PortugalDummyData;
import se.sugarest.jane.portugal.data.database.PortugalDao;
import se.sugarest.jane.portugal.data.database.PortugalDataBase;
import se.sugarest.jane.portugal.databinding.ActivityMainBinding;
import se.sugarest.jane.portugal.ui.drawerList.DrawerListFragment;
import se.sugarest.jane.portugal.ui.mainScreenList.MainScreenListFragment;
import se.sugarest.jane.portugal.utilities.AppExecutors;

public class MainActivity extends AppCompatActivity implements DrawerListFragment.DrawerListOnItemClickListener
        , MainScreenListFragment.MainScreenListOnItemClickListener {

    private ActivityMainBinding mBinding;
    private FragmentManager mFragmentManager;
    private String mCurrentCityName;
    private String mCurrentItemName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // Set up ToolBar
        setSupportActionBar(mBinding.appBar.toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setUpNavigationBar();

        setUpDummyData();

        setUpSwipeRefreshListener();

        mFragmentManager = getSupportFragmentManager();

        DrawerListFragment navigationDrawerFragment = new DrawerListFragment();
        mFragmentManager.beginTransaction()
                .add(R.id.navigation_drawer_container, navigationDrawerFragment)
                .commit();

        MainScreenListFragment mainScreenListFragment = new MainScreenListFragment();
        mFragmentManager.beginTransaction()
                .add(R.id.main_screen_list_container, mainScreenListFragment)
                .commit();
    }

    private void setUpDummyData() {
        AppExecutors executors = AppExecutors.getInstance();

        PortugalDataBase database = PortugalDataBase.getInstance(this.getApplicationContext());
        PortugalDao portugalDao = database.portugalDao();

        PortugalDummyData portugalDummyDataSource = new PortugalDummyData();

        executors.diskIO().execute(() -> {
            portugalDao.deleteCityEntries();
            portugalDao.bulkInsertCityEntry(portugalDummyDataSource.getDummyListCityEntries(this));
        });
    }

    private void setUpNavigationBar() {
        mBinding.appBar.navigationMenu.setOnClickListener((View view) -> {
            if (mBinding.drawerLayout.isDrawerOpen(mBinding.navigationDrawerContainer)) {
                mBinding.drawerLayout.closeDrawer(mBinding.navigationDrawerContainer);
            } else {
                mBinding.drawerLayout.openDrawer(mBinding.navigationDrawerContainer);
            }
        });
    }

    private void setUpSwipeRefreshListener() {
        mBinding.swipeRefresh.setOnRefreshListener(
                () -> {
                    setUpDummyData();
                    mBinding.swipeRefresh.setRefreshing(false);
                }
        );
    }

    @Override
    public void drawerListOnItemClicked(String cityName) {
        mCurrentCityName = cityName;
    }

    @Override
    public void mainScreenListOnItemClicked(String itemName) {
        mCurrentItemName = itemName;
    }
}
