package com.example.loanapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class LogInActivity extends AppCompatActivity {

    private EditText numberEditText;
    private EditText passwordEditText;
    private Button submitButton;
    private TextView signUpTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        numberEditText = findViewById(R.id.example_gma);
        passwordEditText = findViewById(R.id.some_id);
        submitButton = findViewById(R.id.submit);
        signUpTextView = findViewById(R.id.sign_up);

        signUpTextView.setOnClickListener(v -> handleSignUp());

        submitButton.setOnClickListener(v -> handleSubmit());
    }

    private void handleSubmit() {
        String mobileNumber = numberEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (TextUtils.isEmpty(mobileNumber)) {
            Toast.makeText(this, "Please enter your number", Toast.LENGTH_SHORT).show();
            return;
        }

        if (mobileNumber.length() != 10) {
            Toast.makeText(this, "Please enter a correct number", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences preferences = getSharedPreferences("LoanAppPrefs", MODE_PRIVATE);
        boolean isVerified = preferences.getBoolean("isVerified", false);

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91" + mobileNumber,
                60,
                TimeUnit.SECONDS,
                LogInActivity.this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                        // Handle auto-verification success
                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {
                        Toast.makeText(LogInActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCodeSent(@NonNull String backendotp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        Intent intent = new Intent(getApplicationContext(), VerificationPasswordActivity.class);
                        intent.putExtra("mobile", mobileNumber);
                        intent.putExtra("backendotp", backendotp);
                        startActivity(intent);
                    }
                }
        );
    }

    private void handleSignUp() {
        Toast.makeText(this, "Sign up clicked", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(LogInActivity.this, Signup_Activity.class));
    }
}
