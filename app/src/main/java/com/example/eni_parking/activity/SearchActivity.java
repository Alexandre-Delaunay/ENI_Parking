package com.example.eni_parking.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.eni_parking.AppDatabase;
import com.example.eni_parking.R;
import com.example.eni_parking.bo.Car;
import com.example.eni_parking.bo.CarType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private AppDatabase db;
    private Button button;
    private Spinner spinner;
    private List<Car> lstCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        db = AppDatabase.getAppDatabase(this);

        button = findViewById(R.id.button);
        spinner = findViewById(R.id.dpCarType);

        ArrayAdapter<CarType> spinnerArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, AppDatabase.getAppDatabase(this).carTypeDao().loadAllCarType());

        spinner.setAdapter(spinnerArrayAdapter);

        lstCar = new ArrayList<>();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartSearch();
            }
        });
    }

    private void StartSearch(){

        CarType carType = (CarType)spinner.getSelectedItem();

        lstCar.addAll(db.carDao().findCarByCarType(carType.getId()));

        if(lstCar != null && !lstCar.isEmpty()){
            Intent intent = new Intent(getApplicationContext(),ListCarActivity.class);
            intent.putExtra("listCarFromSearch", (Serializable) lstCar);
            startActivity(intent);
        }
    }
}
