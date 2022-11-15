package com.example.clean_water_and_sanitation;

import static com.example.clean_water_and_sanitation.R.id.getIstruction;
import static com.example.clean_water_and_sanitation.R.id.get_ins2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class hotel_main_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_main_page);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Hotel Home");
        actionBar.setDisplayHomeAsUpEnabled(true);

        View button = findViewById(getIstruction);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edu = new Intent(getApplicationContext(),insruction_page.class);
                startActivity(edu);
            }
        });

        button = findViewById(get_ins2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edu = new Intent(getApplicationContext(),view_hotel_profile_Activity.class);
                startActivity(edu);
            }
        });
    }
}