package se.sugarest.jane.portugal.ui.mainScreenList;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import se.sugarest.jane.portugal.R;
import se.sugarest.jane.portugal.data.database.CityEntry;
import se.sugarest.jane.portugal.databinding.FragmentNavigationRecyclerViewBinding;
import se.sugarest.jane.portugal.utilities.InjectorUtils;

/**
 * Created by jane on 18-1-5.
 */

public class MainScreenListFragment extends Fragment implements ItemAdapter.ItemAdapterOnClickHandler {

    private static final String LOG_TAG = MainScreenListFragment.class.getSimpleName();

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

        setUpDummyListItems();

        return rootView;

    }

    private void setUpRecyclerViewWithAdapter() {
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mBinding.navigationDrawerRecyclerView.setLayoutManager(layoutManager);
        mBinding.navigationDrawerRecyclerView.setHasFixedSize(true);
        if (mItemAdapter == null) {
            mItemAdapter = new ItemAdapter(this, getActivity());
        }
        mBinding.navigationDrawerRecyclerView.setAdapter(mItemAdapter);
    }

    @Override
    public void onClick(String itemName) {
        mOnItemClickCallBack.mainScreenListOnItemClicked(itemName);
    }

    private void setUpDummyListItems() {

        ItemViewModelFactory factory = InjectorUtils
                .providePortugalViewModelFactory(getActivity().getApplicationContext());

        ItemViewModel viewModel = ViewModelProviders.of(this, factory).get(ItemViewModel.class);

        viewModel.getCityEntries().observe(this, cityEntryList -> {
            if (cityEntryList != null && !cityEntryList.isEmpty()) {
                setUpRecyclerViewWithAdapter();
                bindDataToUI(cityEntryList);
            } else {
                Log.w(LOG_TAG, "There is no city entry result available.");
            }
        });
    }

    private void bindDataToUI(List<CityEntry> cityEntries) {
        mItemAdapter.setUpCityEntryArrayList(cityEntries);
    }
}

