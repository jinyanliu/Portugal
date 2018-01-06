package se.sugarest.jane.portugal.data;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import se.sugarest.jane.portugal.R;
import se.sugarest.jane.portugal.data.database.CityEntry;

/**
 * Created by jane on 18-1-5.
 */

public class PortugalDummyData {

    public List<CityEntry> getDummyListCityEntries(Context context) {
        List<CityEntry> cityEntryList = new ArrayList<>();

        /* **************** *
         * pasteis_de_belem *
         * **************** */
        CityEntry pasteis_de_belem = new CityEntry(
                context.getString(R.string.item_name_pasteis_de_belem),
                context.getString(R.string.city_name_pasteis_de_belem),
                context.getString(R.string.category_pasteis_de_belem),
                context.getString(R.string.notes_pasteis_de_belem),
                context.getString(R.string.fb_page_pasteis_de_belem),
                context.getString(R.string.website_pasteis_de_belem),
                context.getString(R.string.google_map_location_pasteis_de_belem));
        cityEntryList.add(pasteis_de_belem);

        /* ***************** *
         * praca_do_comercio *
         * ***************** */
        CityEntry praca_do_comercio = new CityEntry(
                context.getString(R.string.item_name_praca_do_comercio),
                context.getString(R.string.city_name_praca_do_comercio),
                context.getString(R.string.category_praca_do_comercio),
                context.getString(R.string.notes_pasteis_de_belem),
                context.getString(R.string.fb_page_praca_do_comercio),
                context.getString(R.string.website_praca_do_comercio),
                context.getString(R.string.google_map_location_praca_do_comercio));
        cityEntryList.add(praca_do_comercio);

         /* ********** *
         * belem_tower *
         * *********** */
        CityEntry belem_tower = new CityEntry(
                context.getString(R.string.item_name_belem_tower),
                context.getString(R.string.city_name_belem_tower),
                context.getString(R.string.category_belem_tower),
                context.getString(R.string.notes_belem_tower),
                context.getString(R.string.fb_page_belem_tower),
                context.getString(R.string.website_belem_tower),
                context.getString(R.string.google_map_location_belem_tower));
        cityEntryList.add(belem_tower);

        /* ************************* *
         * padrao_dos_descobrimentos *
         * ************************* */
        CityEntry padrao_dos_descobrimentos = new CityEntry(
                context.getString(R.string.item_name_padrao_dos_descobrimentos),
                context.getString(R.string.city_name_padrao_dos_descobrimentos),
                context.getString(R.string.category_padrao_dos_descobrimentos),
                context.getString(R.string.notes_padrao_dos_descobrimentos),
                context.getString(R.string.fb_page_padrao_dos_descobrimentos),
                context.getString(R.string.website_padrao_dos_descobrimentos),
                context.getString(R.string.google_map_location_padrao_dos_descobrimentos));
        cityEntryList.add(padrao_dos_descobrimentos);

        /* ******************* *
         * jeronimos_monastery *
         * ******************* */
        CityEntry jeronimos_monastery = new CityEntry(
                context.getString(R.string.item_name_jeronimos_monastery),
                context.getString(R.string.city_name_jeronimos_monastery),
                context.getString(R.string.category_jeronimos_monastery),
                context.getString(R.string.notes_jeronimos_monastery),
                context.getString(R.string.fb_page_jeronimos_monastery),
                context.getString(R.string.website_jeronimos_monastery),
                context.getString(R.string.google_map_jeronimos_monastery));
        cityEntryList.add(jeronimos_monastery);

        /* ************* *
         * vasco_da_gama *
         * ************* */
        CityEntry vasco_da_gama = new CityEntry(
                context.getString(R.string.item_name_vasco_da_gama),
                context.getString(R.string.city_name_vasco_da_gama),
                context.getString(R.string.category_vasco_da_gama),
                context.getString(R.string.notes_vasco_da_gama),
                context.getString(R.string.fb_page_vasco_da_gama),
                context.getString(R.string.website_vasco_da_gama),
                context.getString(R.string.google_map_vasco_da_gama));
        cityEntryList.add(vasco_da_gama);

        return cityEntryList;
    }
}
