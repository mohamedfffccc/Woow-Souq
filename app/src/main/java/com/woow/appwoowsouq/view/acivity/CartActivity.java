package com.woow.appwoowsouq.view.acivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.woow.appwoowsouq.R;
import com.woow.appwoowsouq.adapter.CartAdapter;
import com.woow.appwoowsouq.data.local.room.OrderItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CartActivity extends AppCompatActivity {

    @BindView(R.id.activity_cart_rv_cart_items)
    RecyclerView activityCartRvCartItems;
    @BindView(R.id.activity_cart_btn_confirm)
    Button activityCartBtnConfirm;
    @BindView(R.id.activity_cart_btn_add)
    Button activityCartBtnAdd;
    ArrayList<OrderItem> cart_list;
    CartAdapter cart_adapter;
    LinearLayoutManager linearLayoutManager_cart;
    @BindView(R.id.activity_cart_tool_bar)
    Toolbar activityCartToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ButterKnife.bind(this);
        addItems();

    }

    private void addItems() {
        linearLayoutManager_cart = new LinearLayoutManager(this);
        activityCartRvCartItems.setLayoutManager(linearLayoutManager_cart);
        cart_list = new ArrayList<>();
        cart_list.add(new OrderItem(1, 1, "i phone"
                , "bjhbvk", 10, 2));
        cart_list.add(new OrderItem(1, 1, "i phone"
                , "bjhbvk", 10, 2));
        cart_list.add(new OrderItem(1, 1, "i phone"
                , "bjhbvk", 10, 2));
        cart_list.add(new OrderItem(1, 1, "i phone"
                , "bjhbvk", 10, 2));
        cart_list.add(new OrderItem(1, 1, "i phone"
                , "bjhbvk", 10, 2));
        cart_list.add(new OrderItem(1, 1, "i phone"
                , "bjhbvk", 10, 2));
        cart_list.add(new OrderItem(1, 1, "i phone"
                , "bjhbvk", 10, 2));
        cart_adapter = new CartAdapter(this, CartActivity.this, cart_list);
        activityCartRvCartItems.setAdapter(cart_adapter);
    }

    @OnClick({R.id.activity_cart_btn_confirm, R.id.activity_cart_btn_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_cart_btn_confirm:
                break;
            case R.id.activity_cart_btn_add:
                startActivity(new Intent(this,HomeActivity.class));
                break;
        }
    }
}
