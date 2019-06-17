package com.example.eni_parking.bo;

import java.math.BigDecimal;
import java.util.List;

public class Car {

    private int id;
    private String picture;
    private String registrationNumber;
    private BigDecimal price;
    private boolean isBooked;

    private List<Integer> idCarType;
    private CarType carType;

    public Car(){

    }

    public Car(int id, String picture, String registrationNumberk, BigDecimal price, boolean isBooked, CarType carType) {
        this.id = id;
        this.picture = picture;
        this.registrationNumber = registrationNumberk;
        this.price = price;
        this.isBooked = isBooked;
        this.carType = carType;
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

    public String getRegistrationNumberk() {
        return registrationNumber;
    }

    public void setRegistrationNumberk(String registrationNumberk) {
        this.registrationNumber = registrationNumberk;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public List<Integer> getIdCarType() {
        return idCarType;
    }

    public void setIdCarType(List<Integer> idCarType) {
        this.idCarType = idCarType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", picture='" + picture + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", price=" + price +
                ", isBooked=" + isBooked +
                ", idCarType=" + idCarType +
                ", carType=" + carType +
                '}';
    }
}
