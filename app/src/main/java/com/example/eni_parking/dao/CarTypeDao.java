package com.example.eni_parking.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.eni_parking.bo.CarType;
import com.example.eni_parking.service.DbOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class CarTypeDao implements IDao<CarType> {

    private SQLiteDatabase db;

    public CarTypeDao(Context context) {
        db = new DbOpenHelper(context).getWritableDatabase();
    }

    @Override
    public CarType getById(int id) {

        CarType carType = new CarType();

        Cursor cursor = db.query(
                "carType",
                new String[]{"id", "type"},
                "id=?",
                new String[]{String.valueOf(id)},
                null, null, null);


        if (cursor.moveToFirst()) {
            carType.setType(cursor.getString(cursor.getColumnIndex("type")));
        }

        return carType;
    }

    @Override
    public List getList() {

        Cursor cursor = db.query(
                "carType",
                new String[]{"id", "type"},
                null,
                null,
                null, null, null);

        List<CarType> lstCarType = new ArrayList<>();

        while (cursor.moveToNext()) {
            CarType carType = new CarType();
            carType.setId((int) cursor.getLong(cursor.getColumnIndex("id")));
            carType.setType(cursor.getString(cursor.getColumnIndex("type")));

            lstCarType.add(carType);
        }

        return lstCarType;
    }

    @Override
    public int update(CarType carType)
    {
        ContentValues content = new ContentValues();
        content.put("type", carType.getType());

        return db.update(
                "carType",
                content,
                "id=?",
                new String[] { String.valueOf(carType.getId()) }
        );
    }

    @Override
    public int insert(CarType carType) {
        ContentValues values = new ContentValues();
        values.put("type", carType.getType());

        return (int) db.insert("carType", null, values);
    }

    @Override
    public int delete(CarType carType) {
        return db.delete(
                "carType",
                "id=?",
                new String[] { String.valueOf(carType.getId()) }
        );
    }
}
