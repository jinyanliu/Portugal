package se.sugarest.jane.portugal.data.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import static se.sugarest.jane.portugal.utilities.Constants.TABLE_NAME_CITY_ENTRY;

/**
 * Created by jane on 18-1-4.
 */
@Entity(tableName = TABLE_NAME_CITY_ENTRY, indices = {@Index(value = {"cityName"})})
public class CityEntry {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String itemName;

    private String cityName;

    private String category;

    private String notes;

    // Set default value to null
    private String fbPage = null;

    // Set default value to null
    private String website = null;

    // Set default value to null
    private String googleMapLocation = null;

    // Constructor used by putting data into the database. Tell Room to ignore it.
    @Ignore
    public CityEntry(String itemName, String cityName, String category, String notes, String fbPage, String website, String googleMapLocation) {
        this.itemName = itemName;
        this.cityName = cityName;
        this.category = category;
        this.notes = notes;
        this.fbPage = fbPage;
        this.website = website;
        this.googleMapLocation = googleMapLocation;
    }

    // Constructor used by Room to create CityEntry
    public CityEntry(int id, String itemName, String cityName, String category, String notes, String fbPage, String website, String googleMapLocation) {
        this.id = id;
        this.itemName = itemName;
        this.cityName = cityName;
        this.category = category;
        this.notes = notes;
        this.fbPage = fbPage;
        this.website = website;
        this.googleMapLocation = googleMapLocation;
    }

    public int getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCategory() {
        return category;
    }

    public String getNotes() {
        return notes;
    }

    public String getFbPage() {
        return fbPage;
    }

    public String getWebsite() {
        return website;
    }

    public String getGoogleMapLocation() {
        return googleMapLocation;
    }
}
