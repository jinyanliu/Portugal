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

         /* ****** *
          * mr_lin *
          * ****** */
        CityEntry mr_lin = new CityEntry(
                context.getString(R.string.item_name_mr_lin),
                context.getString(R.string.city_name_mr_lin),
                context.getString(R.string.category_mr_lin),
                context.getString(R.string.notes_mr_lin),
                context.getString(R.string.fb_page_mr_lin),
                context.getString(R.string.website_mr_lin),
                context.getString(R.string.google_map_mr_lin));

        /* ************* *
         * the_old_house *
         * ************* */
        CityEntry the_old_house = new CityEntry(
                context.getString(R.string.item_name_the_old_house),
                context.getString(R.string.city_name_the_old_house),
                context.getString(R.string.category_the_old_house),
                context.getString(R.string.notes_the_old_house),
                context.getString(R.string.fb_page_the_old_house),
                context.getString(R.string.website_the_old_house),
                context.getString(R.string.google_map_the_old_house));

        /* ************ *
         * air_portugal *
         * ************ */
        CityEntry air_portugal = new CityEntry(
                context.getString(R.string.item_name_air_portugal),
                context.getString(R.string.city_name_air_portugal),
                context.getString(R.string.category_air_portugal),
                context.getString(R.string.notes_air_portugal),
                context.getString(R.string.fb_page_air_portugal),
                context.getString(R.string.website_air_portugal),
                context.getString(R.string.google_map_air_portugal));

        /* **** *
         * viva *
         * **** */
        CityEntry viva = new CityEntry(
                context.getString(R.string.item_name_VIVA),
                context.getString(R.string.city_name_VIVA),
                context.getString(R.string.category_VIVA),
                context.getString(R.string.notes_VIVA),
                context.getString(R.string.fb_page_VIVA),
                context.getString(R.string.website_VIVA),
                context.getString(R.string.google_map_VIVA));

        /* *************** *
         * gare_do_oriente *
         * *************** */
        CityEntry gare_do_oriente = new CityEntry(
                context.getString(R.string.item_name_gare_do_oriente),
                context.getString(R.string.city_name_gare_do_oriente),
                context.getString(R.string.category_gare_do_oriente),
                context.getString(R.string.notes_gare_do_oriente),
                context.getString(R.string.fb_page_gare_do_oriente),
                context.getString(R.string.website_gare_do_oriente),
                context.getString(R.string.google_map_gare_do_oriente));

         /* *************** *
         * gare_do_oriente *
         * *************** */
        CityEntry olaias_park_hotel = new CityEntry(
                context.getString(R.string.item_name_olaias_park_hotel),
                context.getString(R.string.city_name_olaias_park_hotel),
                context.getString(R.string.category_olaias_park_hotel),
                context.getString(R.string.notes_olaias_park_hotel),
                context.getString(R.string.fb_page_olaias_park_hotel),
                context.getString(R.string.website_olaias_park_hotel),
                context.getString(R.string.google_map_olaias_park_hotel));

        /* *************************** *
         * instituto_superior_tecnico  *
         * *************************** */
        CityEntry instituto_superior_técnico = new CityEntry(
                context.getString(R.string.item_name_instituto_superior_tecnico),
                context.getString(R.string.city_name_instituto_superior_tecnico),
                context.getString(R.string.category_instituto_superior_tecnico),
                context.getString(R.string.notes_instituto_superior_tecnico),
                context.getString(R.string.fb_page_instituto_superior_tecnico),
                context.getString(R.string.website_instituto_superior_tecnico),
                context.getString(R.string.google_map_instituto_superior_tecnico));

        /* **************** *
         * gulbenkian_park  *
         * **************** */
        CityEntry gulbenkian_park = new CityEntry(
                context.getString(R.string.item_name_gulbenkian_park),
                context.getString(R.string.city_name_gulbenkian_park),
                context.getString(R.string.category_gulbenkian_park),
                context.getString(R.string.notes_gulbenkian_park),
                context.getString(R.string.fb_page_gulbenkian_park),
                context.getString(R.string.website_gulbenkian_park),
                context.getString(R.string.google_map_gulbenkian_park));

        /* **************** *
         * eduardo_vii_park *
         * **************** */
        CityEntry eduardo_vii_park = new CityEntry(
                context.getString(R.string.item_name_eduardo_vii_park),
                context.getString(R.string.city_name_eduardo_vii_park),
                context.getString(R.string.category_eduardo_vii_park),
                context.getString(R.string.notes_eduardo_vii_park),
                context.getString(R.string.fb_page_eduardo_vii_park),
                context.getString(R.string.website_eduardo_vii_park),
                context.getString(R.string.google_map_eduardo_vii_park));

        /* **************** *
         * sao_jorge_castle *
         * **************** */
        CityEntry sao_jorge_castle = new CityEntry(
                context.getString(R.string.item_name_sao_jorge_castle),
                context.getString(R.string.city_name_sao_jorge_castle),
                context.getString(R.string.category_sao_jorge_castle),
                context.getString(R.string.notes_sao_jorge_castle),
                context.getString(R.string.fb_page_sao_jorge_castle),
                context.getString(R.string.website_sao_jorge_castle),
                context.getString(R.string.google_map_sao_jorge_castle));

        /* **************** *
         * lisbon_cathedral *
         * **************** */
        CityEntry lisbon_cathedral = new CityEntry(
                context.getString(R.string.item_name_lisbon_cathedral),
                context.getString(R.string.city_name_lisbon_cathedral),
                context.getString(R.string.category_lisbon_cathedral),
                context.getString(R.string.notes_lisbon_cathedral),
                context.getString(R.string.fb_page_lisbon_cathedral),
                context.getString(R.string.website_lisbon_cathedral),
                context.getString(R.string.google_map_lisbon_cathedral));

        /* ************** *
         * timeout_market *
         * ************** */
        CityEntry timeout_market = new CityEntry(
                context.getString(R.string.item_name_timeout_market),
                context.getString(R.string.city_name_timeout_market),
                context.getString(R.string.category_timeout_market),
                context.getString(R.string.notes_timeout_market),
                context.getString(R.string.fb_page_timeout_market),
                context.getString(R.string.website_timeout_market),
                context.getString(R.string.google_map_timeout_market));

        /* ************************** *
         * amorino_gelato_al_naturale *
         * ************************** */
        CityEntry amorino_gelato_al_naturale = new CityEntry(
                context.getString(R.string.item_name_amorino_gelato_al_naturale),
                context.getString(R.string.city_name_amorino_gelato_al_naturale),
                context.getString(R.string.category_amorino_gelato_al_naturale),
                context.getString(R.string.notes_amorino_gelato_al_naturale),
                context.getString(R.string.fb_page_amorino_gelato_al_naturale),
                context.getString(R.string.website_amorino_gelato_al_naturale),
                context.getString(R.string.google_map_amorino_gelato_al_naturale));

        /* *************** *
         * pangzi_mianguan *
         * *************** */
        CityEntry pangzi_mianguan = new CityEntry(
                context.getString(R.string.item_name_pangzi_mianguan),
                context.getString(R.string.city_name_pangzi_mianguan),
                context.getString(R.string.category_pangzi_mianguan),
                context.getString(R.string.notes_pangzi_mianguan),
                context.getString(R.string.fb_page_pangzi_mianguan),
                context.getString(R.string.website_pangzi_mianguan),
                context.getString(R.string.google_map_pangzi_mianguan));

        cityEntryList.add(olaias_park_hotel);
        cityEntryList.add(pasteis_de_belem);
        cityEntryList.add(amorino_gelato_al_naturale);
        cityEntryList.add(vasco_da_gama);
        cityEntryList.add(timeout_market);
        cityEntryList.add(the_old_house);
        cityEntryList.add(mr_lin);
        cityEntryList.add(pangzi_mianguan);
        cityEntryList.add(praca_do_comercio);
        cityEntryList.add(belem_tower);
        cityEntryList.add(padrao_dos_descobrimentos);
        cityEntryList.add(jeronimos_monastery);
        cityEntryList.add(instituto_superior_técnico);
        cityEntryList.add(gulbenkian_park);
        cityEntryList.add(eduardo_vii_park);
        cityEntryList.add(sao_jorge_castle);
        cityEntryList.add(lisbon_cathedral);
        cityEntryList.add(air_portugal);
        cityEntryList.add(viva);
        cityEntryList.add(gare_do_oriente);

        return cityEntryList;
    }
}
