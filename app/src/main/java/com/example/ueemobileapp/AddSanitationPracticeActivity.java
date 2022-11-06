package com.example.ueemobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddSanitationPracticeActivity extends AppCompatActivity {

    private TextInputEditText topicNameEdt, userNameEdt, refLinkEdt, imgLinkEdt, descEdt;
    private Button addPracticeBtn;
    private ProgressBar loadingPB;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    private String practiceID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sanitation_practice);

        topicNameEdt = findViewById(R.id.idEdtTopicName);
        userNameEdt = findViewById(R.id.idEdtUserName);
        refLinkEdt = findViewById(R.id.idEdtRefLink);
        imgLinkEdt = findViewById(R.id.idEdtImageLink);
        descEdt = findViewById(R.id.idEdtDesc);
        addPracticeBtn = findViewById(R.id.idBtnAddPractice);
        loadingPB = findViewById(R.id.idPBLoading);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Sanitation_Practices");

        addPracticeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingPB.setVisibility(View.VISIBLE);
                String topicName = topicNameEdt.getText().toString();
                String userName = userNameEdt.getText().toString();
                String refLink = refLinkEdt.getText().toString();
                String imgLink = imgLinkEdt.getText().toString();
                String desc = descEdt.getText().toString();
                practiceID = topicName;


                //pass data to the model class
                SanitationPracticeRVModal sanitationPracticeRVModal = new SanitationPracticeRVModal(topicName, userName, refLink, imgLink, desc, practiceID);

                //adding modal to the database
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        loadingPB.setVisibility(View.GONE);
                        databaseReference.child(practiceID).setValue(sanitationPracticeRVModal);
                        Toast.makeText(AddSanitationPracticeActivity.this, "Sanitation Practice Added...", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(AddSanitationPracticeActivity.this, MainActivity.class));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(AddSanitationPracticeActivity.this, "Error is " + error.toString(), Toast.LENGTH_SHORT).show();

                    }
                });


            }
        });
    }
}