package com.example.organdonationapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class DonorListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DonorAdapter donorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_list);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DonorDatabaseHelper donorDatabaseHelper = new DonorDatabaseHelper(this);
        ArrayList<ContactModel> contactList = donorDatabaseHelper.getAllDonors();

        donorAdapter = new DonorAdapter(contactList);
        recyclerView.setAdapter(donorAdapter);
    }
}