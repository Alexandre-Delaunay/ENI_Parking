package com.example.eni_parking.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.eni_parking.bo.CarType;

import java.util.List;

//@Dao
public interface CarTypeDao {
    //@Insert(onConflict= OnConflictStrategy.REPLACE)
    public void insertCarType(CarType customer);

    //@Update
    public void updateCar(CarType customer);

    //@Delete
    public void deleteCar(CarType customer);

    //@Query("SELECT * FROM CarTypes")
    public CarType[] loadAllCar();

    //@Query("SELECT * FROM cars WHERE id = :id")
    public List<CarType> findCarWithId(Integer id);
}
