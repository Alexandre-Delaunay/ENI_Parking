package com.example.eni_parking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.eni_parking.activity.FormManageCarActivity;
import com.example.eni_parking.activity.ListCarActivity;
import com.example.eni_parking.activity.SearchActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnForm = findViewById(R.id.BtnForm);
        Button btnList = findViewById(R.id.BtnList);
        Button btnSearch = findViewById(R.id.BtnSearch);

        final MainActivity context = this;
        btnForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,FormManageCarActivity.class);
                intent.putExtra("CAR_ID", -1);
                context.startActivityForResult(intent,2);
            }
        });
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ListCarActivity.class);
                context.startActivityForResult(intent,2);
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SearchActivity.class);
                context.startActivityForResult(intent,2);
            }
        });
    }
}
