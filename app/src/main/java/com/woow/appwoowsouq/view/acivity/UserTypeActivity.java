package com.woow.appwoowsouq.view.acivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.woow.appwoowsouq.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.woow.appwoowsouq.data.local.SharedPreferencesManger.SaveData;
import static com.woow.appwoowsouq.data.local.WoowConsts.USER_TYPE;

public class UserTypeActivity extends AppCompatActivity {

    @BindView(R.id.activity_user_type_btn_user)
    Button activityUserTypeBtnUser;
    @BindView(R.id.activity_user_type_btn_dealer)
    Button activityUserTypeBtnDealer;
    private Intent home_i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_type);
        ButterKnife.bind(this);
         home_i = new Intent(this,HomeActivity.class);

    }

    @OnClick({R.id.activity_user_type_btn_user, R.id.activity_user_type_btn_dealer})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_user_type_btn_user:
                //TODO save user type
                SaveData(this , USER_TYPE, "user");
                startActivity(home_i);
                break;
            case R.id.activity_user_type_btn_dealer:
                //TODO save user type
                SaveData(this , USER_TYPE, "dealer");

                startActivity(home_i);
                break;
        }
    }
}
