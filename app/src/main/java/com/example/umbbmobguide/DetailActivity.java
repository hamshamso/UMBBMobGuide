package com.example.umbbmobguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // ── Bottom navigation ──────────────────────────────────────────────
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavDetail);
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                startActivity(new Intent(this, MainActivity.class));
                return true;
            } else if (id == R.id.nav_faculties) {
                startActivity(new Intent(this, FacultyActivity.class));
                return true;
            } else if (id == R.id.nav_search) {
                startActivity(new Intent(this, SearchActivity.class));
                return true;
            }
            return false;
        });

        // ── Read extras sent by FacultyActivity or DepartmentActivity ──────
        //    Keys:  DETAIL_TYPE ("faculty" or "department")
        //           DETAIL_NAME, DETAIL_DESCRIPTION
        //           DETAIL_PHONE, DETAIL_EMAIL, DETAIL_LOCATION
        //           DETAIL_LATITUDE, DETAIL_LONGITUDE
        //           DETAIL_SPECIALTIES  (ArrayList<String>)
        String type        = getIntent().getStringExtra("DETAIL_TYPE");
        String name        = getIntent().getStringExtra("DETAIL_NAME");
        String description = getIntent().getStringExtra("DETAIL_DESCRIPTION");
        String phone       = getIntent().getStringExtra("DETAIL_PHONE");
        String email       = getIntent().getStringExtra("DETAIL_EMAIL");
        String location    = getIntent().getStringExtra("DETAIL_LOCATION");
        double latitude    = getIntent().getDoubleExtra("DETAIL_LATITUDE",  36.7538);
        double longitude   = getIntent().getDoubleExtra("DETAIL_LONGITUDE",  3.0588);
        ArrayList<String> specialties =
                getIntent().getStringArrayListExtra("DETAIL_SPECIALTIES");

        // ── Header ─────────────────────────────────────────────────────────
        TextView tvType = findViewById(R.id.tvDetailType);
        tvType.setText("faculty".equalsIgnoreCase(type) ? "Faculty" : "Department");

        TextView tvName = findViewById(R.id.tvDetailName);
        tvName.setText(name != null ? name : "");

        // ── Description ────────────────────────────────────────────────────
        TextView tvDesc = findViewById(R.id.tvDetailDescription);
        tvDesc.setText(description != null ? description : "");

        // ── Specialties list ───────────────────────────────────────────────
        TextView tvSpecTitle          = findViewById(R.id.tvSpecialtiesTitle);
        LinearLayout specContainer    = findViewById(R.id.specialtiesContainer);

        if (specialties != null && !specialties.isEmpty()) {
            tvSpecTitle.setVisibility(View.VISIBLE);
            specContainer.setVisibility(View.VISIBLE);
            for (String spec : specialties) {
                TextView tv = new TextView(this);
                tv.setText("• " + spec);
                tv.setTextSize(14f);
                tv.setPadding(0, 6, 0, 6);
                tv.setTextColor(getResources().getColor(R.color.text_gray, getTheme()));
                specContainer.addView(tv);
            }
        } else {
            tvSpecTitle.setVisibility(View.GONE);
            specContainer.setVisibility(View.GONE);
        }

        // ── Contact info ───────────────────────────────────────────────────
        ((TextView) findViewById(R.id.tvDetailPhone))
                .setText(phone    != null && !phone.isEmpty()    ? phone    : "N/A");
        ((TextView) findViewById(R.id.tvDetailEmail))
                .setText(email    != null && !email.isEmpty()    ? email    : "N/A");
        ((TextView) findViewById(R.id.tvDetailLocation))
                .setText(location != null && !location.isEmpty() ? location : "N/A");

        // ── Action buttons ─────────────────────────────────────────────────
        final String fPhone    = phone;
        final String fEmail    = email;
        final String fName     = name;
        final double fLat      = latitude;
        final double fLng      = longitude;

        // CALL
        findViewById(R.id.btnCall).setOnClickListener(v -> {
            if (fPhone != null && !fPhone.isEmpty() && !fPhone.equals("N/A")) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + fPhone)));
            } else {
                Toast.makeText(this, "No phone number available", Toast.LENGTH_SHORT).show();
            }
        });

        // SMS
        findViewById(R.id.btnSms).setOnClickListener(v -> {
            if (fPhone != null && !fPhone.isEmpty() && !fPhone.equals("N/A")) {
                Intent sms = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + fPhone));
                sms.putExtra("sms_body", "Hello, I am contacting you regarding " + fName);
                startActivity(sms);
            } else {
                Toast.makeText(this, "No phone number available", Toast.LENGTH_SHORT).show();
            }
        });

        // EMAIL
        findViewById(R.id.btnEmail).setOnClickListener(v -> {
            if (fEmail != null && !fEmail.isEmpty() && !fEmail.equals("N/A")) {
                Intent mail = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + fEmail));
                mail.putExtra(Intent.EXTRA_SUBJECT, "Inquiry - " + fName);
                startActivity(mail);
            } else {
                Toast.makeText(this, "No email address available", Toast.LENGTH_SHORT).show();
            }
        });

        // MAP
        findViewById(R.id.btnMap).setOnClickListener(v -> {
            Uri geoUri = Uri.parse(
                    "geo:" + fLat + "," + fLng +
                            "?q=" + fLat + "," + fLng +
                            "(" + Uri.encode(fName != null ? fName : "") + ")");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, geoUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            if (mapIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(mapIntent);
            } else {
                // fallback: open in browser
                Uri browserUri = Uri.parse(
                        "https://maps.google.com/?q=" + fLat + "," + fLng);
                startActivity(new Intent(Intent.ACTION_VIEW, browserUri));
            }
        });
    }
}