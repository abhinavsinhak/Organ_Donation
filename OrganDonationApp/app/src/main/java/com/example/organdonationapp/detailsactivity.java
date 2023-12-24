// File: DetailsActivity.java
package com.example.organdonationapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class detailsactivity extends AppCompatActivity {

    private TextView textViewName;
    private TextView textViewOrgan;
    private TextView textViewAadhar;
    private TextView textViewMobile;
    private TextView textViewGender;
    private TextView textViewAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailsactivity);

        textViewName = findViewById(R.id.textViewName);
        textViewOrgan = findViewById(R.id.textViewOrgan);
        textViewAadhar = findViewById(R.id.textViewAadhar);
        textViewMobile = findViewById(R.id.textViewMobile);
        textViewGender = findViewById(R.id.textViewGender);
        textViewAge = findViewById(R.id.textViewAge);

        // Get the data from the Bundle
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String name = bundle.getString("name");
            String organ = bundle.getString("organ");
            String aadhar = bundle.getString("aadhar");
            String mobile = bundle.getString("mobile");
            String gender = bundle.getString("gender");
            String age = bundle.getString("age");

            // Set the data in the TextViews
            textViewName.setText(name);
            textViewOrgan.setText(organ);
            textViewAadhar.setText(aadhar);
            textViewMobile.setText(mobile);
            textViewGender.setText(gender);
            textViewAge.setText(age);
        }
    }
}