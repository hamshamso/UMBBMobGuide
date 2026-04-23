package com.example.umbbmobguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class FacultyActivity extends AppCompatActivity {
    ArrayList <faculty> list ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavFaculty);
        bottomNav.setSelectedItemId(R.id.nav_faculties);
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                startActivity(new Intent(this, MainActivity.class));
                return true;
            } else if (id == R.id.nav_faculties) {
                return true;
            } else if (id == R.id.nav_search) {
                startActivity(new Intent(this, SearchActivity.class));
                return true;
            }
            return false;
        });

        list = DataManager.getFaculties();
        ListView listView = findViewById(R.id.faclist);
        listView.setDivider(new android.graphics.drawable.ColorDrawable(android.graphics.Color.TRANSPARENT));
        listView.setDividerHeight(30); // Set the height of the divider in pixels

        FacultyAdapter adapter = new FacultyAdapter(this,list);
        listView.setAdapter(adapter);
    }
}