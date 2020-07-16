package com.woow.appwoowsouq.adapter;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.woow.appwoowsouq.R;
import com.woow.appwoowsouq.data.local.room.OrderItem;
import com.woow.appwoowsouq.data.local.room.RoomDao;
import com.woow.appwoowsouq.view.acivity.CartActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

import static com.woow.appwoowsouq.data.local.room.RoomManger.getInistance;

/**
 * Created by medo on 13/11/2016.
 */

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CategoriesViewHolder> {



    private Context context;
    private CartActivity activity;
    private List<OrderItem> orderlist = new ArrayList<>();
    private Typeface type;
    RoomDao roomDao;
    private Dialog dialog;

    public CartAdapter(Context context, CartActivity activity, List<OrderItem> orderlist) {
        this.context = context;
        this.activity = activity;
        this.orderlist = orderlist;
        roomDao = getInistance(context).roomDao();
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cart, parent, false);
        return new CategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
        OrderItem orderitem = orderlist.get(position);
        Glide.with(context).load(orderitem.getImageItem()).into(holder.itemCartImgItemLogo);
        holder.itemCartTvNameItme.setText(orderitem.getNameItem());
        holder.itemCartTvPriceItem.setText(String.valueOf(orderitem.getPrice()) + "ريال");
        holder.itemCartQuantityItem.setText(String.valueOf(orderitem.getQuantity()));
    }
//    //TODO add item
//    public void addItem(int index , @NonNull CategoriesViewHolder holder)
//    {
//        int i = orderlist.get(index).getQuantity() + 1;
//        holder.itemCartQuantityItem.setText(i + "");
//        Executors.newSingleThreadExecutor().execute(new Runnable() {
//            @Override
//            public void run() {
//                orderlist.get(index).setQuantity(i);
//                roomDao.update(orderlist.get(index));
//                activity.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        activity.updateUi(orderlist);
//                        notifyDataSetChanged();
//
//                    }
//                });
//
//            }
//        });
//    }
//    //TODO reove item
//    public void removeItem(int index , @NonNull CategoriesViewHolder holder)
//    {
//        int i = orderlist.get(index).getQuantity() ;
//        if (i>1) {
//            holder.itemCartQuantityItem.setText(String.valueOf(i-1));
//        }
//
//        Executors.newSingleThreadExecutor().execute(new Runnable() {
//            @Override
//            public void run() {
//                orderlist.get(index).setQuantity(i-1);
//
//
//                roomDao.update(orderlist.get(index));
//
//                activity.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        activity.updateUi(orderlist);
//                        notifyDataSetChanged();
//
//                    }
//                });
////
//            }
//        });
//    }


    @Override
    public int getItemCount() {
        return orderlist.size();
    }

    public class CategoriesViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cart_item_iv_image)
        ImageView itemCartImgItemLogo;
        @BindView(R.id.cart_item_tv_name)
        TextView itemCartTvNameItme;
        @BindView(R.id.cart_item_tv_price)
        TextView itemCartTvPriceItem;
        @BindView(R.id.cart_item__item_count)
        TextView itemCartQuantityItem;
        @BindView(R.id.cart_item_btn_add_item)
        ImageView itemCartBtnAddItem;

        @BindView(R.id.cart_item_btn_remove_item)
        ImageView itemCartBtnRemoveItem;
        @BindView(R.id.cart_item_btn_delete)
        ImageView itemCartBtnRemoveItemFromCart;

        public CategoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

}
