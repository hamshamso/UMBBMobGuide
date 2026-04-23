package com.example.umbbmobguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FacultyAdapter extends BaseAdapter {
    Context cxt;            //to get the context of the activity
    ArrayList<faculty> list;//to get the data
    public FacultyAdapter(Context context, ArrayList<faculty> list){
        this.cxt = context;
        this.list = list;
    }

    @Override
    //to get the number of items in the list
    public int getCount() {
        return list.size();}//it was return null

    @Override
    //to get the item in the list
    public Object getItem(int i) {
        return  list.get(i);
    }

    @Override
    //to get the id of the item in the list
    public long getItemId(int i) {
        //'i' is the index of the item
        return i;//it was return 0 by prof
    }

    @Override
    public View getView(int i, View v, ViewGroup parent) {
        faculty faculty = list.get(i);
        if(v==null){
            LayoutInflater lf=LayoutInflater.from(cxt);     //to make the view
            v=lf.inflate(R.layout.faculty_item,parent, false);
        }
         ImageView iv=v.findViewById(R.id.deplogo);
         iv.setImageResource(faculty.logo);

         TextView tvn=v.findViewById(R.id.facname);
         tvn.setText(faculty.facname);

         TextView tvd=v.findViewById(R.id.depnbr);
         tvd.setText(faculty.depnbr);
        return v;
    }
}
