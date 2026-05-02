package com.example.umbbmobguide;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FacultyAdapter extends BaseAdapter {
    Context cxt;
    ArrayList<faculty> list;

    public FacultyAdapter(Context context, ArrayList<faculty> list) {
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
        faculty fac = list.get(i);

        if (v == null) {
            LayoutInflater lf = LayoutInflater.from(cxt);
            v = lf.inflate(R.layout.faculty_item, parent, false);
        }

        ImageView iv = v.findViewById(R.id.deplogo);
        iv.setImageResource(fac.logo);

        TextView tvn = v.findViewById(R.id.facname);
        tvn.setText(fac.facname);

        TextView tvd = v.findViewById(R.id.depnbr);
        tvd.setText(fac.depnbr);

        // tap faculty → open DetailActivity
        v.setOnClickListener(view -> {
            Intent intent = new Intent(cxt, DetailActivity.class);
            intent.putExtra("DETAIL_TYPE",        "faculty");
            intent.putExtra("DETAIL_NAME",         fac.facname);
            intent.putExtra("DETAIL_DESCRIPTION",  fac.description);
            intent.putExtra("DETAIL_PHONE",        fac.phone);
            intent.putExtra("DETAIL_EMAIL",        fac.email);
            intent.putExtra("DETAIL_LOCATION",     fac.location);
            intent.putExtra("DETAIL_LATITUDE",     fac.latitude);
            intent.putExtra("DETAIL_LONGITUDE",    fac.longitude);
            cxt.startActivity(intent);
        });

        return v;
    }
}