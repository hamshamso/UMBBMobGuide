package com.example.umbbmobguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        // ── Read extras ────────────────────────────────────────────────────
        String type        = getIntent().getStringExtra("DETAIL_TYPE");
        String name        = getIntent().getStringExtra("DETAIL_NAME");
        String description = getIntent().getStringExtra("DETAIL_DESCRIPTION");
        String phone       = getIntent().getStringExtra("DETAIL_PHONE");
        String email       = getIntent().getStringExtra("DETAIL_EMAIL");
        String location    = getIntent().getStringExtra("DETAIL_LOCATION");
        double latitude    = getIntent().getDoubleExtra("DETAIL_LATITUDE",  36.7538);
        double longitude   = getIntent().getDoubleExtra("DETAIL_LONGITUDE", 3.4774);
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

        // ── Specialties ────────────────────────────────────────────────────
        TextView tvSpecTitle       = findViewById(R.id.tvSpecialtiesTitle);
        LinearLayout specContainer = findViewById(R.id.specialtiesContainer);

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

        // ── View Departments button (only for faculty) ─────────────────────
        Button btnDepartments = findViewById(R.id.btnViewDepartments);
        final String finalName = name;
        if ("faculty".equalsIgnoreCase(type)) {
            btnDepartments.setVisibility(View.VISIBLE);
            btnDepartments.setOnClickListener(v -> {
                Intent intent = new Intent(this, DepartmentActivity.class);
                intent.putExtra("FACULTY_NAME", finalName);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            });
        } else {
            btnDepartments.setVisibility(View.GONE);
        }

        // ── Action buttons ─────────────────────────────────────────────────
        final String fPhone = phone;
        final String fEmail = email;
        final double fLat   = latitude;
        final double fLng   = longitude;

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
                sms.putExtra("sms_body", "Hello, I am contacting you regarding " + finalName);
                startActivity(sms);
            } else {
                Toast.makeText(this, "No phone number available", Toast.LENGTH_SHORT).show();
            }
        });

        // EMAIL
        findViewById(R.id.btnEmail).setOnClickListener(v -> {
            if (fEmail != null && !fEmail.isEmpty() && !fEmail.equals("N/A")) {
                Intent mail = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + fEmail));
                mail.putExtra(Intent.EXTRA_SUBJECT, "Inquiry - " + finalName);
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
                            "(" + Uri.encode(finalName != null ? finalName : "") + ")");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, geoUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            if (mapIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(mapIntent);
            } else {
                Uri browserUri = Uri.parse("https://maps.google.com/?q=" + fLat + "," + fLng);
                startActivity(new Intent(Intent.ACTION_VIEW, browserUri));
            }
        });

        // ── Bottom navigation (set LAST) ───────────────────────────────────
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
    }
}