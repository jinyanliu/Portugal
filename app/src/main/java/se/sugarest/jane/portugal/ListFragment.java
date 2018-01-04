package se.sugarest.jane.portugal;

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

import se.sugarest.jane.portugal.databinding.FragmentNavigationRecyclerViewBinding;

/**
 * This fragment class displays a list of Portugal cities.
 * Created by jane on 18-1-4.
 */

public class ListFragment extends Fragment implements CityAdapter.CityAdapterOnClickHandler {

    private FragmentNavigationRecyclerViewBinding mBinding;
    private CityAdapter mCityAdapter;
    private OnItemClickListener mOnItemClickCallBack;

    public ListFragment() {
    }

    public interface OnItemClickListener {
        void onItemClicked(String cityName);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mOnItemClickCallBack = (OnItemClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnItemClickListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_navigation_recycler_view, container, false);
        View rootView = mBinding.getRoot();

        setUpRecyclerViewWithAdapter();

        setUpDummyData();

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
        mOnItemClickCallBack.onItemClicked(cityName);
    }

    private void setUpDummyData() {
        ArrayList<String> cityNameDummyData = new ArrayList<>();
        cityNameDummyData.add("Lisbon");
        cityNameDummyData.add("Porto");
        cityNameDummyData.add("Sintra");
        cityNameDummyData.add("Cascais");
        mCityAdapter.setUpCityNameStringArray(cityNameDummyData);
    }
}
