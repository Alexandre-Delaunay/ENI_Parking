package com.example.eni_parking.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.eni_parking.AppDatabase;
import com.example.eni_parking.R;
import com.example.eni_parking.bo.Car;

import java.util.List;

public class Search extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TODO: get list by filter
                 //List<Car> AppDatabase.getAppDatabase(this).carDao().
            }
        });
    }


}
