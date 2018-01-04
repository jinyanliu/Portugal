package se.sugarest.jane.portugal;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import se.sugarest.jane.portugal.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements ListFragment.OnItemClickListener {

    private ActivityMainBinding mBinding;
    private FragmentManager mFragmentManager;
    private String mCurrentCityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // Set up ToolBar
        setSupportActionBar(mBinding.appBar.toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setUpNavigationBar();

        ListFragment navigationDrawerFragment = new ListFragment();
        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction()
                .add(R.id.navigation_drawer_container, navigationDrawerFragment)
                .commit();
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

    @Override
    public void onItemClicked(String cityName) {
        mCurrentCityName = cityName;
    }
}
