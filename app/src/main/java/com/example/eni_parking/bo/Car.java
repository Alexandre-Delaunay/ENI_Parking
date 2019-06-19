package com.example.eni_parking.bo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;


@Entity(tableName = "Cars")
public class Car {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "picture")
    private String picture;

    @ColumnInfo(name = "registrationNumber")
    private String registrationNumber;

    @ColumnInfo(name = "price")
    private double price;

    @ColumnInfo(name = "isBooked")
    private int isBooked;

    @ForeignKey(
            entity = Agency.class,
            parentColumns = "id",
            deferred = false,
            childColumns = "agency_id"
    )
    private int agency_id;

    public Car(int id, String picture, String registrationNumber, double price, int isBooked, int agency_id) {
        this.id = id;
        this.picture = picture;
        this.registrationNumber = registrationNumber;
        this.price = price;
        this.isBooked = isBooked;
        this.agency_id = agency_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIsBooked() {
        return isBooked;
    }

    public void setIsBooked(int booked) {
        isBooked = booked;
    }

    public int getAgency_id() {
        return agency_id;
    }

    public void setAgency_id(int agency_id) {
        this.agency_id = agency_id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", picture='" + picture + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", price=" + price +
                ", isBooked=" + isBooked +
                ", agency_id=" + agency_id +
                '}';
    }
}
