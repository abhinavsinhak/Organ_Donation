// File: ReceiverDatabaseHelper.java
package com.example.organdonationapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ReceiverDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "receiverDatabase";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "receivers";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_ORGAN_NEEDED = "organNeeded";
    private static final String COLUMN_AADHAR = "aadhar";
    private static final String COLUMN_MOBILE = "mobile";
    private static final String COLUMN_GENDER = "gender";
    private static final String COLUMN_AGE = "age";

    public ReceiverDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_NAME + " TEXT,"
                + COLUMN_ORGAN_NEEDED + " TEXT,"
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

    public void insertReceiverData(Receiver receiver) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, receiver.getName());
        values.put(COLUMN_ORGAN_NEEDED, receiver.getOrganNeeded());
        values.put(COLUMN_AADHAR, receiver.getAadhar());
        values.put(COLUMN_MOBILE, receiver.getMobile());
        values.put(COLUMN_GENDER, receiver.getGender());
        values.put(COLUMN_AGE, receiver.getAge());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
}