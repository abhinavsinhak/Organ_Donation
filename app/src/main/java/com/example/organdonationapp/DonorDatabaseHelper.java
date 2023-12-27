// File: DonorDatabaseHelper.java
package com.example.organdonationapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DonorDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "donorDatabase";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "donors";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_ORGAN = "organ";
    private static final String COLUMN_AADHAR = "aadhar";
    private static final String COLUMN_MOBILE = "mobile";
    private static final String COLUMN_GENDER = "gender";
    private static final String COLUMN_AGE = "age";

    public DonorDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_NAME + " TEXT,"
                + COLUMN_ORGAN + " TEXT,"
                + COLUMN_AADHAR + " TEXT,"
                + COLUMN_MOBILE + " TEXT,"
                + COLUMN_GENDER + " TEXT,"
                + COLUMN_AGE + " INTEGER"
                + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertDonorData(Donor donor) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, donor.getName());
        values.put(COLUMN_ORGAN, donor.getOrgan());
        values.put(COLUMN_AADHAR, donor.getAadhar());
        values.put(COLUMN_MOBILE, donor.getMobile());
        values.put(COLUMN_GENDER, donor.getGender());
        values.put(COLUMN_AGE, donor.getAge());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
}