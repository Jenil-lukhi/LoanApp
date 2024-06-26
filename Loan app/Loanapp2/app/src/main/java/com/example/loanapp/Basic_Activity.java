package com.example.loanapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class Basic_Activity extends AppCompatActivity {

    private TextView personalIn, pleaseFill, firstName, middleName, lastName, dateOfBirth, gender;
    private EditText pleaseEnterFirstName, pleaseEnterMiddleName, pleaseEnterLastName, ddMmYy, genderInput;
    private Button nextButton;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        // Initialize the Google Mobile Ads SDK on a background thread.
        new Thread(() -> MobileAds.initialize(this, initializationStatus -> {})).start();

        setAds();

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
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(Basic_Activity.this);
                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent();
                            startActivity(new Intent(Basic_Activity.this, Personal_Activity.class));
                            mInterstitialAd = null;
                            setAds();
                        }
                    });
                } else {
                    startActivity(new Intent(Basic_Activity.this, Personal_Activity.class));
                }
            }
        });
    }

    public void setAds() {
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this, "ca-app-pub-3940256099942544/1033173712", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until an ad is loaded.
                        mInterstitialAd = interstitialAd;
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        mInterstitialAd = null;
                    }
                });
    }
}
