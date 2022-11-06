package com.example.ueemobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SanitationPracticeRVAdapter.PracticeClickInterface{

    private RecyclerView practiceRV;
    private ProgressBar loadingPB;
    private FloatingActionButton addFAB;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private ArrayList<SanitationPracticeRVModal> sanitationPracticeRVModalArrayList;
    private RelativeLayout bottomSheetRL;
    private SanitationPracticeRVAdapter sanitationPracticeRVAdapter;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        practiceRV = findViewById(R.id.idRVPractices);
        loadingPB = findViewById(R.id.idPBLoading);
        addFAB = findViewById(R.id.idAddFAB);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Sanitation_Practices");
        sanitationPracticeRVModalArrayList = new ArrayList<>();
        bottomSheetRL = findViewById(R.id.idRLBSheet);
        mAuth = FirebaseAuth.getInstance();
        sanitationPracticeRVAdapter = new SanitationPracticeRVAdapter(sanitationPracticeRVModalArrayList, this, this);
        practiceRV.setLayoutManager(new LinearLayoutManager(this));
        practiceRV.setAdapter(sanitationPracticeRVAdapter);
        addFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddSanitationPracticeActivity.class));
            }
        });

        getAllSanitationPractices();

    }

    private void getAllSanitationPractices() {
        sanitationPracticeRVModalArrayList.clear();
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                loadingPB.setVisibility(View.GONE);
                sanitationPracticeRVModalArrayList.add(snapshot.getValue(SanitationPracticeRVModal.class));
                sanitationPracticeRVAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable  String previousChildName) {
                loadingPB.setVisibility(View.GONE);
                sanitationPracticeRVAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                loadingPB.setVisibility(View.GONE);
                sanitationPracticeRVAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable  String previousChildName) {
                loadingPB.setVisibility(View.GONE);
                sanitationPracticeRVAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    @Override
    public void onPracticeClick(int position) {
        displayBottomSheet(sanitationPracticeRVModalArrayList.get(position));
    }


    private void displayBottomSheet(SanitationPracticeRVModal sanitationPracticeRVModal) {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View layout = LayoutInflater.from(this).inflate(R.layout.bottom_sheet_dialog, bottomSheetRL);
        bottomSheetDialog.setContentView(layout);
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        bottomSheetDialog.show();

        TextView topicTV = layout.findViewById(R.id.idTVTopicName);
        TextView userTV = layout.findViewById(R.id.idTVNurseName);
        TextView descTV = layout.findViewById(R.id.idTVDesc);
        Button editBtn = layout.findViewById(R.id.idBtnEdit);
        Button viewBtn = layout.findViewById(R.id.idBtnView);
        ImageView practiceIV = layout.findViewById(R.id.idIVPractice);

        topicTV.setText(sanitationPracticeRVModal.getTopicName());
        userTV.setText(sanitationPracticeRVModal.getUserName());
        descTV.setText(sanitationPracticeRVModal.getDesc());
        Picasso.get().load(sanitationPracticeRVModal.getImgLink()).into(practiceIV);

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, EditSanitationPracticeActivity.class);
                i.putExtra("practice", sanitationPracticeRVModal);
                startActivity(i);
            }
        });

        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(sanitationPracticeRVModal.getPracticeID()));
                startActivity(i);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.idLogOut:
                Toast.makeText(this, "User Logged Out..", Toast.LENGTH_SHORT).show();
                mAuth.signOut();
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}