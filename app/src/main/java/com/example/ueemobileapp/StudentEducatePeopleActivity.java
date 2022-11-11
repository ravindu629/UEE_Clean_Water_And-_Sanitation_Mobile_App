package com.example.clean_water_and_sanitation;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentEducatePeopleActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_educate_people);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Educate People");
        actionBar.setDisplayHomeAsUpEnabled(true);

        button = findViewById(R.id.clean_water_btn3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clean_water = new Intent(getApplicationContext(),StudentCleanWaterActivity.class);
                startActivity(clean_water);
            }
        });

        button = findViewById(R.id.save_protect_water_btn5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent save_protect_clean_water = new Intent(getApplicationContext(),StudentSaveAndProtectCleanWaterActivity.class);
                startActivity(save_protect_clean_water);
            }
        });

        button = findViewById(R.id.sanitation_btn7);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sanitation = new Intent(getApplicationContext(),StudentSanitationActivity.class);
                startActivity(sanitation);
            }
        });

        button = findViewById(R.id.other_information_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent other_information = new Intent(getApplicationContext(),StudentOtherInformationActivity.class);
                startActivity(other_information);
            }
        });
    }
}