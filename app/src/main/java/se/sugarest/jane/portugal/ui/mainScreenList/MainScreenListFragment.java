package se.sugarest.jane.portugal.ui.mainScreenList;

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
import java.util.List;

import se.sugarest.jane.portugal.R;
import se.sugarest.jane.portugal.data.PortugalDummyDataSource;
import se.sugarest.jane.portugal.data.database.CityEntry;
import se.sugarest.jane.portugal.data.database.PortugalDao;
import se.sugarest.jane.portugal.data.database.PortugalDataBase;
import se.sugarest.jane.portugal.databinding.FragmentNavigationRecyclerViewBinding;
import se.sugarest.jane.portugal.utilities.AppExecutors;

/**
 * Created by jane on 18-1-5.
 */

public class MainScreenListFragment extends Fragment implements ItemAdapter.ItemAdapterOnClickHandler {

    private FragmentNavigationRecyclerViewBinding mBinding;
    private ItemAdapter mItemAdapter;
    private MainScreenListOnItemClickListener mOnItemClickCallBack;

    public MainScreenListFragment() {
    }

    public interface MainScreenListOnItemClickListener {
        void mainScreenListOnItemClicked(String itemName);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mOnItemClickCallBack = (MainScreenListOnItemClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement MainScreenListFragment DrawerListOnItemClickListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_navigation_recycler_view, container, false);
        View rootView = mBinding.getRoot();

        setUpRecyclerViewWithAdapter();

        setUpDummyListItemNames();

        return rootView;

    }

    private void setUpRecyclerViewWithAdapter() {
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mBinding.navigationDrawerRecyclerView.setLayoutManager(layoutManager);
        mBinding.navigationDrawerRecyclerView.setHasFixedSize(true);
        if (mItemAdapter == null) {
            mItemAdapter = new ItemAdapter(this);
        }
        mBinding.navigationDrawerRecyclerView.setAdapter(mItemAdapter);
    }

    @Override
    public void onClick(String cityName) {
        mOnItemClickCallBack.mainScreenListOnItemClicked(cityName);
    }

    private void setUpDummyListItemNames() {
        AppExecutors executors = AppExecutors.getInstance();

        PortugalDataBase database = PortugalDataBase.getInstance(getActivity().getApplicationContext());
        PortugalDao portugalDao = database.portugalDao();

        List<CityEntry> cityEntryList = new ArrayList<>();

//        executors.diskIO().execute(() -> {
//            cityEntryList.addAll(portugalDao.getCityEntries());
//        });

        PortugalDummyDataSource portugalDummyDataSource = new PortugalDummyDataSource();

        cityEntryList.addAll(portugalDummyDataSource.getDummyListCityEntries(getActivity()));

        mItemAdapter.setUpCityEntryArrayList(cityEntryList);

    }
}

