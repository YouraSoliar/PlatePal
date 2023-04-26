package com.youra.platepal.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.youra.platepal.data.enteties.Dish;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface DishDao {

    @Query("SELECT * FROM dishes")
    Single<List<Dish>> getBirds();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable add(Dish bird);

    @Query("DELETE FROM dishes WHERE id=:id")
    Completable remove(int id);
}

