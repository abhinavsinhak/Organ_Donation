// File: ReceiverFragment.java
package com.example.organdonationapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class fragment_receiver extends Fragment {

    private EditText editTextName;
    private EditText editTextOrgan;
    private EditText editTextAadhar;
    private EditText editTextMobile;
    private Spinner spinnerGender;
    private EditText editTextAge;
    private Button buttonUpdate;

    private SharedViewModel sharedViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_receiver, container, false);

        editTextName = view.findViewById(R.id.editTextName);
        editTextOrgan = view.findViewById(R.id.editTextOrgan);
        editTextAadhar = view.findViewById(R.id.editTextAadhar);
        editTextMobile = view.findViewById(R.id.editTextMobile);
        spinnerGender = view.findViewById(R.id.spinnerGender);
        editTextAge = view.findViewById(R.id.editTextAge);
        buttonUpdate = view.findViewById(R.id.buttonUpdate);

        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        sharedViewModel.getSelectedGender().observe(getViewLifecycleOwner(), gender -> {
            if (gender != null) {
                setSpinnerToValue(spinnerGender, gender);
            }
        });

        buttonUpdate.setOnClickListener(v -> {
            // Handle the button click event
            // You can store the receiver information in the database here

        });

        return view;
    }

    private void setSpinnerToValue(Spinner spinner, String value) {
        for (int i = 0; i < spinner.getCount(); i++) {
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(value)) {
                spinner.setSelection(i);
                return;
            }
        }
    }
}