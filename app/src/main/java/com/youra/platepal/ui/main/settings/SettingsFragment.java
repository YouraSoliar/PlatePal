package com.youra.platepal.ui.main.settings;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.youra.platepal.R;
import com.youra.platepal.base.BaseFragment;
import com.youra.platepal.databinding.FragmentSettingsBinding;
import com.youra.platepal.util.LocaleHelper;

public class SettingsFragment extends BaseFragment {

    private FragmentSettingsBinding binding;
    private SettingsViewModel viewModel;
    private LocaleHelper localeHelper;
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
        localeHelper = new LocaleHelper(getContext());
        resources = getResources();
        languagesArray = resources.getStringArray(R.array.spinner_language);
        countArray = resources.getStringArray(R.array.spinner_count);
        initListeners();


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

        String lang = localeHelper.getLang();
        if (lang.equals("en")) {
            binding.textViewLanguage.setText(languagesArray[0]);
        } else if (lang.equals("uk")) {
            binding.textViewLanguage.setText(languagesArray[1]);
        } else if (lang.equals("ru")) {
            binding.textViewLanguage.setText(languagesArray[2]);
        }

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
                        localeHelper.updateResource("en");
                        getActivity().recreate();
                        break;
                    case 1:
                        localeHelper.updateResource("uk");
                        getActivity().recreate();
                        break;
                    case 2:
                        localeHelper.updateResource("ru");
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
                switch (i) {
                    case 0:

                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:

                        break;
                    case 8:

                        break;
                    case 9:

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

}




