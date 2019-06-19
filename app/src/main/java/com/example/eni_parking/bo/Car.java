package com.example.eni_parking.bo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;


@Entity(tableName = "Cars")
public class Car implements Parcelable {

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


    @ForeignKey(
            entity = CarType.class,
            parentColumns = "id",
            deferred = false,
            childColumns = "carType_id"
    )
    private int carType_id;

    protected Car(Parcel in) {
        id = in.readInt();
        picture = in.readString();
        registrationNumber = in.readString();
        price = in.readDouble();
        isBooked = in.readInt();
        agency_id = in.readInt();
    }


    public Car() {
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

    public int getCarType_id() {
        return carType_id;
    }

    public void setCarType_id(int carType_id) {
        this.carType_id = carType_id;
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

    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(picture);
        parcel.writeString(registrationNumber);
        parcel.writeDouble(price);
        parcel.writeInt(isBooked);
        parcel.writeInt(agency_id);
        parcel.writeInt(carType_id);
    }

    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };
}
