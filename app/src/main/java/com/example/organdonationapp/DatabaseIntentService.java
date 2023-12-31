package com.example.organdonationapp;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class DatabaseIntentService extends IntentService {
    public static final String TAG = "DatabaseIntentService";

    public DonorDatabaseHelper donorDatabaseHelper;
    public ReceiverDatabaseHelper receiverDatabaseHelper;

    public DatabaseIntentService() {
        super("DatabaseIntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        donorDatabaseHelper = new DonorDatabaseHelper(this);
        receiverDatabaseHelper = new ReceiverDatabaseHelper(this);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (action != null) {
                if (action.equals("INSERT_DONOR_DATA")) {
                    Donor donor = (Donor) intent.getSerializableExtra("donor");
                    donorDatabaseHelper.insertDonorData(donor);
                    Log.d(TAG, "Inserting donor data into SQLite database");
                    stopSelf(); // Stop the service after inserting data
                } else if (action.equals("INSERT_RECEIVER_DATA")) {
                    Receiver receiver = (Receiver) intent.getSerializableExtra("receiver");
                    receiverDatabaseHelper.insertReceiverData(receiver);
                    Log.d(TAG, "Inserting receiver data into SQLite database");
                    stopSelf(); // Stop the service after inserting data
                } else if (action.equals("FETCH_DATA")) {
                    // Fetch data from the database
                    // Restart the service when fetching data
                    startService(new Intent(this, DatabaseIntentService.class));
                }
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        donorDatabaseHelper.close();
        receiverDatabaseHelper.close();
    }
}