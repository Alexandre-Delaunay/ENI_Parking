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
        String createAgency =
                "CREATE TABLE agency (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phone TEXT, address TEXT)";
        sqLiteDatabase.execSQL(createAgency);

        String createCar =
                "CREATE TABLE car (id INTEGER PRIMARY KEY AUTOINCREMENT, picture TEXT, registrationNumber TEXT, price INTEGER, isBooked INTEGER)";
        sqLiteDatabase.execSQL(createCar);

        String createCarType =
                "CREATE TABLE carType(id INTEGER PRIMARY KEY AUTOINCREMENT, type TEXT)";
        sqLiteDatabase.execSQL(createCarType);

        String createCustomer =
                "CREATE TABLE customer(id INTEGER PRIMARY KEY AUTOINCREMENT, firstname TEXT, lastname TEXT)";
        sqLiteDatabase.execSQL(createCustomer);

        String createManager =
                "CREATE TABLE manager(id INTEGER PRIMARY KEY AUTOINCREMENT, firstname TEXT, lastname TEXT, phone TEXT, agencyID INTEGER)";
        sqLiteDatabase.execSQL(createManager);

        String createRental =
                "CREATE TABLE rental(id INTEGER PRIMARY KEY AUTOINCREMENT, customerID INTEGER, carID INTEGER, dateBegin TEXT, dateEnd TEXT, pictureBefore TEXT, pictureAfter TEXT)";
        sqLiteDatabase.execSQL(createRental);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
