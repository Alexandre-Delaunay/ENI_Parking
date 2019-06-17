package com.example.eni_parking.bo;

public class CarType {

    private int id;
    private String type;

    public CarType(){

    }

    public CarType(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CarType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
