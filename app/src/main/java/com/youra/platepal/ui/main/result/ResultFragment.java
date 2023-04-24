package com.youra.platepal.ui.main.result;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.ViewModelProvider;

import com.youra.platepal.base.BaseFragment;
import com.youra.platepal.databinding.FragmentResultBinding;

public class ResultFragment  extends BaseFragment {

    private FragmentResultBinding binding;
    private ResultViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentResultBinding.inflate(inflater, container, false);
        getParentFragmentManager().setFragmentResultListener("request", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String data = result.getString("message");
                Toast.makeText(getContext(), data, Toast.LENGTH_SHORT).show();
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {
        viewModel = new ViewModelProvider(this).get(ResultViewModel.class);
        initListeners();
    }
    private void initListeners() {

    }

}
