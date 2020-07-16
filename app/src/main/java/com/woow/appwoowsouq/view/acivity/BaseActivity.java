package com.woow.appwoowsouq.view.acivity;

import androidx.appcompat.app.AppCompatActivity;

import com.woow.appwoowsouq.view.fragment.BaseFragment;

public class BaseActivity extends AppCompatActivity {

   public BaseFragment baseFragment;


    public void superBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onBackPressed() {
        baseFragment.onback();
    }
}
