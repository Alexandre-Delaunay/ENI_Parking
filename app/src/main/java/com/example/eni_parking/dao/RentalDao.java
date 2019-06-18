package com.example.eni_parking.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.eni_parking.bo.Rental;
import com.example.eni_parking.service.DbOpenHelper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class RentalDao implements IDao<Rental> {

    private SQLiteDatabase db;

    public RentalDao(Context context) {
        db = new DbOpenHelper(context).getWritableDatabase();
    }

    @Override
    public Rental getById(int id) {
        Rental rental = new Rental();

        Cursor cursor = db.query(
                "rental",
                new String[]{"id", "customer_id", "car_id", "dateBegin", "dateEnd", "pictureBefore", "pictureAfter"},
                "id=?",
                new String[]{String.valueOf(id)},
                null, null, null);


        if (cursor.moveToFirst()) {
            rental.setId((int) cursor.getLong(cursor.getColumnIndex("id")));
            rental.setCustomer_id((int)cursor.getLong(cursor.getColumnIndex("customer_id")));
            rental.setCar_id((int)cursor.getLong(cursor.getColumnIndex("car_id")));
            try {
                rental.setDateBegin(new SimpleDateFormat("dd/MM/yyyy").parse(cursor.getString(cursor.getColumnIndex("dateBegin"))));
            } catch (ParseException e) {
                rental.setDateBegin(null);
                e.printStackTrace();
            }
            try {
                rental.setDateEnd(new SimpleDateFormat("dd/MM/yyyy").parse(cursor.getString(cursor.getColumnIndex("dateEnd"))));
            } catch (ParseException e) {
                rental.setDateEnd(null);
                e.printStackTrace();
            }
            rental.setPictureBefore(cursor.getString(cursor.getColumnIndex("pictureBefore")));
            rental.setPictureBefore(cursor.getString(cursor.getColumnIndex("pictureAfter")));
        }

        return rental;
    }

    @Override
    public List<Rental> getList() {
        Cursor cursor = db.query(
                "rental",
                new String[]{"id", "customer_id", "car_id", "dateBegin", "dateEnd", "pictureBefore", "pictureAfter"},
                null,
                null,
                null, null, null);

        List<Rental> listRental = new ArrayList<>();

        while (cursor.moveToNext()) {
            Rental rental = new Rental();
            rental.setId((int) cursor.getLong(cursor.getColumnIndex("id")));
            rental.setCustomer_id((int)cursor.getLong(cursor.getColumnIndex("customer_id")));
            rental.setCar_id((int)cursor.getLong(cursor.getColumnIndex("car_id")));
            try {
                rental.setDateBegin(new SimpleDateFormat("dd/MM/yyyy").parse(cursor.getString(cursor.getColumnIndex("dateBegin"))));
            } catch (ParseException e) {
                rental.setDateBegin(null);
                e.printStackTrace();
            }
            try {
                rental.setDateEnd(new SimpleDateFormat("dd/MM/yyyy").parse(cursor.getString(cursor.getColumnIndex("dateEnd"))));
            } catch (ParseException e) {
                rental.setDateEnd(null);
                e.printStackTrace();
            }
            rental.setPictureBefore(cursor.getString(cursor.getColumnIndex("pictureBefore")));
            rental.setPictureBefore(cursor.getString(cursor.getColumnIndex("pictureAfter")));

            listRental.add(rental);
        }

        return listRental;
    }

    @Override
    public int update(Rental rental) {
        DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");

        ContentValues content = new ContentValues();
        content.put("customer_id", rental.getCustomer_id());
        content.put("car_id", rental.getCar_id());
        if (rental.getDateBegin() != null){
            content.put("dateBegin", dateFormat.format(rental.getDateBegin()));
        }
        else{
            content.put("dateBegin", "");
        }
        content.put("dateEnd", dateFormat.format(rental.getDateEnd()));
        content.put("pictureBefore", rental.getPictureBefore());
        content.put("pictureAfter", rental.getPictureAfter());

        return db.update(
                "rental",
                content,
                "id=?",
                new String[] { String.valueOf(rental.getId()) }
        );
    }

    @Override
    public int insert(Rental rental) {
        DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");

        ContentValues values = new ContentValues();
        values.put("customer_id", rental.getCustomer_id());
        values.put("car_id", rental.getCar_id());
        values.put("dateBegin", dateFormat.format(rental.getDateBegin()));
        values.put("dateEnd", dateFormat.format(rental.getDateEnd()));
        values.put("pictureBefore", rental.getPictureBefore());
        values.put("pictureAfter", rental.getPictureAfter());

        return (int) db.insert("rental", null, values);
    }

    @Override
    public int delete(Rental rental) {
        return db.delete(
                "rental",
                "id=?",
                new String[] { String.valueOf(rental.getId()) }
        );
    }
}
