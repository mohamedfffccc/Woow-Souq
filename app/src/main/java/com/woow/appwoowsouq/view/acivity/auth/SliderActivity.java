package com.woow.appwoowsouq.view.acivity.auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.woow.appwoowsouq.R;
import com.woow.appwoowsouq.adapter.SlideAdapter;
import com.woow.appwoowsouq.view.acivity.HomeActivity;
import com.woow.appwoowsouq.view.acivity.UserTypeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.woow.appwoowsouq.data.local.SharedPreferencesManger.SaveData;
import static com.woow.appwoowsouq.data.local.WoowConsts.IS_FIRST;

public class SliderActivity extends AppCompatActivity {

    @BindView(R.id.activity_slider_vp_images)
    ViewPager activitySliderVpImages;
    SlideAdapter adapter;
    @BindView(R.id.activity_slider_tv_submit)
    TextView activitySliderTvSubmit;
    @BindView(R.id.activity_slider_tv_next)
    TextView activitySliderTvNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
        ButterKnife.bind(this);
        adapter = new SlideAdapter(this);
        activitySliderVpImages.setAdapter(adapter);
        activitySliderVpImages.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                SaveData( SliderActivity.this, IS_FIRST, "true");
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @OnClick({R.id.activity_slider_tv_submit, R.id.activity_slider_tv_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_slider_tv_submit:
                startActivity(new Intent(this, UserTypeActivity.class));
                break;
            case R.id.activity_slider_tv_next:
                activitySliderVpImages.setCurrentItem(activitySliderVpImages.getCurrentItem()+1,true);
                break;
        }
    }
}
