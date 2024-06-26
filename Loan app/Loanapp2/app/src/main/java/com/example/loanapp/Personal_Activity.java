package com.example.loanapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Personal_Activity extends AppCompatActivity {

    private EditText pleaseSele, pleaseSele03, pleaseSele04, pleaseSele05, pleaseSele06;
    private TextView education, jobStatus, professiona, salary, maritalSta;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        // Initialize the views
        pleaseSele = findViewById(R.id.please_sele);
        pleaseSele03 = findViewById(R.id.please_sele03);
        pleaseSele04 = findViewById(R.id.please_sele04);
        pleaseSele05 = findViewById(R.id.please_sele05);
        pleaseSele06 = findViewById(R.id.please_sele06);

        education = findViewById(R.id.education);
        jobStatus = findViewById(R.id.job_status);
        professiona = findViewById(R.id.professiona);
        salary = findViewById(R.id.salary);
        maritalSta = findViewById(R.id.marital_sta);

        nextButton = findViewById(R.id.group_4);

        // Handle button click
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Personal_Activity.this, Contact_Activity.class);
                startActivity(intent);
            }
        });
    }

    private void handleFormSubmission() {
        // Extract data from inputs
        String educationInput = pleaseSele.getText().toString().trim();
        String jobStatusInput = pleaseSele03.getText().toString().trim();
        String professionalInput = pleaseSele04.getText().toString().trim();
        String salaryInput = pleaseSele05.getText().toString().trim();
        String maritalStatusInput = pleaseSele06.getText().toString().trim();

        // Perform your validation and processing logic here
        if (educationInput.isEmpty() || jobStatusInput.isEmpty() || professionalInput.isEmpty() || salaryInput.isEmpty() || maritalStatusInput.isEmpty()) {
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
        } else {
            // Proceed with the next steps, such as sending data to the server or saving locally
            Toast.makeText(this, "Next", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Personal_Activity.this, Contact_Activity.class);
            startActivity(intent);
        }
    }
}
