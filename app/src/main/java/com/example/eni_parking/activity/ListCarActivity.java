package com.example.eni_parking.activity;

import android.app.LauncherActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import com.example.eni_parking.AppDatabase;
import com.example.eni_parking.R;
import com.example.eni_parking.adapter.ListCarAdapter;
import com.example.eni_parking.bo.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListCarActivity extends AppCompatActivity {

    List<Car> lstCar;
    ListCarAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.car_list);

        final ListCarActivity context = this;

        lstCar = new ArrayList<>();

        lstCar = Arrays.asList(AppDatabase.getAppDatabase(context).carDao().loadAllCar());

        /*Car car = new Car();
        car.setId(1);
        car.setRegistrationNumber("deux");
        car.setPicture("trois");
        car.setAgency_id(4);
        car.setIsBooked(0);
        car.setPrice(1.2);
        car.setCarType_id(1);
        lstCar.add(car);*/

        ListView list = findViewById(R.id.lstcar);

        adapter = new ListCarAdapter(this, R.layout.lstcar_item, lstCar);

        list.setAdapter(adapter);
    }

    void addElement(Car car) {
        lstCar.add(car);
        adapter.notifyDataSetChanged();
    }
}
