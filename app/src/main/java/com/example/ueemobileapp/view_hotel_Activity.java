package com.example.clean_water_and_sanitation;

import static com.example.clean_water_and_sanitation.R.id.ViewIsuue;
import static com.example.clean_water_and_sanitation.R.id.login;
import static com.example.clean_water_and_sanitation.R.id.publishissue;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class view_hotel_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_hotel);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Hotel Home");
        actionBar.setDisplayHomeAsUpEnabled(true);

        View button = findViewById(publishissue);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edu = new Intent(getApplicationContext(),Publish_issue_Activity.class);
                startActivity(edu);
            }
        });

         button = findViewById(ViewIsuue);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edu = new Intent(getApplicationContext(),issues_view.class);
                startActivity(edu);
            }
        });
    }
}