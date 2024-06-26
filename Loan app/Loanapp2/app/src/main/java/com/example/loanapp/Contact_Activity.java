package com.example.loanapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Contact_Activity extends AppCompatActivity {

    private EditText pleaseSele1;
    private EditText clickForN1;
    private EditText pleaseSele2;
    private EditText clickForN2;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        // Initialize EditTexts and Button
        pleaseSele1 = findViewById(R.id.please_sele);
        clickForN1 = findViewById(R.id.click_for_n);
        pleaseSele2 = findViewById(R.id.please_sele06);
        clickForN2 = findViewById(R.id.click_for_1n);
        submitButton = findViewById(R.id.group_3);

        // Set OnClickListener for the button
        submitButton.setOnClickListener(v -> {
            String contact1 = pleaseSele1.getText().toString();
            String relationship1 = clickForN1.getText().toString();
            String contact2 = pleaseSele2.getText().toString();
            String relationship2 = clickForN2.getText().toString();

            if (contact1.isEmpty() || relationship1.isEmpty() || contact2.isEmpty() || relationship2.isEmpty()) {
                Toast.makeText(Contact_Activity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            } else {
                // Handle form submission
                Toast.makeText(Contact_Activity.this, "Form submitted", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Contact_Activity.this, MainActivity2.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
