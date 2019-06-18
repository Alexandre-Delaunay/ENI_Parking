package com.example.eni_parking.dao;

import android.arch.persistence.room.Entity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.eni_parking.bo.Customer;
import com.example.eni_parking.bo.Manager;
import com.example.eni_parking.service.DbOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements IDao<Customer> {

    private SQLiteDatabase db;

    public CustomerDao(Context context) {
        db = new DbOpenHelper(context).getWritableDatabase();
    }

    @Override
    public Customer getById(int id) {
        Customer customer = new Customer();

        Cursor cursor = db.query(
                "customer",
                new String[]{"id", "firstname", "lastname"},
                "id=?",
                new String[]{String.valueOf(id)},
                null, null, null);

        if (cursor.moveToFirst()) {
            customer.setId(cursor.getInt(cursor.getColumnIndex("id")));
            customer.setLastname(cursor.getString(cursor.getColumnIndex("lastname")));
            customer.setFirstname(cursor.getString(cursor.getColumnIndex("firstname")));
        }
        return customer;
    }

    @Override
    public List<Customer> getList() {
        Cursor cursor = db.query(
                "customer",
                new String[]{"id", "firstname", "lastname"},
                null,
                null,
                null, null, null);

        List<Customer> lstCustomer = new ArrayList<>();

        while (cursor.moveToNext()) {
            Customer customer = new Customer();
            customer.setId((int) cursor.getLong(cursor.getColumnIndex("id")));
            customer.setLastname(cursor.getString(cursor.getColumnIndex("lastname")));
            customer.setFirstname(cursor.getString(cursor.getColumnIndex("firstname")));

            lstCustomer.add(customer);
        }

        return lstCustomer;
    }

    @Override
    public int update(Customer customer) {
        ContentValues content = new ContentValues();
        content.put("firstname", customer.getFirstname());
        content.put("lastname", customer.getLastname());

        return db.update(
                "customer",
                content,
                "id=?",
                new String[] { String.valueOf(customer.getId()) }
        );
    }

    @Override
    public int insert(Customer customer) {
        ContentValues values = new ContentValues();
        values.put("firstname", customer.getFirstname());
        values.put("lastname", customer.getLastname());

        return (int) db.insert("customer", null, values);
    }

    @Override
    public int delete(Customer customer) {
        return db.delete(
                "customer",
                "id=?",
                new String[] { String.valueOf(customer.getId()) }
        );
    }
}
