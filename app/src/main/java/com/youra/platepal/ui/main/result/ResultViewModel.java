package com.youra.platepal.ui.main.result;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.youra.platepal.data.enteties.Dish;

import java.util.ArrayList;
import java.util.List;

public class ResultViewModel extends AndroidViewModel {

    private MutableLiveData<List<Dish>> dishes = new MutableLiveData<>();

    public ResultViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Dish>> getDishes() {
        return dishes;
    }
    public void separateDishesFromAnswer(String answerGPT) {
        Dish dish1 = new Dish(1, "potato1", "receipt", "image");
        Dish dish2 = new Dish(2, "potato2", "receipt", "image");
        Dish dish3 = new Dish(3, "potato3", "receipt", "image");
        Dish dish4 = new Dish(4, "potato4", "receipt", "image");
        Dish dish5 = new Dish(5, "potato5", "receipt", "image");
        List<Dish> dishes1 = new ArrayList<>();
        dishes1.add(dish1);
        dishes1.add(dish2);
        dishes1.add(dish3);
        dishes1.add(dish4);
        dishes1.add(dish5);
        dishes.postValue(dishes1);
    }
}
