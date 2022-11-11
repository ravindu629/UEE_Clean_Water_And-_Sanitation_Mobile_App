package com.example.clean_water_and_sanitation;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentResearchesActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_researches);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Researches");
        actionBar.setDisplayHomeAsUpEnabled(true);

        button = findViewById(R.id.rpsBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add_research = new Intent(getApplicationContext(),StudentSubmitResearchActivity.class);
                startActivity(add_research);
            }
        });
    }
}