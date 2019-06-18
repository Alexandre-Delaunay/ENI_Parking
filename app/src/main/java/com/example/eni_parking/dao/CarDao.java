package com.example.eni_parking.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.eni_parking.GlobalApplication;
import com.example.eni_parking.bo.Car;
import com.example.eni_parking.service.DbOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class CarDao implements IDao<Car>{

    private SQLiteDatabase db;
    private CarTypeDao carTypeDao;

    public CarDao(Context context) {
        db = new DbOpenHelper(context).getWritableDatabase();
        carTypeDao = new CarTypeDao(GlobalApplication.getAppContext());
    }

    @Override
    public Car getById(int id) {

        Car car = new Car();
        List<Integer> lstIdCarType = new ArrayList<>();

        Cursor cursor = db.query(
                "car",
                new String[]{"id", "picture", "registrationNumber", "price", "isBooked", "idCarType"},
                "id=?",
                new String[]{String.valueOf(id)},
                null, null, null);


        if (cursor.moveToFirst()) {
            car.setPicture(cursor.getString(cursor.getColumnIndex("picture")));
            car.setRegistrationNumberk(cursor.getString(cursor.getColumnIndex("registrationNumber")));
            car.setPrice(cursor.getDouble(cursor.getColumnIndex("price")));
            car.setIsBooked(cursor.getInt(cursor.getColumnIndex("isBooked")));
            lstIdCarType.add(cursor.getInt(cursor.getColumnIndex("idCarType")));
        }

        car.setIdCarType(lstIdCarType);

        return car;
    }

    @Override
    public List<Car> getList() {

        Cursor cursor = db.query(
                "car",
                new String[]{"id", "picture", "registrationNumber", "price", "isBooked", "idCarType"},
                null,
                null,
                null, null, null);

        List<Car> lstCar = new ArrayList<>();

        while (cursor.moveToNext()) {
            Car car = new Car();
            car.setId(cursor.getInt(cursor.getColumnIndex("id")));
            car.setPicture(cursor.getString(cursor.getColumnIndex("picture")));
            car.setRegistrationNumberk(cursor.getString(cursor.getColumnIndex("registrationNumber")));
            car.setPrice(cursor.getDouble(cursor.getColumnIndex("price")));
            car.setIsBooked(cursor.getInt(cursor.getColumnIndex("isBooked")));

            //TODO: lstIdCarType, add table

            lstCar.add(car);
        }

        return lstCar;
    }

    @Override
    public int update(Car car) {

        ContentValues content = new ContentValues();
        content.put("picture", car.getPicture());
        content.put("registrationNumber", car.getRegistrationNumberk());
        content.put("price", car.getPrice());
        content.put("isBooked", car.getIsBooked());

        //TODO: lstIdCarType

        return db.update(
                "people",
                content,
                "id=?",
                new String[] { String.valueOf(car.getId()) }
        );
    }

    @Override
    public int insert(Car car) {

        ContentValues values = new ContentValues();
        values.put("picture", car.getPicture());
        values.put("registrationNumber", car.getRegistrationNumberk());
        values.put("price", car.getPrice());
        values.put("isBooked", car.getIsBooked());

        return (int) db.insert("car", null, values);
    }

    @Override
    public int delete(Car car) {

        return db.delete(
                "people",
                "id=?",
                new String[] { String.valueOf(car.getId()) }
        );
    }
}
