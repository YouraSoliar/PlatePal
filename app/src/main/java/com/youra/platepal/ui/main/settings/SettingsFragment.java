package com.youra.platepal.ui.main.settings;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.youra.platepal.R;
import com.youra.platepal.base.BaseFragment;
import com.youra.platepal.databinding.FragmentSettingsBinding;
import com.youra.platepal.util.PrefService;

public class SettingsFragment extends BaseFragment {

    private FragmentSettingsBinding binding;
    private SettingsViewModel viewModel;
    private PrefService pref;
    private Resources resources;
    private String[] languagesArray = null;
    private String[] countArray = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {
        viewModel = new ViewModelProvider(this).get(SettingsViewModel.class);
        pref = new PrefService(getContext());
        resources = getResources();
        languagesArray = resources.getStringArray(R.array.spinner_language);
        countArray = resources.getStringArray(R.array.spinner_count);
        initView();
        initListeners();
    }

    private void initView() {
        String lang = pref.getLang();
        if (lang.equals("en")) {
            binding.textViewLanguage.setText(languagesArray[0]);
        } else if (lang.equals("uk")) {
            binding.textViewLanguage.setText(languagesArray[1]);
        } else if (lang.equals("ru")) {
            binding.textViewLanguage.setText(languagesArray[2]);
        }

        String dishesCount = pref.getDishes();
        binding.textViewCount.setText(dishesCount);
    }
    private void initListeners() {
        binding.textViewLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showChangeLanguageDialog();
            }
        });
        binding.textViewCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showChangeCountDialog();
            }
        });



        binding.imageViewSettingsBack.setOnClickListener(view -> {
            getMainActivity().openIngredientsAndWishesFragment();
        });
    }

    private void showChangeLanguageDialog() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
        mBuilder.setTitle(R.string.dialog_language);
        mBuilder.setSingleChoiceItems(R.array.spinner_language, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i) {
                    case 0:
                        pref.updateLangResource("en");
                        getActivity().recreate();
                        break;
                    case 1:
                        pref.updateLangResource("uk");
                        getActivity().recreate();
                        break;
                    case 2:
                        pref.updateLangResource("ru");
                        getActivity().recreate();
                        break;
                    default:
                        break;
                }
                dialogInterface.dismiss();
            }
        });

        AlertDialog mDialog = mBuilder.create();
        mDialog.show();
    }

    private void showChangeCountDialog() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
        mBuilder.setTitle(R.string.dialog_count);
        mBuilder.setSingleChoiceItems(R.array.spinner_count, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                binding.textViewCount.setText(String.valueOf(i + 1));
                pref.setDishes(String.valueOf(i + 1));
                dialogInterface.dismiss();
            }
        });

        AlertDialog mDialog = mBuilder.create();
        mDialog.show();
    }

}




