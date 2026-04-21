package com.example.listy;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class KawiarniaDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "coffeina";
    private static final int DB_VERSION = 3;

    KawiarniaDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
    }

    private static void insertDrink(SQLiteDatabase db, String name,
                                    String description, int resourceId) {
        ContentValues drinkValues = new ContentValues();
        drinkValues.put("NAME", name);
        drinkValues.put("DESCRIPTION", description);
        drinkValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("DRINK", null, drinkValues);
    }
    private static void insertSnack(SQLiteDatabase db, String name,
                                    String description, int resourceId) {
        ContentValues snackValues = new ContentValues();
        snackValues.put("NAME", name);
        snackValues.put("DESCRIPTION", description);
        snackValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("SNACK", null, snackValues);
    }
    private static void insertLocation(SQLiteDatabase db, String name, String address,
                                    String description, int resourceId) {
        ContentValues snackValues = new ContentValues();
        snackValues.put("NAME", name);
        snackValues.put("ADDRESS", address);
        snackValues.put("DESCRIPTION", description);
        snackValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("SNACK", null, snackValues);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE DRINK (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER);");
            insertDrink(db, "Latte",
                    "Czarne espresso z gorącym mlekiem i mleczną pianką.",
                    R.drawable.latte);
            insertDrink(db, "Cappuccino",
                    "Czarne espresso z dużą ilością spienionego mleka.",
                    R.drawable.cappuccino);
            insertDrink(db, "Espresso",
                    "Czarna kawa ze świeżo mielonych ziaren najwyższej jakości.",
                    R.drawable.espresso);

        }
        if(oldVersion < 2){
            db.execSQL("CREATE TABLE SNACK (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER);");
            insertSnack(db, "Brownie",
                    "Ciasto z ciemnej czekolady i kakao.",
                    R.drawable.brownie);
            insertSnack(db, "Sernik na zimno",
                    "Zimne, kremowe ciasto z słodkiego twarogu z biszkoptowym spodem i owocową galaretką.",
                    R.drawable.sernik);
            insertSnack(db, "Biszkopt z jabłkami",
                    "Lekkie, puszyste ciasto na bazie kurzych białek z słodkimi jabłkami na wierzchu.",
                    R.drawable.biszkopt);
            db.execSQL("CREATE TABLE LOCATION (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "ADDRESS TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER);");
            insertLocation(db,"Tociekawa","Kraków, Długa 37","Kawiarnia o swobodnej atmosferze oferująca szeroki wybór napojów zimnych i gorących oraz ciast i przekąsek.",R.drawable.tociekawka);
            insertLocation(db,"Czyżyk","Kraków, Bolesława Orlińskiego","Fantastycka sąsiedzka kawiarnia na Avii, ze świetne śniadania, pyszną kawę i świeże wypieki.",R.drawable.czyzyk);
            insertLocation(db,"COFEE GARDEN ","Kraków, Józefa 11","Kawiarnia z fajnym klimatem i przede wszystkim serwująca różne alternatywne kawy.",R.drawable.cofee_garden);

        }
        if (oldVersion < 3) {
            db.execSQL("ALTER TABLE DRINK ADD COLUMN FAVORITE NUMERIC;");
            db.execSQL("ALTER TABLE LOCATION ADD COLUMN FAVORITE NUMERIC;");
            db.execSQL("ALTER TABLE SNACK ADD COLUMN FAVORITE NUMERIC;");
        }
    }
}
