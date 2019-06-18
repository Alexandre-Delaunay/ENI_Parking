package com.example.eni_parking.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.eni_parking.bo.Rental;

import java.util.List;

@Dao
public interface RentalDao {
    @Query("SELECT * FROM rental WHERE id = :id")
    public Rental findRentalWithId(int id);

    @Query("SELECT * FROM rental")
    public List<Rental> getAllRental();

    @Update
    public int update(Rental rental);

    @Insert
    public int insert(Rental rental);

    @Delete
    public int delete(Rental rental);
}
