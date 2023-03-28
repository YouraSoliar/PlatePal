package com.youra.platepal.ui.main;

import android.os.Bundle;

import com.youra.platepal.R;
import com.youra.platepal.base.BaseActivity;
import com.youra.platepal.ui.main.ingredientsAndWishes.IngredientsAndWishesFragment;
import com.youra.platepal.ui.main.result.ResultFragment;
import com.youra.platepal.ui.main.storage.StorageFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        openIngredientsAndWishesFragment();
    }

    public void openStorageFragment() {
        replaceFragment(new StorageFragment());
    }

    public void openResultFragment() {
        replaceFragment(new ResultFragment());
    }

    public void openIngredientsAndWishesFragment() {
        replaceFragment(new IngredientsAndWishesFragment());
    }
}