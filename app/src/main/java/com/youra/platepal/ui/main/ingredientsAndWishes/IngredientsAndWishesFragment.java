package com.youra.platepal.ui.main.ingredientsAndWishes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.chip.Chip;
import com.youra.platepal.databinding.FragmentIngredientsAndWishesBinding;
import com.youra.platepal.base.BaseFragment;

public class IngredientsAndWishesFragment extends BaseFragment {

    private FragmentIngredientsAndWishesBinding binding;
    private IngredientsAndWishesViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentIngredientsAndWishesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {
        viewModel = new ViewModelProvider(this).get(IngredientsAndWishesViewModel.class);
        initListeners();
    }

    private void initListeners() {
        binding.imageStore.setOnClickListener(view -> {
            getMainActivity().openStorageFragment();
        });

        binding.textViewSetIngredients.setOnClickListener(view -> {
            if (!binding.editTextIngredients.getText().toString().isEmpty()) {
                addChip(binding.editTextIngredients.getText().toString());

                binding.editTextIngredients.setText("");
            }
        });
    }

    private void addChip(String text) {
        Chip chip = new Chip(getContext());
        chip.setText(text);

        chip.setCloseIconVisible(true);

        chip.setOnCloseIconClickListener(view ->{
            binding.chipGroupIngredients.removeView(chip);
        });

        binding.chipGroupIngredients.addView(chip);
    }
}
