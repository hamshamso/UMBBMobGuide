package com.example.umbbmobguide;

public class faculty {
    int logo;
    String facname;
    String depnbr;
    String description;
    String phone;
    String email;
    String location;
    double latitude;
    double longitude;

    public faculty(int logo, String facname, String depnbr,
                   String description, String phone, String email,
                   String location, double latitude, double longitude) {
        this.logo        = logo;
        this.facname     = facname;
        this.depnbr      = depnbr;
        this.description = description;
        this.phone       = phone;
        this.email       = email;
        this.location    = location;
        this.latitude    = latitude;
        this.longitude   = longitude;
    }
}