package com.youra.platepal.ui.main.result;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.youra.platepal.data.enteties.Dish;
import com.youra.platepal.util.PrefService;

import java.util.ArrayList;
import java.util.List;

public class ResultViewModel extends AndroidViewModel {

    private MutableLiveData<List<Dish>> dishes = new MutableLiveData<>();
    private PrefService pref;

    public ResultViewModel(@NonNull Application application) {
        super(application);
        pref =  new PrefService(application);
    }

    public LiveData<List<Dish>> getDishes() {
        return dishes;
    }
    public void separateDishesFromAnswer(String answerGPT) {
        List<Dish> dishesList = new ArrayList<>();
        int dishesCount = Integer.parseInt(pref.getDishes());
        for (int i = 0; i < dishesCount; i++) {

            String startString = (i + 1) + ". ";
            String endString = ": ";

            int startIndex = answerGPT.indexOf(startString);
            int endIndex = answerGPT.indexOf(endString, startIndex);


            String title = "";
            String receipt = "";

            if (startIndex != -1 && endIndex != -1 && endIndex > startIndex) {
                title = answerGPT.substring(startIndex + startString.length(), endIndex);
                receipt = answerGPT.substring(endIndex + endString.length(), ((i + 1) == dishesCount)? answerGPT.length() : answerGPT.indexOf((i + 2) + ". "));
                Log.d("Extracted" + i, receipt);
            } else {
                Log.d("ExtractedFail" + i, "Start or end string not found, or end string appears before start string.");
            }

            Dish dish = new Dish(title, receipt, "image");
            dishesList.add(dish);
        }

        dishes.postValue(dishesList);
    }
}