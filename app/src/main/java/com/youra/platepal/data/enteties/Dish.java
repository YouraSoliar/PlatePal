package com.youra.platepal.data.enteties;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "dishes")
public class Dish {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String recipe;
    private String stringBitmap;

    public Dish(int id, String recipe, String stringBitmap) {
        this.id = id;
        this.recipe = recipe;
        this.stringBitmap = stringBitmap;
    }

    @Ignore
    public Dish(String recipe, String bitmapBird) {
        this(0, recipe, bitmapBird);
    }

    public int getId() {
        return id;
    }

    public String getRecipe() {
        return recipe;
    }

    public String getStringBitmap() {
        return stringBitmap;
    }
}
