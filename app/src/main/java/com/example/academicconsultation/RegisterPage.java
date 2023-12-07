package com.example.academicconsultation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterPage extends AppCompatActivity {

    private EditText NameRegister, EducationRegister, EmailRegister, PasswordRegister ;
    private Button ButtonRegister;

    private NotesDataSource notesDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        NameRegister = findViewById(R.id.editTextNameRegister);
        EducationRegister = findViewById(R.id.editTextEducationRegister);
        EmailRegister = findViewById(R.id.editTextEmailRegister);
        PasswordRegister = findViewById(R.id.editTextPasswordRegister);

        ButtonRegister = findViewById(R.id.buttonRegister);

        notesDataSource = new NotesDataSource(this);
        notesDataSource.open();

        ButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

    private void saveData() {
        String name = NameRegister.getText().toString();
        String education = EducationRegister.getText().toString();
        String email = EmailRegister.getText().toString();
        String password = PasswordRegister.getText().toString();

        if (!name.isEmpty() && !education.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
            // Assuming createNote() takes these parameters and saves them to your database
            long result = notesDataSource.createNote(name, education, email, password);

            if (result != -1) {
                Toast.makeText(this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();
                // Optionally, you can finish the activity or navigate to another screen here
            } else {
                Toast.makeText(this, "Failed To Save Data", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Please Fill All the Data", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        notesDataSource.close();
    }
}
