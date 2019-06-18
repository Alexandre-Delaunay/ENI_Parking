package com.example.eni_parking.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.example.eni_parking.bo.CarAllCarType;

import java.util.List;

@Dao
public interface CarCarTypeDao {
    @Query("SELECT * from Cars")
    public List<CarAllCarType> loadCarAndCarTypes();
}
