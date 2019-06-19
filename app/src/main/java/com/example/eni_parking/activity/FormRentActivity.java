package com.example.eni_parking.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.eni_parking.AppDatabase;
import com.example.eni_parking.R;
import com.example.eni_parking.bo.Car;
import com.example.eni_parking.bo.Customer;
import com.example.eni_parking.bo.Rental;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FormRentActivity extends AppCompatActivity {

    private Rental rental;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_rent_car);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Button valider = ((Button) findViewById(R.id.ValidateButton));

        int customer_id = getIntent().getIntExtra("RENTAL_ID", -1);
        int rental_id = getIntent().getIntExtra("RENTAL_ID", -1);
        Bundle intenvrjrei = getIntent().getExtras();
        final int car_id = getIntent().getIntExtra("CAR_ID", -1);

        rental = AppDatabase.getAppDatabase(this).rentalDao().findRentalWithId(rental_id);


        final FormRentActivity context = this;
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Add or Update in database
                String customer_firstname = ((EditText) findViewById(R.id.firstname)).getText().toString();
                String customer_lastname = ((EditText) findViewById(R.id.lastname)).getText().toString();
                String dateBegin = ((EditText) findViewById(R.id.dateBegin)).getText().toString();

                if(rental==null){
                    rental = new Rental();
                    rental.setDateBegin(dateBegin);

                    //Create customer if he doesn't exist.
                    Customer customer = AppDatabase.getAppDatabase(context).customerDao().findCustomerWithFirstnameLastname(customer_firstname, customer_lastname);
                    if(customer==null) {
                        customer = new Customer();
                        customer.setLastname(customer_lastname);
                        customer.setFirstname(customer_firstname);

                        AppDatabase.getAppDatabase(context).customerDao().insertCustomer(customer);
                    }
                    customer = AppDatabase.getAppDatabase(context).customerDao().findCustomerWithFirstnameLastname(customer_firstname, customer_lastname);

                    rental.setCustomer_id(customer.getId());
                    rental.setCar_id(car_id);
                    AppDatabase.getAppDatabase(context).rentalDao().insert(rental);

                    String stringrental = AppDatabase.getAppDatabase(context).rentalDao().getAllRental().toString();

                    Car car = AppDatabase.getAppDatabase(context).carDao().findCarWithId(car_id);
                    car.setIsBooked(1);
                    AppDatabase.getAppDatabase(context).carDao().updateCar(car);
                }
                else{
                    int car_id = rental.getCar_id();
                    Car car = AppDatabase.getAppDatabase(context).carDao().findCarWithId(car_id);
                    car.setIsBooked(0);

                    AppDatabase.getAppDatabase(context).carDao().updateCar(car);
                    AppDatabase.getAppDatabase(context).rentalDao().update(rental);
                }

                // redirect
                Intent intent = new Intent(context,ListCarActivity.class);
                context.startActivityForResult(intent,2);
            }
        });
    }
}
