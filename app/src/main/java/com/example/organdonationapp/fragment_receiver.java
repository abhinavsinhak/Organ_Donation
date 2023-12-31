// File: ReceiverFragment.java
package com.example.organdonationapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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
            Receiver receiver = new Receiver(
                    editTextName.getText().toString(),
                    editTextOrgan.getText().toString(),
                    editTextAadhar.getText().toString(),
                    editTextMobile.getText().toString(),
                    spinnerGender.getSelectedItem().toString(),
                    Integer.parseInt(editTextAge.getText().toString())
            );
            Intent intent = new Intent(getActivity(), DatabaseIntentService.class);
            intent.setAction("INSERT_DONOR_DATA");
            intent.putExtra("reciver", receiver);
            getActivity().startService(intent);
//            // Create an instance of ReceiverDatabaseHelper and insert the receiver data
//            ReceiverDatabaseHelper receiverDatabaseHelper = new ReceiverDatabaseHelper(getActivity());
//            receiverDatabaseHelper.insertReceiverData(receiver);

            Toast.makeText(getActivity(), "The data has been updated", Toast.LENGTH_SHORT).show();

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