package com.example.eni_parking.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

        int car_id = getIntent().getIntExtra("CAR_ID", -1);

        car = AppDatabase.getAppDatabase(this).carDao().findCarWithId(car_id);

        if(car!=null){
            ((EditText) findViewById(R.id.txtRegistrationNumber)).setText(car.getRegistrationNumber());
            ((EditText) findViewById(R.id.txtPrice)).setText(String.valueOf(car.getPrice()));
        }

        Button editButton = ((Button) findViewById(R.id.EditButton));


        final FormManageCarActivity context = this;
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Add in database
                Car car = new Car();
                String registrationNumber = ((EditText) findViewById(R.id.txtRegistrationNumber)).getText().toString();
                car.setRegistrationNumber(registrationNumber);
                double price = Double.parseDouble(((EditText) findViewById(R.id.txtPrice)).getText().toString());
                car.setPrice(price);

                AppDatabase.getAppDatabase(context).carDao().insertCar(car);

                // redirect
                Intent intent = new Intent(context,ListCarActivity.class);
                context.startActivityForResult(intent,2);
            }
        });
    }
}
