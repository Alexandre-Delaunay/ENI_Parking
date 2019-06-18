package com.example.eni_parking.bo;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class CarAllCarType {
    @Embedded
    public Car car;
    @Relation(parentColumn = "id", entityColumn = "carId", entity = Car.class)
    public List<CarType> carTypes;
}
