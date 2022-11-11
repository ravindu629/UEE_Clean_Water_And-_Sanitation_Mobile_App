package com.example.clean_water_and_sanitation;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentHomeActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Student Home");
        actionBar.setDisplayHomeAsUpEnabled(true);

        button = findViewById(R.id.educate_people_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edu = new Intent(getApplicationContext(),StudentEducatePeopleActivity.class);
                startActivity(edu);
            }
        });

        button = findViewById(R.id.research_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent research = new Intent(getApplicationContext(),StudentResearchesActivity.class);
                startActivity(research);
            }
        });

        button = findViewById(R.id.issues_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent issue = new Intent(getApplicationContext(),StudentIssuesActivity.class);
                startActivity(issue);
            }
        });
    }

//    public void educate_people_onClick(View view) {
//        Intent edu = new Intent(this,StudentEducatePeopleActivity.class);
//        startActivity(edu);
//    }
}