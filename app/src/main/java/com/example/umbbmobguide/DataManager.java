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

    // ===== Departments =====
    public static ArrayList<Department> getDepartments(String facultyName) {
        ArrayList<Department> list = new ArrayList<>();

        switch (facultyName) {

            case "Faculty of Hydrocarbons and Chemistry":
                list.add(new Department("Seismic Engineering", "Studies earthquake-resistant structures.",
                        "+213 24 81 66 11", "parasismique@univ-boumerdes.dz",
                        "Boumerdes University Campus", 36.7538, 3.4774,
                        makeList("Structural Analysis", "Seismic Risk")));
                list.add(new Department("Hydrocarbon Transport", "Studies pipeline and transport systems.",
                        "+213 24 81 66 12", "transport@univ-boumerdes.dz",
                        "Boumerdes University Campus", 36.7538, 3.4774,
                        makeList("Pipeline Engineering", "Fluid Mechanics")));
                list.add(new Department("Chemical Process Engineering", "Studies chemical production processes.",
                        "+213 24 81 66 13", "chimie@univ-boumerdes.dz",
                        "Boumerdes University Campus", 36.7538, 3.4774,
                        makeList("Thermodynamics", "Reaction Engineering")));
                break;

            case "Faculty of Science":
                list.add(new Department("Computer Science", "Studies algorithms, programming, and software.",
                        "+213 24 81 66 21", "info@univ-boumerdes.dz",
                        "Boumerdes University Campus", 36.7538, 3.4774,
                        makeList("Algorithms", "Networks", "Artificial Intelligence")));
                list.add(new Department("Mathematics", "Studies pure and applied mathematics.",
                        "+213 24 81 66 22", "maths@univ-boumerdes.dz",
                        "Boumerdes University Campus", 36.7538, 3.4774,
                        makeList("Analysis", "Algebra", "Statistics")));
                list.add(new Department("Physics", "Studies matter, energy, and natural phenomena.",
                        "+213 24 81 66 23", "physique@univ-boumerdes.dz",
                        "Boumerdes University Campus", 36.7538, 3.4774,
                        makeList("Quantum Physics", "Optics", "Mechanics")));
                break;

            case "Faculty of Technologies":
                list.add(new Department("Mechanical Engineering", "Studies design and manufacturing of machines.",
                        "+213 24 81 66 31", "mecanique@univ-boumerdes.dz",
                        "Boumerdes University Campus", 36.7538, 3.4774,
                        makeList("Machine Design", "Manufacturing", "Thermodynamics")));
                list.add(new Department("Process Engineering", "Studies industrial transformation processes.",
                        "+213 24 81 66 32", "procedes@univ-boumerdes.dz",
                        "Boumerdes University Campus", 36.7538, 3.4774,
                        makeList("Heat Transfer", "Mass Transfer")));
                list.add(new Department("Electrical Engineering", "Studies electrical systems and power.",
                        "+213 24 81 66 33", "electrique@univ-boumerdes.dz",
                        "Boumerdes University Campus", 36.7538, 3.4774,
                        makeList("Power Systems", "Control Systems")));
                break;

            case "Institute of Electrical and Electronic Eng.":
                list.add(new Department("Basic Education", "Covers foundational engineering sciences.",
                        "+213 24 81 66 41", "base@univ-boumerdes.dz",
                        "Boumerdes University Campus", 36.7538, 3.4774,
                        makeList("Mathematics", "Physics", "Informatics")));
                list.add(new Department("Electronics", "Studies electronic circuits and systems.",
                        "+213 24 81 66 42", "electronique@univ-boumerdes.dz",
                        "Boumerdes University Campus", 36.7538, 3.4774,
                        makeList("Analog Electronics", "Digital Electronics", "Embedded Systems")));
                break;

            case "Faculty of Law and Political Science":
                list.add(new Department("Public Law", "Studies constitutional and administrative law.",
                        "+213 24 81 66 51", "droit.public@univ-boumerdes.dz",
                        "Boumerdes University Campus", 36.7538, 3.4774,
                        makeList("Constitutional Law", "Administrative Law")));
                list.add(new Department("Private Law", "Studies civil and commercial law.",
                        "+213 24 81 66 52", "droit.prive@univ-boumerdes.dz",
                        "Boumerdes University Campus", 36.7538, 3.4774,
                        makeList("Civil Law", "Commercial Law")));
                break;

            case "Faculty of Arts and Languages":
                list.add(new Department("French", "Studies French language and literature.",
                        "+213 24 81 66 61", "francais@univ-boumerdes.dz",
                        "Boumerdes University Campus", 36.7538, 3.4774,
                        makeList("French Literature", "Linguistics", "Translation")));
                list.add(new Department("English", "Studies English language and literature.",
                        "+213 24 81 66 62", "anglais@univ-boumerdes.dz",
                        "Boumerdes University Campus", 36.7538, 3.4774,
                        makeList("English Literature", "Linguistics", "Translation")));
                break;

            case "Institute of Applied Sciences and Technologies":
                list.add(new Department("Metrology and Quality", "Studies measurement systems and quality control.",
                        "+213 24 81 66 71", "metrologie@univ-boumerdes.dz",
                        "Boumerdes University Campus", 36.7538, 3.4774,
                        makeList("Measurement Systems", "Quality Control", "Standardization")));
                break;
        }

        return list;
    }

    // helper to quickly build a specialties list
    private static ArrayList<String> makeList(String... items) {
        ArrayList<String> list = new ArrayList<>();
        for (String item : items) list.add(item);
        return list;
    }

    // ===== Search Data =====
    public static String[][] getSearchData() {
        return new String[][] {
                {"Faculty of Hydrocarbons and Chemistry",          "Faculty",    ""},
                {"Faculty of Science",                             "Faculty",    ""},
                {"Faculty of Technologies",                        "Faculty",    ""},
                {"Institute of Electrical and Electronic Eng.",    "Institute",  ""},
                {"Faculty of Law and Political Science",           "Faculty",    ""},
                {"Faculty of Arts and Languages",                  "Faculty",    ""},
                {"Institute of Applied Sciences and Technologies", "Institute",  ""},
                {"Seismic Engineering",          "Department", "Faculty of Hydrocarbons and Chemistry"},
                {"Hydrocarbon Transport",        "Department", "Faculty of Hydrocarbons and Chemistry"},
                {"Chemical Process Engineering", "Department", "Faculty of Hydrocarbons and Chemistry"},
                {"Computer Science",             "Department", "Faculty of Science"},
                {"Mathematics",                  "Department", "Faculty of Science"},
                {"Physics",                      "Department", "Faculty of Science"},
                {"Mechanical Engineering",       "Department", "Faculty of Technologies"},
                {"Process Engineering",          "Department", "Faculty of Technologies"},
                {"Electrical Engineering",       "Department", "Faculty of Technologies"},
                {"Basic Education",              "Department", "Institute of Electrical and Electronic Eng."},
                {"Electronics",                  "Department", "Institute of Electrical and Electronic Eng."},
                {"Public Law",                   "Department", "Faculty of Law and Political Science"},
                {"Private Law",                  "Department", "Faculty of Law and Political Science"},
                {"French",                       "Department", "Faculty of Arts and Languages"},
                {"English",                      "Department", "Faculty of Arts and Languages"},
                {"Metrology and Quality",        "Department", "Institute of Applied Sciences and Technologies"},
        };
    }
}