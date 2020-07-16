package com.woow.appwoowsouq.view.acivity.slied_bar;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.woow.appwoowsouq.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.woow.appwoowsouq.helber.HelperMethod.openGallery;

public class AddProductActivity extends AppCompatActivity {

    @BindView(R.id.activity_add_product_tool_bar)
    Toolbar activityAddProductToolBar;
    @BindView(R.id.activity_add_product_img_logo)
    ImageView activityAddProductImgLogo;
    @BindView(R.id.activity_add_product_btn_image1)
    ImageView activityAddProductBtnImage1;
    @BindView(R.id.activity_add_product_btn_image2)
    ImageView activityAddProductBtnImage2;
    @BindView(R.id.activity_add_product_btn_image3)
    ImageView activityAddProductBtnImage3;
    @BindView(R.id.activity_add_product_btn_image4)
    ImageView activityAddProductBtnImage4;
    @BindView(R.id.activity_add_product_ln)
    LinearLayout activityAddProductLn;
    @BindView(R.id.activity_add_product_tv_product_name)
    EditText activityAddProductTvProductName;
    @BindView(R.id.activity_add_product_tv_product_details)
    EditText activityAddProductTvProductDetails;
    @BindView(R.id.activity_add_product_tv_product_price)
    EditText activityAddProductTvProductPrice;
    @BindView(R.id.activity_add_product_sp_department)
    Spinner activityAddProductSpDepartment;
    @BindView(R.id.activity_add_product_la)
    LinearLayout activityAddProductLa;
    @BindView(R.id.activity_add_product_btn_add_product)
    Button activityAddProductBtnAddProduct;
    ArrayList<ImageView> images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        ButterKnife.bind(this);
        images=new ArrayList<>();
        images.add(activityAddProductBtnImage1);
        images.add(activityAddProductBtnImage2);
        images.add(activityAddProductBtnImage3);
        images.add(activityAddProductBtnImage4);
    }

    @OnClick({R.id.activity_add_product_btn_image1, R.id.activity_add_product_btn_image2, R.id.activity_add_product_btn_image3, R.id.activity_add_product_btn_image4, R.id.activity_add_product_btn_add_product})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_add_product_btn_image1:
                openGallery(AddProductActivity.this,images);
                break;
            case R.id.activity_add_product_btn_image2:
                break;
            case R.id.activity_add_product_btn_image3:
                break;
            case R.id.activity_add_product_btn_image4:
                break;
            case R.id.activity_add_product_btn_add_product:
                break;
        }
    }
}
