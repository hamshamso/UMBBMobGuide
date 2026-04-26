package com.example.umbbmobguide;

import java.util.ArrayList;

public class DataManager {

    // ===== Faculties =====
    public static ArrayList<faculty> getFaculties() {
        ArrayList<faculty> list = new ArrayList<>();

        list.add(new faculty(R.drawable.fhc,
                "Faculty of Hydrocarbons and Chemistry", "3 Departments",
                "This faculty covers hydrocarbon transport, seismic engineering, and chemical process engineering.",
                "+213 24 81 66 10", "fhc@univ-boumerdes.dz",
                "Boumerdes University Campus", 36.7538, 3.4774));

        list.add(new faculty(R.drawable.inimm,
                "Faculty of Science", "3 Departments",
                "This faculty covers computer science, mathematics, and physics.",
                "+213 24 81 66 20", "science@univ-boumerdes.dz",
                "Boumerdes University Campus", 36.7538, 3.4774));

        list.add(new faculty(R.drawable.ft,
                "Faculty of Technologies", "3 Departments",
                "This faculty covers mechanical engineering, electrical engineering, and process engineering.",
                "+213 24 81 66 30", "tech@univ-boumerdes.dz",
                "Boumerdes University Campus", 36.7538, 3.4774));

        list.add(new faculty(R.drawable.igee,
                "Institute of Electrical and Electronic Eng.", "2 Departments",
                "This institute covers basic education and electronics engineering.",
                "+213 24 81 66 40", "igee@univ-boumerdes.dz",
                "Boumerdes University Campus", 36.7538, 3.4774));

        list.add(new faculty(R.drawable.fd,
                "Faculty of Law and Political Science", "2 Departments",
                "This faculty covers public law and private law.",
                "+213 24 81 66 50", "law@univ-boumerdes.dz",
                "Boumerdes University Campus", 36.7538, 3.4774));

        list.add(new faculty(R.drawable.fll,
                "Faculty of Arts and Languages", "2 Departments",
                "This faculty covers French and English language studies.",
                "+213 24 81 66 60", "languages@univ-boumerdes.dz",
                "Boumerdes University Campus", 36.7538, 3.4774));

        list.add(new faculty(R.drawable.img_1,
                "Institute of Applied Sciences and Technologies", "1 Departments",
                "This institute covers metrology and quality control.",
                "+213 24 81 66 70", "ista@univ-boumerdes.dz",
                "Boumerdes University Campus", 36.7538, 3.4774));

        return list;
    }

    // ===== Search Data =====
    public static String[][] getSearchData() {
        return new String[][] {
                {"Faculty of Hydrocarbons and Chemistry",          "Faculty",   ""},
                {"Faculty of Science",                             "Faculty",   ""},
                {"Faculty of Technologies",                        "Faculty",   ""},
                {"Institute of Electrical and Electronic Eng.",    "Institute", ""},
                {"Faculty of Law and Political Science",           "Faculty",   ""},
                {"Faculty of Arts and Languages",                  "Faculty",   ""},
                {"Institute of Applied Sciences and Technologies", "Institute", ""},
        };
    }
}