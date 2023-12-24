// File: DonorFragment.java
package com.example.organdonationapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

public class DonorFragment extends Fragment {

    private EditText editTextName;
    private EditText editTextOrgan;
    private EditText editTextAadhar;
    private EditText editTextMobile;
    private Spinner spinnerGender;
    private EditText editTextAge;
    private Button buttonUpdate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_donor, container, false);

        editTextName = view.findViewById(R.id.editTextName);
        editTextOrgan = view.findViewById(R.id.editTextOrgan);
        editTextAadhar = view.findViewById(R.id.editTextAadhar);
        editTextMobile = view.findViewById(R.id.editTextMobile);
        spinnerGender = view.findViewById(R.id.spinnerGender);
        editTextAge = view.findViewById(R.id.editTextAge);
        buttonUpdate = view.findViewById(R.id.buttonUpdate);

        buttonUpdate.setOnClickListener(v -> {
            String name = editTextName.getText().toString();
            String organ = editTextOrgan.getText().toString();
            String aadhar = editTextAadhar.getText().toString();
            String mobile = editTextMobile.getText().toString();
            String gender = spinnerGender.getSelectedItem().toString();
            String age = editTextAge.getText().toString();

            Intent intent = new Intent(getActivity(), detailsactivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("name", name);
            bundle.putString("organ", organ);
            bundle.putString("aadhar", aadhar);
            bundle.putString("mobile", mobile);
            bundle.putString("gender", gender);
            bundle.putString("age", age);
            intent.putExtras(bundle);

            startActivity(intent);
        });

        return view;
    }
}