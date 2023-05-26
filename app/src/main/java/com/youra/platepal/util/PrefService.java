package com.youra.platepal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;

import java.util.Locale;

public class PrefService {

    private final String KEY_LANG = "lang";
    private final String KEY_INTRO = "intro";
    private final String KEY_DISHES = "dishes";
    private Context context;
    private SharedPreferences sharedPreferences;
    private boolean isChanged = false;

    public PrefService(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("APP", Context.MODE_PRIVATE);
    }

    public void updateLangResource(String code) {
        Locale locale = new Locale(code);
        Locale.setDefault(locale);

        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;

        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        setLang(code);
    }

    public String getLang() {
        return sharedPreferences.getString(KEY_LANG, "en");
    }

    public Boolean getIntro() {
        return sharedPreferences.getBoolean(KEY_INTRO, true);
    }

    public void setIntro(boolean isIntro) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(KEY_INTRO, isIntro);
        editor.apply();
        isChanged = true;
    }

    public void setLang(String code) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_LANG, code);
        editor.apply();
        isChanged = true;
    }

    public String getDishes() {
        return sharedPreferences.getString(KEY_DISHES, "5");
    }

    public void setDishes(String count) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_DISHES, count);
        editor.apply();
        isChanged = true;
    }

    public boolean checkChanged() {
        return isChanged;
    }

    public void setChanges(boolean bool) {
        isChanged = bool;
    }
}
