package com.youra.platepal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;

import java.util.Locale;

public class LocaleHelper {
    private Context context;
    private SharedPreferences sharedPreferences;
    private boolean isChanged = false;

    public LocaleHelper(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("LANG", Context.MODE_PRIVATE);
    }

    public void updateResource(String code) {
        Locale locale = new Locale(code);
        Locale.setDefault(locale);

        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;

        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        setLang(code);
    }

    public String getLang() {
        return sharedPreferences.getString("lang", "en");
    }

    public void setLang(String code) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("lang", code);
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
