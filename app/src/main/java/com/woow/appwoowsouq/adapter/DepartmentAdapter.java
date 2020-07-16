package com.woow.appwoowsouq.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.woow.appwoowsouq.R;
import com.woow.appwoowsouq.data.model.DepartmentItem;
import com.woow.appwoowsouq.view.acivity.HomeActivity;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


/**
 * Created by medo on 13/11/2016.
 */

public class DepartmentAdapter extends BaseAdapter {



    private Context context;
    private List<DepartmentItem> department_list = new ArrayList<>();

    HomeActivity activity;

    public DepartmentAdapter(List<DepartmentItem> department_list, Context context, HomeActivity activity) {
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
        View view = inflater.inflate(R.layout.item_department , null);
        TextView tv_department_ame = view.findViewById(R.id.item_department_tv_name);

            tv_department_ame.setText(department_list.get(position).getName());

        return view;
    }
}
