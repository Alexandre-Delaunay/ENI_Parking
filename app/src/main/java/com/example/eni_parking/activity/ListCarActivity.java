package com.example.eni_parking.activity;

import android.app.LauncherActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import com.example.eni_parking.R;
import com.example.eni_parking.adapter.ListCarAdapter;
import com.example.eni_parking.bo.Car;

import java.util.ArrayList;
import java.util.List;

public class ListCarActivity extends AppCompatActivity {

    List<Car> lstCar;
    ListCarAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstCar = new ArrayList<>();

        lstCar.add(new Car(4, "deux", "trois", 4, 0, 1, 2));
        lstCar.add(new Car(8, "dgreeux", "trgreois", 4, 0, 1,2));
        lstCar.add(new Car(9, "deux", "trgreois", 4, 1, 1,2));
        lstCar.add(new Car(11, "deux", "troegreis", 4, 1, 1,2));
        lstCar.add(new Car(12, "deux", "trgrois", 4, 0, 1,2));
        lstCar.add(new Car(14, "degreux", "trois", 4, 0, 1,2));

        final ListView list = findViewById(R.id.lstcar);
        adapter = new ListCarAdapter(this, R.layout.lstcar_item, lstCar);

        list.setAdapter(adapter);
    }

    void addElement(Car car) {
        lstCar.add(car);
        adapter.notifyDataSetChanged();
    }
}
