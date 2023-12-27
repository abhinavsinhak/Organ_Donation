package com.example.organdonationapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity2 extends AppCompatActivity {

    private TextView textViewUserName;
    private Button buttonDonor;
    private Button buttonReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textViewUserName = findViewById(R.id.textViewUserName);
        buttonDonor = findViewById(R.id.buttonDonor);
        buttonReceiver = findViewById(R.id.buttonReceiver);

        // Get the name from the Intent
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String name = bundle.getString("name");
            textViewUserName.setText("Hello! " + name);
        }

        buttonDonor.setOnClickListener(view -> {
            // Load the donor fragment
            DonorFragment donorFragment = new DonorFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainer, donorFragment);
            transaction.commit();
        });

        buttonReceiver.setOnClickListener(view -> {
            // Load the receiver fragment
            fragment_receiver receiverFragment = new fragment_receiver();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainer, receiverFragment);
            transaction.commit();
        });
    }
}