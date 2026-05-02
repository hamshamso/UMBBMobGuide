package com.example.umbbmobguide;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DepartmentAdapter extends BaseAdapter {
    Context cxt;
    ArrayList<Department> list;

    public DepartmentAdapter(Context context, ArrayList<Department> list) {
        this.cxt  = context;
        this.list = list;
    }

    @Override
    public int getCount() { return list.size(); }

    @Override
    public Object getItem(int i) { return list.get(i); }

    @Override
    public long getItemId(int i) { return i; }

    @Override
    public View getView(int i, View v, ViewGroup parent) {
        Department dep = list.get(i);

        if (v == null) {
            v = LayoutInflater.from(cxt).inflate(R.layout.list_item_department, parent, false);
        }

        TextView tvName = v.findViewById(R.id.tvDepartmentName);
        TextView tvDesc = v.findViewById(R.id.tvDepartmentDescription);

        tvName.setText(dep.name);
        tvDesc.setText(dep.description);

        // click → open DetailActivity
        v.setOnClickListener(view -> {
            Intent intent = new Intent(cxt, DetailActivity.class);
            intent.putExtra("DETAIL_TYPE",        "department");
            intent.putExtra("DETAIL_NAME",         dep.name);
            intent.putExtra("DETAIL_DESCRIPTION",  dep.description);
            intent.putExtra("DETAIL_PHONE",        dep.phone);
            intent.putExtra("DETAIL_EMAIL",        dep.email);
            intent.putExtra("DETAIL_LOCATION",     dep.location);
            intent.putExtra("DETAIL_LATITUDE",     dep.latitude);
            intent.putExtra("DETAIL_LONGITUDE",    dep.longitude);
            intent.putStringArrayListExtra("DETAIL_SPECIALTIES", dep.specialties);
            cxt.startActivity(intent);
        });

        return v;
    }
}