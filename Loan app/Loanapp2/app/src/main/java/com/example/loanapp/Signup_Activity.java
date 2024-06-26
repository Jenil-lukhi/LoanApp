package com.example.loanapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Signup_Activity extends AppCompatActivity {

    private EditText etFullName, etnumber, etDob, etPassword, etConfirmPassword;
    private Button btnSubmit;
    private TextView tvLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);



        etFullName = findViewById(R.id.et_full_name);
        etnumber = findViewById(R.id.et_number);
        etDob = findViewById(R.id.et_dob);
        etPassword = findViewById(R.id.et_password);
        etConfirmPassword = findViewById(R.id.et_confirm_password);
        btnSubmit = findViewById(R.id.btn_submit);
        tvLogin = findViewById(R.id.tv_login);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });


        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Signup_Activity.this, LogInActivity.class));
                Toast.makeText(Signup_Activity.this, "Navigating to Login Activity", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void submitForm() {
        String fullName = etFullName.getText().toString().trim();
        String number = etnumber.getText().toString().trim();
        String dob = etDob.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String confirmPassword = etConfirmPassword.getText().toString().trim();

        if (TextUtils.isEmpty(fullName)) {
            etFullName.setError("Full name is required");
            return;
        }

        if (TextUtils.isEmpty(number) || !Patterns.EMAIL_ADDRESS.matcher(number).matches()) {
            etnumber.setError("Valid phone number is required");
            return;
        }

        if (TextUtils.isEmpty(dob)) {
            etDob.setError("Date of birth is required");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            etPassword.setError("Password is required");
            return;
        }

        if (!password.equals(confirmPassword)) {
            etConfirmPassword.setError("Passwords do not match");
            return;
        }
    }
}

