package com.example.umbbmobguide;

import java.util.ArrayList;

public class Department {
    String name;
    String description;
    String phone;
    String email;
    String location;
    double latitude;
    double longitude;
    ArrayList<String> specialties;

    public Department(String name, String description, String phone,
                      String email, String location,
                      double latitude, double longitude,
                      ArrayList<String> specialties) {
        this.name        = name;
        this.description = description;
        this.phone       = phone;
        this.email       = email;
        this.location    = location;
        this.latitude    = latitude;
        this.longitude   = longitude;
        this.specialties = specialties;
    }
}