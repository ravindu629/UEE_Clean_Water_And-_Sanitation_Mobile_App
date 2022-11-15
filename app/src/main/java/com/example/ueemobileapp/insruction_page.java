package com.example.clean_water_and_sanitation;

import static com.example.clean_water_and_sanitation.R.id.Environment;
import static com.example.clean_water_and_sanitation.R.id.Other;
import static com.example.clean_water_and_sanitation.R.id.Sanitation;
import static com.example.clean_water_and_sanitation.R.id.getIstruction;
import static com.example.clean_water_and_sanitation.R.id.savebtn;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class insruction_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insruction_page);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Hotel Home");
        actionBar.setDisplayHomeAsUpEnabled(true);

        View button = findViewById(Sanitation);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edu = new Intent(getApplicationContext(),sanitation_methods_Activity.class);
                startActivity(edu);
            }
        });


        button = findViewById(Environment);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edu = new Intent(getApplicationContext(), environment_Activity.class);
                startActivity(edu);
            }
        });

        button = findViewById(Other);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edu = new Intent(getApplicationContext(), other_Activity.class);
                startActivity(edu);
            }
        });


        button = findViewById(savebtn);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edu = new Intent(getApplicationContext(), save_water_Activity.class);
                startActivity(edu);
            }
        });
    }
}