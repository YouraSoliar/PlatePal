package com.youra.platepal.data.enteties;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "dishes")
public class Dish {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String recipe;
    private String stringBitmap;

    public Dish(int id, String title, String recipe, String stringBitmap) {
        this.id = id;
        this.title = title;
        this.recipe = recipe;
        this.stringBitmap = stringBitmap;
    }

    @Ignore
    public Dish(String title, String recipe, String bitmapBird) {
        this(0, title, recipe, bitmapBird);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getRecipe() {
        return recipe;
    }

    public String getStringBitmap() {
        return stringBitmap;
    }
}
