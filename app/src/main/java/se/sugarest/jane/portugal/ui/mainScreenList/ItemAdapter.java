package se.sugarest.jane.portugal.ui.mainScreenList;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import se.sugarest.jane.portugal.R;
import se.sugarest.jane.portugal.data.database.CityEntry;
import se.sugarest.jane.portugal.databinding.MainScreenListItemBinding;

import static se.sugarest.jane.portugal.utilities.Constants.CATEGORY_EAT;
import static se.sugarest.jane.portugal.utilities.Constants.CATEGORY_SEE;
import static se.sugarest.jane.portugal.utilities.Constants.CATEGORY_SHOP;
import static se.sugarest.jane.portugal.utilities.Constants.CATEGORY_STAY;
import static se.sugarest.jane.portugal.utilities.Constants.CATEGORY_TRANS;

/**
 * Created by jane on 18-1-5.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemAdapterViewHolder> {

    private final ItemAdapter.ItemAdapterOnClickHandler mClickHandler;
    private List<CityEntry> mCityEntriesArrayList = new ArrayList<>();
    private Context mContext;

    /**
     * Creates a ItemAdapter.
     *
     * @param clickHandler The on-click handler for this adapter. This single handler is called
     *                     when an item is clicked.
     */
    public ItemAdapter(ItemAdapter.ItemAdapterOnClickHandler clickHandler, Context context) {
        this.mClickHandler = clickHandler;
        this.mContext = context;

    }

    @Override
    public ItemAdapter.ItemAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        MainScreenListItemBinding mainScreenListItemBinding
                = MainScreenListItemBinding.inflate(inflater, parent, false);

        return new ItemAdapter.ItemAdapterViewHolder(mainScreenListItemBinding);
    }

    @Override
    public void onBindViewHolder(ItemAdapter.ItemAdapterViewHolder holder, int position) {
        CityEntry currentCityEntry = mCityEntriesArrayList.get(position);
        holder.bind(currentCityEntry.getItemName(), currentCityEntry.getCategory());
    }

    @Override
    public int getItemCount() {
        if (null != mCityEntriesArrayList) {
            return mCityEntriesArrayList.size();
        }
        return 0;
    }

    public void setUpCityEntryArrayList(List<CityEntry> newArray) {
        if (newArray != null) {
            mCityEntriesArrayList.clear();
            mCityEntriesArrayList.addAll(newArray);
            //notifyDataSetChanged();
        }
    }

    /**
     * The interface that receives onClick messages.
     */
    public interface ItemAdapterOnClickHandler {
        void onClick(String itemName);
    }

    /**
     * Cache of the children views for a item's info
     */
    public class ItemAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final MainScreenListItemBinding mBinding;

        public ItemAdapterViewHolder(MainScreenListItemBinding mBinding) {
            super(mBinding.getRoot());
            this.mBinding = mBinding;
            mBinding.mainScreenListItem.setOnClickListener(this);
        }

        public void bind(String itemName, String category) {
            mBinding.tvItemName.setText(itemName);
            if (category.contains(",")) {
                mBinding.tvCategoryTwo.setVisibility(View.VISIBLE);

                mBinding.tvCategoryOne.setText(category.split(",")[0]);
                mBinding.tvCategoryOne.setBackgroundColor(ContextCompat.getColor(mContext, getBgColor(category.split(",")[0])));
                mBinding.tvCategoryTwo.setText(category.split(",")[1]);
                mBinding.tvCategoryTwo.setBackgroundColor(ContextCompat.getColor(mContext, getBgColor(category.split(",")[1])));
            } else {
                mBinding.tvCategoryTwo.setVisibility(View.GONE);

                mBinding.tvCategoryOne.setText(category);
                mBinding.tvCategoryOne.setBackgroundColor(ContextCompat.getColor(mContext, getBgColor(category)));
            }
            mBinding.executePendingBindings();
        }

        @Override
        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            String clickedItemName = mCityEntriesArrayList.get(adapterPosition).getItemName();
            mClickHandler.onClick(clickedItemName);
        }
    }

    private int getBgColor(String categoryTab) {
        switch (categoryTab) {
            case CATEGORY_EAT:
                return R.color.eat_tab;
            case CATEGORY_SHOP:
                return R.color.shop_tab;
            case CATEGORY_SEE:
                return R.color.see_tab;
            case CATEGORY_TRANS:
                return R.color.trans_tab;
            case CATEGORY_STAY:
                return R.color.stay_tab;
            default:
                return R.color.colorAccent;
        }
    }
}
