package com.example.umbbmobguide;

import java.util.ArrayList;

public class DataManager {

    // ===== Faculties =====
    public static ArrayList<faculty> getFaculties() {
        ArrayList<faculty> list = new ArrayList<>();
        list.add(new faculty(R.drawable.fhc,  "Faculty of Hydrocarbons and Chemistry",          "3 Departments"));
        list.add(new faculty(R.drawable.inimm, "Faculty of Science",                             "3 Departments"));
        list.add(new faculty(R.drawable.ft,    "Faculty of Technologies",                        "3 Departments"));
        list.add(new faculty(R.drawable.igee,  "Institute of Electrical and Electronic Eng.",    "2 Departments"));
        list.add(new faculty(R.drawable.fd,    "Faculty of Law and Political Science",           "2 Departments"));
        list.add(new faculty(R.drawable.fll,   "Faculty of Arts and Languages",                  "2 Departments"));
        list.add(new faculty(R.drawable.img_1, "Institute of Applied Sciences and Technologies", "1 Departments"));
        return list;
    }

    // ===== Search Data =====
    // لما يكمل زميلك أضف الأقسام هنا فقط
    public static String[][] getSearchData() {
        return new String[][] {
                // {الاسم, النوع, اسم الـ faculty الأب}
                {"Faculty of Hydrocarbons and Chemistry",          "Faculty",    ""},
                {"Faculty of Science",                             "Faculty",    ""},
                {"Faculty of Technologies",                        "Faculty",    ""},
                {"Institute of Electrical and Electronic Eng.",    "Institute",  ""},
                {"Faculty of Law and Political Science",           "Faculty",    ""},
                {"Faculty of Arts and Languages",                  "Faculty",    ""},
                {"Institute of Applied Sciences and Technologies", "Institute",  ""},

                // ← زميلك يضيف هنا فقط
                // {"Computer Science", "Department", "Faculty of Science"},
                // {"Biology",          "Department", "Faculty of Science"},
        };
    }
}