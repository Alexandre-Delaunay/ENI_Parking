package com.example.eni_parking.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.eni_parking.bo.Customer;

import java.util.List;

@Dao
public interface CustomerDao {
    @Insert(onConflict=OnConflictStrategy.REPLACE)
    public void insertCustomer(Customer customer);

    @Update
    public void updateCustomer(Customer customer);

    @Delete
    public void deleteUsers(Customer customer);

    @Query("SELECT * FROM customer")
    public Customer[] loadAllCustomer();

    @Query("SELECT * FROM customer WHERE id = :id")
    public List<Customer> findCustomerWithId(Integer id);
}
