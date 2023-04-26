package com.youra.platepal.data;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.youra.platepal.data.dao.DishDao;
import com.youra.platepal.data.enteties.Dish;
import com.youra.platepal.util.Converter;


@Database(entities = {Dish.class}, version = 1, exportSchema = false)
@TypeConverters(Converter.class)
public abstract class DishDatabase extends RoomDatabase {
    private static DishDatabase instance = null;
    private static final String DB_NAME = "birds.db";

    public static DishDatabase getInstance(Application application) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    application,
                    DishDatabase.class,
                    DB_NAME
            ).build();
        }
        return instance;
    }

    public abstract DishDao birdsDao();
}

