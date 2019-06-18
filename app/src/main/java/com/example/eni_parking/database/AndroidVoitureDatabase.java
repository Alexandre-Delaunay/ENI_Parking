package com.example.eni_parking.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.eni_parking.bo.Agency;
import com.example.eni_parking.bo.Car;
import com.example.eni_parking.bo.Customer;
import com.example.eni_parking.bo.Manager;
import com.example.eni_parking.bo.Rental;
import com.example.eni_parking.dao.AgencyDao;
import com.example.eni_parking.dao.CarDao;
import com.example.eni_parking.dao.CustomerDao;
import com.example.eni_parking.dao.ManagerDao;
import com.example.eni_parking.dao.RentalDao;

@Database(entities = {Agency.class, Car.class, Customer.class, Manager.class , Rental.class}, version = 1)
public abstract class AndroidVoitureDatabase extends RoomDatabase {
    public abstract AgencyDao agencyDao();

    public abstract CarDao carDao();

    public abstract CustomerDao customerDao();

    public abstract RentalDao rentalDao();

    public abstract ManagerDao managerDao();
}
