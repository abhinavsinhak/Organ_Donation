// File: DonorFragment.java
package com.example.organdonationapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class DonorFragment extends Fragment {

    private EditText editTextName;
    private EditText editTextOrgan;
    private EditText editTextAadhar;
    private EditText editTextMobile;
    private Spinner spinnerGender;
    private EditText editTextAge;
    private Button buttonUpdate;
    private ImageView imageView;

    private SharedViewModel sharedViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_donor, container, false);

        editTextName = view.findViewById(R.id.editTextName);
        editTextOrgan = view.findViewById(R.id.editTextOrgan);
        editTextAadhar = view.findViewById(R.id.editTextAadhar);
        editTextMobile = view.findViewById(R.id.editTextMobile);
        spinnerGender = view.findViewById(R.id.spinnerGender);
        editTextAge = view.findViewById(R.id.editTextAge);
        buttonUpdate = view.findViewById(R.id.buttonUpdate);
        imageView = view.findViewById(R.id.imageView);

        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        buttonUpdate.setOnClickListener(v -> {
            Donor donor = new Donor(
                    editTextName.getText().toString(),
                    editTextOrgan.getText().toString(),
                    editTextAadhar.getText().toString(),
                    editTextMobile.getText().toString(),
                    spinnerGender.getSelectedItem().toString(),
                    Integer.parseInt(editTextAge.getText().toString())
            );

            // Notify the SharedViewModel with the selected gender
            String selectedGender = spinnerGender.getSelectedItem().toString();
            sharedViewModel.selectGender(selectedGender);

            // Pass the donor information to the DatabaseIntentService
            Intent intent = new Intent(getActivity(), DatabaseIntentService.class);
            intent.setAction("INSERT_DONOR_DATA");
            Bundle bundle = new Bundle();
            bundle.putSerializable("donor", donor);
            intent.putExtras(bundle);
            getActivity().startService(intent);
        });

        return view;
    }
}