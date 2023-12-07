package com.example.academicconsultation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class NotesDataSource {

    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public NotesDataSource(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    // Create a new note
    public long createNote(String name, String education, String email, String password) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NAME, name);
        values.put(DatabaseHelper.COLUMN_EDUCATION, education);
        values.put(DatabaseHelper.COLUMN_EMAIL, email);
        values.put(DatabaseHelper.COLUMN_PASSWORD, password);
        return database.insert(DatabaseHelper.TABLE_REGISTER, null, values);
    }

    // Read all notes
    public Cursor getAllNotes() {
        String[] allColumns = {DatabaseHelper.COLUMN_NAME, DatabaseHelper.COLUMN_NAME};
        return database.query(DatabaseHelper.TABLE_REGISTER, allColumns,
                null, null, null, null, null);
    }

    // Update a note
    public int updateNote(long id, String newNote) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_EMAIL, newNote);
        return database.update(DatabaseHelper.TABLE_REGISTER, values,
                DatabaseHelper.COLUMN_ID + " = " + id, null);
    }

    // Delete a note
    public int deleteNote(long id) {
        return database.delete(DatabaseHelper.TABLE_REGISTER,
                DatabaseHelper.COLUMN_ID + " = " + id, null);
    }
}
