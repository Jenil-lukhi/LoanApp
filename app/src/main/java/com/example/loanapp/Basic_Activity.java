package com.example.loanapp;

import static android.app.ProgressDialog.show;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Basic_Activity extends AppCompatActivity {

    private TextView personalIn, pleaseFill, firstName, middleName, lastName, dateOfBirth, gender;
    private EditText pleaseEnterFirstName, pleaseEnterMiddleName, pleaseEnterLastName, ddMmYy, genderInput;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);


        personalIn = findViewById(R.id.personal_in);
        pleaseFill = findViewById(R.id.please_fill);
        firstName = findViewById(R.id.first_name);
        middleName = findViewById(R.id.middle_name);
        lastName = findViewById(R.id.last_name);
        dateOfBirth = findViewById(R.id.date_of_bir);
        gender = findViewById(R.id.gender);

        pleaseEnterFirstName = findViewById(R.id.please_ente);
        pleaseEnterMiddleName = findViewById(R.id.please_ente1);
        pleaseEnterLastName = findViewById(R.id.please_ente00);
        ddMmYy = findViewById(R.id.dd_mm_yy);
        genderInput = findViewById(R.id.female);

        nextButton = findViewById(R.id.rectangl0);

        nextButton.setOnClickListener(v -> {

        String firstNameInput = pleaseEnterFirstName.getText().toString();
        String middleNameInput = pleaseEnterMiddleName.getText().toString();
        String lastNameInput = pleaseEnterLastName.getText().toString();
        String dateOfBirthInput = ddMmYy.getText().toString();
        String genderInputText = genderInput.getText().toString();



        if (firstNameInput.isEmpty() || middleNameInput.isEmpty() || lastNameInput.isEmpty() || dateOfBirthInput.isEmpty() || genderInputText.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Next", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(Basic_Activity.this, Personal_Activity.class);
            startActivity(intent);

        }
        });

    }

}
