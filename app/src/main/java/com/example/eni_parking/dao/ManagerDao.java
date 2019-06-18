package com.example.eni_parking.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.eni_parking.bo.CarType;
import com.example.eni_parking.bo.Manager;
import com.example.eni_parking.service.DbOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class ManagerDao implements IDao<Manager> {

    private SQLiteDatabase db;

    public ManagerDao(Context context) {
        db = new DbOpenHelper(context).getWritableDatabase();
    }

    @Override
    public Manager getById(int id) {
        Manager manager = new Manager();

        Cursor cursor = db.query(
                "manager",
                new String[]{"id", "firstname", "lastname", "phone", "agencyID"},
                "id=?",
                new String[]{String.valueOf(id)},
                null, null, null);

        if (cursor.moveToFirst()) {
            manager.setAgencyID(cursor.getInt(cursor.getColumnIndex("agencyID")));
            manager.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
            manager.setId(cursor.getInt(cursor.getColumnIndex("id")));
            manager.setLastname(cursor.getString(cursor.getColumnIndex("lastname")));
            manager.setFirstname(cursor.getString(cursor.getColumnIndex("firstname")));
        }
        return manager;
    }

    @Override
    public List getList() {
        Cursor cursor = db.query(
                "manager",
                new String[]{"id", "firstname", "lastname", "phone", "agencyID"},
                null,
                null,
                null, null, null);

        List<Manager> lstManager = new ArrayList<>();

        while (cursor.moveToNext()) {
            Manager manager = new Manager();
            manager.setId((int) cursor.getLong(cursor.getColumnIndex("id")));
            manager.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
            manager.setAgencyID(cursor.getInt(cursor.getColumnIndex("agencyID")));
            manager.setLastname(cursor.getString(cursor.getColumnIndex("lastname")));
            manager.setFirstname(cursor.getString(cursor.getColumnIndex("firstname")));

            lstManager.add(manager);
        }

        return lstManager;
    }

    @Override
    public int update(Manager manager) {
        ContentValues content = new ContentValues();
        content.put("agencyID", manager.getAgencyID());
        content.put("firstname", manager.getFirstname());
        content.put("lastname", manager.getLastname());
        content.put("phone", manager.getPhone());

        return db.update(
                "manager",
                content,
                "id=?",
                new String[] { String.valueOf(manager.getId()) }
        );
    }

    @Override
    public int insert(Manager manager) {
        ContentValues values = new ContentValues();
        values.put("agencyID", manager.getAgencyID());
        values.put("firstname", manager.getFirstname());
        values.put("lastname", manager.getLastname());
        values.put("phone", manager.getPhone());

        return (int) db.insert("manager", null, values);
    }

    @Override
    public int delete(Manager manager) {
        return db.delete(
                "manager",
                "id=?",
                new String[] { String.valueOf(manager.getId()) }
        );
    }
}
