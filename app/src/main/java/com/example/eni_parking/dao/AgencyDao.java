package com.example.eni_parking.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.eni_parking.bo.Agency;

import java.util.List;

@Dao
public interface AgencyDao {
    @Query("SELECT * FROM agency WHERE id = :id")
    public Agency findAgencyWithId(int id);

    @Query("SELECT * FROM agency")
    public List<Agency> getAllAgency();

    @Update
    public int update(Agency agency);

    @Insert
    public int insert(Agency agency);

    @Delete
    public int delete(Agency agency);
}
