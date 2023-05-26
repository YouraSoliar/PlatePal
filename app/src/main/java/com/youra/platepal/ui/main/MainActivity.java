package com.youra.platepal.ui.main;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import com.youra.platepal.R;
import com.youra.platepal.base.BaseActivity;
import com.youra.platepal.ui.main.ingredientsAndWishes.IngredientsAndWishesFragment;
import com.youra.platepal.ui.main.result.ResultFragment;
import com.youra.platepal.ui.main.settings.SettingsFragment;
import com.youra.platepal.ui.main.storage.StorageFragment;
import com.youra.platepal.util.PrefService;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        PrefService pref = new PrefService(this);
        pref.updateLangResource(pref.getLang());

        openIngredientsAndWishesFragment();
    }

    public void openStorageFragment() {
        replaceFragment(new StorageFragment());
    }

    public void openResultFragment() {
        replaceFragment(new ResultFragment());
    }

    public void openSettingsFragment() {
        replaceFragment(new SettingsFragment());
    }

    public void openIngredientsAndWishesFragment() {
        replaceFragment(new IngredientsAndWishesFragment());
    }
    public void openDishFragment() {
        replaceFragment(new DialogFragment());
    }
}