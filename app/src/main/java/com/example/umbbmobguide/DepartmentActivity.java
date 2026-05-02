package com.example.umbbmobguide;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DepartmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);

        // get faculty name sent from DetailActivity
        String facultyName = getIntent().getStringExtra("FACULTY_NAME");
        if (facultyName == null) facultyName = "";

        TextView tvHeader = findViewById(R.id.tvDepartmentHeader);
        tvHeader.setText(facultyName);

        // load departments for this faculty
        ArrayList<Department> departments = DataManager.getDepartments(facultyName);

        ListView listView = findViewById(R.id.deplist);
        listView.setDivider(new android.graphics.drawable.ColorDrawable(android.graphics.Color.TRANSPARENT));
        listView.setDividerHeight(0);

        DepartmentAdapter adapter = new DepartmentAdapter(this, departments);
        listView.setAdapter(adapter);
    }
}