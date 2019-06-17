package com.example.eni_parking.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbOpenHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "PEOPLE_DB";

    public DbOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createPeople =
                "CREATE TABLE peoples (id INTEGER PRIMARY KEY AUTOINCREMENT, first_name TEXT, last_name TEXT)";

        sqLiteDatabase.execSQL(createPeople);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
