package com.woow.appwoowsouq.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.viewpager.widget.PagerAdapter;

import com.woow.appwoowsouq.R;


public class SlideAdapter extends PagerAdapter {
    Context context;
    private int[] GalImages = new int[]{R.drawable.ic_google , R.drawable.ic_facebook , R.drawable.ic_twitter};

    LayoutInflater mLayoutInflater;
    int custom_pos=0;

    public SlideAdapter(Context context) {
        this.context = context;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return GalImages.length;
    }



    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        try {

            View itemView = mLayoutInflater.inflate(R.layout.item_slider, container, false);

            ImageView imageView = itemView.findViewById(R.id.slider_item);
            imageView.setImageResource(GalImages[position]);

            container.addView(itemView);

            return itemView;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
