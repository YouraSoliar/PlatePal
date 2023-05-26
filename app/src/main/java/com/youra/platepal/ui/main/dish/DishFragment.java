package com.youra.platepal.ui.main.dish;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youra.platepal.R;
import com.youra.platepal.data.enteties.Dish;
import com.youra.platepal.databinding.FragmentDishBinding;
import com.youra.platepal.databinding.FragmentIngredientsAndWishesBinding;
import com.youra.platepal.ui.main.ingredientsAndWishes.IngredientsAndWishesViewModel;
import com.youra.platepal.util.PrefService;

public class DishFragment extends Fragment {

    private DishViewModel viewModel;
    private FragmentDishBinding binding;
    private Dish dish;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDishBinding.inflate(inflater, container, false);
        dish = (Dish) getArguments().getSerializable("dish");
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {
        viewModel = new ViewModelProvider(this).get(DishViewModel.class);
        initView();
        initListeners();
    }

    private void initView() {
        binding.textViewTitle.setText(dish.getTitle());
        binding.textViewRecipe.setText(dish.getRecipe());
        //binding.imageViewDish
    }

    private void initListeners() {

    }

}