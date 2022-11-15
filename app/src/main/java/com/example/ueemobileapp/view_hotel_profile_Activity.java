package com.example.clean_water_and_sanitation;

import static com.example.clean_water_and_sanitation.R.id.getIstruction;
import static com.example.clean_water_and_sanitation.R.id.getregister;
import static com.example.clean_water_and_sanitation.R.id.viewProfile;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class view_hotel_profile_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_hotel_profile);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Hotel Home");
        actionBar.setDisplayHomeAsUpEnabled(true);

        View button = findViewById(getregister);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edu = new Intent(getApplicationContext(),hotelregister_Activity.class);
                startActivity(edu);
            }
        });

         button = findViewById(viewProfile);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edu = new Intent(getApplicationContext(),hotel_login_Activity.class);
                startActivity(edu);
            }
        });
    }
}