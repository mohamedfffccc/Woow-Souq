package com.woow.appwoowsouq.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.woow.appwoowsouq.R;
import com.woow.appwoowsouq.data.model.DepartmentItem;
import com.woow.appwoowsouq.data.model.MenuModel;
import com.woow.appwoowsouq.view.acivity.HomeActivity;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by medo on 13/11/2016.
 */

public class MenuAdapter extends BaseAdapter {



    private Context context;
    private List<MenuModel> department_list = new ArrayList<>();

    HomeActivity activity;

    public MenuAdapter(ArrayList<MenuModel> department_list, Context context, HomeActivity activity) {
        this.department_list = department_list;
        this.context = context;
        this.activity = activity;

    }

    @Override
    public int getCount() {
        return department_list.size();
    }

    @Override
    public Object getItem(int position) {
        return department_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.menu_item , null);
        TextView tv_department_ame = view.findViewById(R.id.activity_home_tv_menu_item_name);

            tv_department_ame.setText(department_list.get(position).getName());
        ImageView iv = view.findViewById(R.id.activiy_home_menu_image);
        iv.setImageResource(department_list.get(position).getImage());

        return view;
    }
}
