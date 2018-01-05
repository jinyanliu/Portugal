package se.sugarest.jane.portugal.ui.mainScreenList;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import se.sugarest.jane.portugal.data.database.CityEntry;
import se.sugarest.jane.portugal.databinding.MainScreenListItemBinding;

/**
 * Created by jane on 18-1-5.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemAdapterViewHolder> {

    private final ItemAdapter.ItemAdapterOnClickHandler mClickHandler;
    private List<CityEntry> mCityEntriesArrayList = new ArrayList<>();

    /**
     * Creates a ItemAdapter.
     *
     * @param clickHandler The on-click handler for this adapter. This single handler is called
     *                     when an item is clicked.
     */
    public ItemAdapter(ItemAdapter.ItemAdapterOnClickHandler clickHandler) {
        this.mClickHandler = clickHandler;
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
            notifyDataSetChanged();
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
            mBinding.tvCategory.setText(category);
            mBinding.executePendingBindings();
        }

        @Override
        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            String clickedItemName = mCityEntriesArrayList.get(adapterPosition).getItemName();
            mClickHandler.onClick(clickedItemName);
        }
    }
}
