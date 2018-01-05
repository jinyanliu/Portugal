package se.sugarest.jane.portugal.ui.drawerList;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import se.sugarest.jane.portugal.R;
import se.sugarest.jane.portugal.databinding.FragmentNavigationRecyclerViewBinding;

/**
 * This fragment class displays a list of Portugal cities.
 * Created by jane on 18-1-4.
 */

public class DrawerListFragment extends Fragment implements CityAdapter.CityAdapterOnClickHandler {

    private FragmentNavigationRecyclerViewBinding mBinding;
    private CityAdapter mCityAdapter;
    private DrawerListOnItemClickListener mOnItemClickCallBack;

    public DrawerListFragment() {
    }

    public interface DrawerListOnItemClickListener {
        void drawerListOnItemClicked(String cityName);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mOnItemClickCallBack = (DrawerListOnItemClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement DrawerListFragment DrawerListOnItemClickListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_navigation_recycler_view, container, false);
        View rootView = mBinding.getRoot();

        setUpRecyclerViewWithAdapter();

        setUpDummyListCityNames();

        return rootView;

    }

    private void setUpRecyclerViewWithAdapter() {
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mBinding.navigationDrawerRecyclerView.setLayoutManager(layoutManager);
        mBinding.navigationDrawerRecyclerView.setHasFixedSize(true);
        if (mCityAdapter == null) {
            mCityAdapter = new CityAdapter(this);
        }
        mBinding.navigationDrawerRecyclerView.setAdapter(mCityAdapter);
    }

    @Override
    public void onClick(String cityName) {
        mOnItemClickCallBack.drawerListOnItemClicked(cityName);
    }

    private void setUpDummyListCityNames() {
        ArrayList<String> cityNameDummyData = new ArrayList<>();
        cityNameDummyData.add("Lisbon");
        cityNameDummyData.add("Porto");
        cityNameDummyData.add("Sintra");
        cityNameDummyData.add("Cascais");
        mCityAdapter.setUpCityNameStringArray(cityNameDummyData);
    }
}
