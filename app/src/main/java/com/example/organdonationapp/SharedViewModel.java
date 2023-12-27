package com.example.organdonationapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<String> selectedGender = new MutableLiveData<>();

    public void selectGender(String gender) {
        selectedGender.setValue(gender);
    }

    public LiveData<String> getSelectedGender() {
        return selectedGender;
    }
}