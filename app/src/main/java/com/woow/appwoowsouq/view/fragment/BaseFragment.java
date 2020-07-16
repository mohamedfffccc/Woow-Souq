package com.woow.appwoowsouq.view.fragment;

import androidx.fragment.app.Fragment;

import com.woow.appwoowsouq.view.acivity.BaseActivity;


public class BaseFragment extends Fragment {
    public BaseActivity baseActivity;

    public void SETupACTIVITY() {
        baseActivity = (BaseActivity) getActivity();
        baseActivity.baseFragment = this;
    }

    public void onback() {
        baseActivity.superBackPressed();
        baseActivity.finish();
    }


}
