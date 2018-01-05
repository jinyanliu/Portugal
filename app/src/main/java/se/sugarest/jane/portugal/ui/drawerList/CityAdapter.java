package se.sugarest.jane.portugal.ui.drawerList;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import se.sugarest.jane.portugal.databinding.DrawerListItemBinding;

/**
 * Created by jane on 18-1-4.
 */

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityAdapterViewHolder> {

    private final CityAdapterOnClickHandler mClickHandler;
    private ArrayList<String> mCityNamesStringArray = new ArrayList<>();

    /**
     * Creates a CityAdapter.
     *
     * @param clickHandler The on-click handler for this adapter. This single handler is called
     *                     when an item is clicked.
     */
    public CityAdapter(CityAdapterOnClickHandler clickHandler) {
        this.mClickHandler = clickHandler;
    }

    @Override
    public CityAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        DrawerListItemBinding drawerListItemBinding
                = DrawerListItemBinding.inflate(inflater, parent, false);

        return new CityAdapterViewHolder(drawerListItemBinding);
    }

    @Override
    public void onBindViewHolder(CityAdapterViewHolder holder, int position) {
        String cityName = mCityNamesStringArray.get(position);
        holder.bind(cityName);
    }

    @Override
    public int getItemCount() {
        if (null != mCityNamesStringArray) {
            return mCityNamesStringArray.size();
        }
        return 0;
    }

    public void setUpCityNameStringArray(ArrayList<String> newArray) {
        if (newArray != null) {
            mCityNamesStringArray.clear();
            mCityNamesStringArray.addAll(newArray);
            notifyDataSetChanged();
        }
    }

    /**
     * The interface that receives onClick messages.
     */
    public interface CityAdapterOnClickHandler {
        void onClick(String cityName);
    }

    /**
     * Cache of the children views for a city's name
     */
    public class CityAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final DrawerListItemBinding mBinding;

        public CityAdapterViewHolder(DrawerListItemBinding mBinding) {
            super(mBinding.getRoot());
            this.mBinding = mBinding;
            mBinding.drawerListItem.setOnClickListener(this);
        }

        public void bind(String cityName) {
            mBinding.drawerListItem.setText(cityName);
            mBinding.executePendingBindings();
        }

        @Override
        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            String clickedCityName = mCityNamesStringArray.get(adapterPosition);
            mClickHandler.onClick(clickedCityName);
        }
    }
}
