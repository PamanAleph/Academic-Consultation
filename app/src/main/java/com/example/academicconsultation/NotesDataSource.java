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
    public long createNote(String note, String education, int number, String email, String password) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NOTE, note);
        return database.insert(DatabaseHelper.TABLE_NOTES, null, values);
    }

    // Read all notes
    public Cursor getAllNotes() {
        String[] allColumns = {DatabaseHelper.COLUMN_ID, DatabaseHelper.COLUMN_NOTE};
        return database.query(DatabaseHelper.TABLE_NOTES, allColumns,
                null, null, null, null, null);
    }

    // Update a note
    public int updateNote(long id, String newNote) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NOTE, newNote);
        return database.update(DatabaseHelper.TABLE_NOTES, values,
                DatabaseHelper.COLUMN_ID + " = " + id, null);
    }

    // Delete a note
    public int deleteNote(long id) {
        return database.delete(DatabaseHelper.TABLE_NOTES,
                DatabaseHelper.COLUMN_ID + " = " + id, null);
    }
}

