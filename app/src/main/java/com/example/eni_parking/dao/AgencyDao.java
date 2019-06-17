package com.example.eni_parking.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.eni_parking.bo.Agency;
import com.example.eni_parking.service.DbOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class AgencyDao implements IDao<Agency> {

    private SQLiteDatabase db;

    public AgencyDao(Context context) {
        db = new DbOpenHelper(context).getWritableDatabase();
    }

    @Override
    public Agency getById(int id) {
        Agency agency = new Agency();

        Cursor cursor = db.query(
                "agency",
                new String[]{"id", "type"},
                "id=?",
                new String[]{String.valueOf(id)},
                null, null, null);


        if (cursor.moveToFirst()) {
            agency.setName(cursor.getString(cursor.getColumnIndex("name")));
            agency.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
            agency.setAddress(cursor.getString(cursor.getColumnIndex("address")));
        }

        return agency;
    }

    @Override
    public List getList() {
        Cursor cursor = db.query(
                "agency",
                new String[]{"id", "type"},
                null,
                null,
                null, null, null);

        List<Agency> listAgency = new ArrayList<>();

        while (cursor.moveToNext()) {
            Agency agency = new Agency();
            agency.setId((int) cursor.getLong(cursor.getColumnIndex("id")));
            agency.setName(cursor.getString(cursor.getColumnIndex("name")));
            agency.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
            agency.setAddress(cursor.getString(cursor.getColumnIndex("address")));

            listAgency.add(agency);
        }

        return listAgency;
    }

    @Override
    public int update(Agency agency) {
        ContentValues content = new ContentValues();
        content.put("name", agency.getName());
        content.put("phone", agency.getPhone());
        content.put("address", agency.getAddress());

        return db.update(
                "agency",
                content,
                "id=?",
                new String[] { String.valueOf(agency.getId()) }
        );
    }

    @Override
    public int insert(Agency agency) {
        ContentValues values = new ContentValues();
        values.put("name", agency.getName());
        values.put("phone", agency.getPhone());
        values.put("address", agency.getAddress());

        return (int) db.insert("agency", null, values);
    }

    @Override
    public int delete(Agency agency) {
        return db.delete(
                "agency",
                "id=?",
                new String[] { String.valueOf(agency.getId()) }
        );
    }
}
