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

import java.util.HashMap;
import java.util.Map;

public class EditSanitationPracticeActivity extends AppCompatActivity {

    private TextInputEditText topicNameEdt, userNameEdt, refLinkEdt, imgLinkEdt, descEdt;
    private Button updatePracticeBtn, deletePracticeBtn;
    private ProgressBar loadingPB;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    private String practiceID;

    private SanitationPracticeRVModal sanitationPracticeRVModal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_sanitation_practice);

        //initialize database
        firebaseDatabase = FirebaseDatabase.getInstance();

        topicNameEdt = findViewById(R.id.idEdtTopicName);
        userNameEdt = findViewById(R.id.idEdtUserName);
        refLinkEdt = findViewById(R.id.idEdtRefLink);
        imgLinkEdt = findViewById(R.id.idEdtImageLink);
        descEdt = findViewById(R.id.idEdtDesc);
        updatePracticeBtn = findViewById(R.id.idBtnUpdatePractice);
        deletePracticeBtn = findViewById(R.id.idBtnDeletePractice);
        loadingPB = findViewById(R.id.idPBLoading);

        //getting the data from previous activity
        sanitationPracticeRVModal = getIntent().getParcelableExtra("practice");
        if(sanitationPracticeRVModal!=null){
            topicNameEdt.setText(sanitationPracticeRVModal.getTopicName());
            userNameEdt.setText(sanitationPracticeRVModal.getUserName());
            refLinkEdt.setText(sanitationPracticeRVModal.getRefLink());
            imgLinkEdt.setText(sanitationPracticeRVModal.getImgLink());
            descEdt.setText(sanitationPracticeRVModal.getDesc());
            practiceID = sanitationPracticeRVModal.getPracticeID();
        }

        databaseReference = firebaseDatabase.getReference("Sanitation_Practices").child(practiceID);

        updatePracticeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingPB.setVisibility(View.VISIBLE);

                String topicName = topicNameEdt.getText().toString();
                String userName = userNameEdt.getText().toString();
                String refLink = refLinkEdt.getText().toString();
                String imgLink = imgLinkEdt.getText().toString();
                String desc = descEdt.getText().toString();

                //passing data
                Map<String, Object> map = new HashMap<>();
                map.put("topicName", topicName);
                map.put("userName", userName);
                map.put("refLink", refLink);
                map.put("imgLink", imgLink);
                map.put("desc", desc);
                map.put("practiceID", practiceID);

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        loadingPB.setVisibility(View.GONE);
                        databaseReference.updateChildren(map);
                        Toast.makeText(EditSanitationPracticeActivity.this, "Sanitation Practice Updated..", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(EditSanitationPracticeActivity.this, MainActivity.class));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(EditSanitationPracticeActivity.this, "Fail to update Sanitation Practice", Toast.LENGTH_SHORT).show();

                    }
                });


            }
        });

        deletePracticeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deletePractice();
            }
        });

    }

    private void deletePractice() {
        databaseReference.removeValue();
        Toast.makeText(this, "Sanitation Practice deleted..", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(EditSanitationPracticeActivity.this, MainActivity.class));
    }


}