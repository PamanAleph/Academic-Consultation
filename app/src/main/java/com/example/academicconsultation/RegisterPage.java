package com.example.academicconsultation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterPage extends AppCompatActivity {

    private EditText editTextNote;
    private Button buttonSaveNote;

    private NotesDataSource notesDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        editTextNote = findViewById(R.id.editTextNote);
        buttonSaveNote = findViewById(R.id.buttonSaveNote);

        notesDataSource = new NotesDataSource(this);
        notesDataSource.open();

        buttonSaveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();
            }
        });
    }

    private void saveNote() {
        String noteText = editTextNote.getText().toString();

        if (!noteText.isEmpty()) {
            long result = notesDataSource.createNote(noteText);

            if (result != -1) {
                Toast.makeText(this, "Note saved successfully", Toast.LENGTH_SHORT).show();
                // Optionally, you can finish the activity or navigate to another screen here
            } else {
                Toast.makeText(this, "Failed to save note", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Please enter a note", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        notesDataSource.close();
    }
}
