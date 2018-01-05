package se.sugarest.jane.portugal.data;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import se.sugarest.jane.portugal.R;
import se.sugarest.jane.portugal.data.database.CityEntry;

/**
 * Created by jane on 18-1-5.
 */

public class PortugalDummyDataSource {

    public List<CityEntry> getDummyListCityEntries(Context context) {
        List<CityEntry> cityEntryList = new ArrayList<>();

        CityEntry pasteis_de_belem = new CityEntry(
                context.getString(R.string.item_name_pasteis_de_belem),
                context.getString(R.string.city_name_pasteis_de_belem),
                context.getString(R.string.category_pasteis_de_belem),
                context.getString(R.string.notes_pasteis_de_belem),
                context.getString(R.string.fb_page_pasteis_de_belem),
                context.getString(R.string.website_pasteis_de_belem),
                context.getString(R.string.google_map_location_pasteis_de_belem));

        cityEntryList.add(pasteis_de_belem);

        return cityEntryList;
    }


}
