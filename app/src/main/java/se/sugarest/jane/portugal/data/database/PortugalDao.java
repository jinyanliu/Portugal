package se.sugarest.jane.portugal.data.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import static se.sugarest.jane.portugal.utilities.Constants.TABLE_NAME_CITY_ENTRY;

/**
 * This interface provides an api for all database operations.
 * <p>
 * Created by jane on 18-1-4.
 */

@Dao
public interface PortugalDao {

    /**
     * Inserts a {@link CityEntry} into the table.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCityEntry(CityEntry cityEntry);

    /**
     * BulkInserts a list of {@link CityEntry} into the table.
     */
    @Insert
    void bulkInsertCityEntry(List<CityEntry> cityEntries);

    /**
     * Get all the {@link CityEntry}
     */
    @Query("SELECT * FROM " + TABLE_NAME_CITY_ENTRY)
    LiveData<List<CityEntry>> getCityEntries();

    /**
     * Delete all the {@link CityEntry}
     */
    @Query("DELETE FROM " + TABLE_NAME_CITY_ENTRY)
    void deleteCityEntries();

}
