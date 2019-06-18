package com.example.eni_parking.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.eni_parking.R;
import com.example.eni_parking.bo.Car;
import com.example.eni_parking.dao.CarDao;
import com.example.eni_parking.database.AndroidVoitureDatabase;

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

        AndroidVoitureDatabase db = new AndroidVoitureDatabase();

        car = db.carDao().findCarWithId(car_id);

        ((TextView) findViewById(R.id.title)).setText(article.getTitle());
        ((TextView) findViewById(R.id.description)).setText(article.getDescription());
        ((TextView) findViewById(R.id.price)).setText(String.valueOf(article.getPrice()));
        ((ToggleButton) findViewById(R.id.bought)).setChecked(article.isBought());
        ((RatingBar) findViewById(R.id.rating)).setRating(article.getRating());

    }
}
