package com.example.eni_parking.activity;

import android.app.LauncherActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

        ListView list = findViewById(R.id.lstcar);

        adapter = new ListCarAdapter(this, R.layout.lstcar_item, lstCar);

        list.setAdapter(adapter);

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent editCar = new Intent(ListCarActivity.this, FormManageCarActivity.class);
                editCar.putExtra("CAR_ID", lstCar.get(i).getId());
                startActivity(editCar);
                return true;
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent editRent = new Intent(ListCarActivity.this, FormRentActivity.class);
                editRent.putExtra("CAR_ID", lstCar.get(i).getId());
                startActivity(editRent);
            }
        });
    }
}
