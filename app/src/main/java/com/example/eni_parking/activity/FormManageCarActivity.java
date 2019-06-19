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
        Button editButton = ((Button) findViewById(R.id.EditButtonCar));

        int car_id = getIntent().getIntExtra("CAR_ID", -1);

        car = AppDatabase.getAppDatabase(this).carDao().findCarWithId(car_id);

        if(car!=null){
            ((EditText) findViewById(R.id.txtRegistrationNumber)).setText(car.getRegistrationNumber());
            ((EditText) findViewById(R.id.txtPrice)).setText(String.valueOf(car.getPrice()));

            editButton.setText("Modifier");
        }


        final FormManageCarActivity context = this;
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Add or Update in database
                String registrationNumber = ((EditText) findViewById(R.id.txtRegistrationNumber)).getText().toString();
                double price = Double.parseDouble(((EditText) findViewById(R.id.txtPrice)).getText().toString());

                if(car==null){
                    car = new Car();
                    car.setRegistrationNumber(registrationNumber);
                    car.setPrice(price);

                    AppDatabase.getAppDatabase(context).carDao().insertCar(car);
                }
                else{
                    car.setRegistrationNumber(registrationNumber);
                    car.setPrice(price);

                    AppDatabase.getAppDatabase(context).carDao().updateCar(car);
                }

                // redirect
                Intent intent = new Intent(context,ListCarActivity.class);
                context.startActivityForResult(intent,2);
            }
        });
    }
}