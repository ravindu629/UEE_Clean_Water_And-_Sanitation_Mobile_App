package com.example.clean_water_and_sanitation;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentIssuesActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_issues);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Issues");
        actionBar.setDisplayHomeAsUpEnabled(true);

        button = findViewById(R.id.submitIssue);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent submit_issue = new Intent(getApplicationContext(),StudentSubmitIssueActivity.class);
                startActivity(submit_issue);
            }
        });
    }
}