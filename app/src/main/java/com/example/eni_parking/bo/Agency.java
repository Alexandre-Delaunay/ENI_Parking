package com.example.eni_parking.bo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;


@Entity(tableName = "agency")
public class Agency implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String phone;
    private String address;

    public Agency() {
    }

    public Agency(String name) {
        this.setName(name);
    }

    public Agency(String name, String phone) {
        this.setName(name);
        this.setPhone(phone);
    }

    public Agency(String name, String phone, String address) {
        this.setName(name);
        this.setPhone(phone);
        this.setAddress(address);
    }

    public Agency(int id, String name, String phone, String address) {
        this.setId(id);
        this.setName(name);
        this.setPhone(phone);
        this.setAddress(address);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Agency{" +
                "_id=" + id +
                ", _name='" + name + '\'' +
                ", _phone='" + phone + '\'' +
                ", _address='" + address + '\'' +
                '}';
    }
}
