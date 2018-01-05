package se.sugarest.jane.portugal.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;

import static se.sugarest.jane.portugal.utilities.Constants.DATABASE_NAME;

/**
 * Created by jane on 18-1-4.
 */
@Database(entities = {CityEntry.class}
        , version = 1, exportSchema = false)
public abstract class PortugalDataBase extends RoomDatabase {

    private static final String LOG_TAG = PortugalDataBase.class.getSimpleName();

    private static final Object LOCK = new Object();
    private static PortugalDataBase sInstance;

    public static PortugalDataBase getInstance(Context context) {
        Log.d(LOG_TAG, "Getting the database");
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        PortugalDataBase.class, DATABASE_NAME).build();
                Log.d(LOG_TAG, "Made new database");
            }
        }
        return sInstance;
    }

    // The associated DAO for the database
    public abstract PortugalDao portugalDao(); // Getters for Dao
}
