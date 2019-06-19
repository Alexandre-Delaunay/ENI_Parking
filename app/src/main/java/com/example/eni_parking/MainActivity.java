package com.example.eni_parking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.eni_parking.activity.FormManageCarActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnForm = findViewById(R.id.BtnForm);

        final MainActivity context = this;
        btnForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,FormManageCarActivity.class);
                intent.putExtra("CAR_ID", -1);
                context.startActivityForResult(intent,2);
            }
        });
    }
}
