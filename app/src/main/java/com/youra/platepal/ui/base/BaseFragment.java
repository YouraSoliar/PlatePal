package com.youra.platepal.ui.base;

import androidx.fragment.app.Fragment;

import com.youra.platepal.ui.main.MainActivity;

public class BaseFragment extends Fragment {

    protected MainActivity getMainActivity() {
        return getActivity() instanceof MainActivity ? (MainActivity) getActivity() : null;
    }

    BaseActivity getBaseActivity() {
        return getActivity() instanceof BaseActivity ? (BaseActivity) getActivity() : null;
    }
}
