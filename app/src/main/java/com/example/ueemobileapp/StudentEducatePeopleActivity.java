package com.example.clean_water_and_sanitation;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class StudentEducatePeopleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_educate_people);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Educate People");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}