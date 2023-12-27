package com.example.organdonationapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextLocation;
    private EditText editTextPassword;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextLocation = findViewById(R.id.editTextLocation);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonRegister = findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(view -> {
            String name = editTextName.getText().toString();
            String location = editTextLocation.getText().toString();
            String password = editTextPassword.getText().toString();

            // Create an Intent to start MainActivity2
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);

            // Create a Bundle to store the name
            Bundle bundle = new Bundle();
            bundle.putString("name", name);

            // Add the Bundle to the Intent
            intent.putExtras(bundle);

            // Start MainActivity2 with the Intent
            startActivity(intent);
        });
    }
    protected void onDestroy() {

        editTextName = null;
        editTextLocation = null;
        editTextPassword = null;
        buttonRegister = null;

        super.onDestroy();
    }
}