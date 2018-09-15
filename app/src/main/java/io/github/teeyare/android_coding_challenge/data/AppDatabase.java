package io.github.teeyare.android_coding_challenge.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import io.github.teeyare.android_coding_challenge.utils.DescriptionConverter;

/**
 * Created by teeyare (tarik) on 9/15/18.
 */
@Database(entities = {Product.class}, version = 1)
@TypeConverters(DescriptionConverter.class)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "products";

    // For Singleton instantiation
    private static final Object LOCK = new Object();
    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (LOCK) {
                instance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, AppDatabase.DATABASE_NAME).build();
            }
        }
        return instance;
    }

    // The associated DAOs for the database
    public abstract ProductDao productDao();
}
