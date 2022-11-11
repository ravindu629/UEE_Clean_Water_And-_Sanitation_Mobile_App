package com.example.clean_water_and_sanitation;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class StudentOtherInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_other_information);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Other Information");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}