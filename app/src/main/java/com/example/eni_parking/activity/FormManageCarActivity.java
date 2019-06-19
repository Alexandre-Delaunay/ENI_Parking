package com.example.eni_parking.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.eni_parking.AppDatabase;
import com.example.eni_parking.R;
import com.example.eni_parking.bo.Car;

public class FormManageCarActivity extends AppCompatActivity {

    private Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_manage_car);
    }

    @Override
    protected void onStart() {
        super.onStart();

        /*int car_id = getIntent().getIntExtra("CAR_ID", -1);

        car = AppDatabase.getAppDatabase(this).carDao().findCarWithId(car_id);

        ((EditText) findViewById(R.id.txtRegistrationNumber)).setText(car.getRegistrationNumber());
        ((EditText) findViewById(R.id.txtPrice)).setText(String.valueOf(car.getPrice()));*/

        //Button editButton = ((Button) findViewById(R.id.EditButton));

    }
}
