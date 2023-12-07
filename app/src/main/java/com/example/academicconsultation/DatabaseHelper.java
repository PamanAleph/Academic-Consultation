package com.example.academicconsultation;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "AcademicConsultation";
    private static final int DATABASE_VERSION = 1;

    // Table name and column names
    public static final String TABLE_REGISTER = "student";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_EDUCATION = "education";
    public static final String COLUMN_GENDER = "gender";
    public static final String COLUMN_MAJOR = "major";
    public static final String COLUMN_PASSWORD = "password"; // Add this line for the password column

    // Create table query
    private static final String CREATE_TABLE_REGISTER =
            "CREATE TABLE " + TABLE_REGISTER + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_EMAIL + " TEXT, " +
                    COLUMN_EDUCATION + " TEXT, " +
                    COLUMN_GENDER + " TEXT, " +
                    COLUMN_MAJOR + " TEXT, " +
                    COLUMN_PASSWORD + " TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_REGISTER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database upgrade if needed
    }
}
