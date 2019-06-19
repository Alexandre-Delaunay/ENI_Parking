package com.example.eni_parking.activity;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.eni_parking.AppDatabase;
import com.example.eni_parking.R;
import com.example.eni_parking.bo.Car;
import com.example.eni_parking.bo.CarType;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        final AppDatabase db = AppDatabase.getAppDatabase(this);

        Button button = findViewById(R.id.button);
        final EditText editText   = findViewById(R.id.edit_message);

        final List<Car> lstCar = new ArrayList<>();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CarType carType = db.carTypeDao().findCarTypeByType(editText.getText().toString());

                lstCar.addAll(db.carDao().findCarByCarType(carType.getId()));
            }
        });

        Intent intent = new Intent(getApplicationContext(),SearchActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("dataFromSearchActivity", (Parcelable) lstCar);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
