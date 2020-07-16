package com.woow.appwoowsouq.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.woow.appwoowsouq.R;
import com.woow.appwoowsouq.data.model.ProductItem;
import com.woow.appwoowsouq.view.acivity.HomeActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context context;
    private List<ProductItem> articleslist = new ArrayList<>();

    HomeActivity activity;
    private int position;

    public ProductAdapter(List<ProductItem> articleslist, Context context, HomeActivity activity) {
        this.articleslist = articleslist;
        this.context = context;
        this.activity = activity;

    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.itemProductIvProductImg.setImageResource(articleslist.get(position).getProduct_image());
        holder.itemProductTvProductDetails.setText(articleslist.get(position).getDetails());
        holder.itemProductTvProductName.setText(articleslist.get(position).getName());
        holder.itemProductRbProduct.setRating(articleslist.get(position).getRate());


    }

    @Override
    public int getItemCount() {
        return articleslist.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.item_product_iv_product_img)
        ImageView itemProductIvProductImg;
        @BindView(R.id.item_product_iv_product_more)
        ImageView itemProductIvProductMore;
        @BindView(R.id.item_product_ln_1)
        RelativeLayout itemProductLn1;
        @BindView(R.id.item_product_tv_product_name)
        TextView itemProductTvProductName;
        @BindView(R.id.item_product_tv_product_details)
        TextView itemProductTvProductDetails;
        @BindView(R.id.item_product_rb_product)
        RatingBar itemProductRbProduct;
        @BindView(R.id.item_product_iv_btn_favorite)
        ImageView itemProductIvBtnFavorite;
        @BindView(R.id.item_product_tv_product_price)
        TextView itemProductTvProductPrice;
        @BindView(R.id.item_product_iv_btn_cart)
        ImageView itemProductIvBtnCart;


        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
