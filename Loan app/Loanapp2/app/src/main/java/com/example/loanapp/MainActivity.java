package com.example.loanapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    TextView skipbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getSharedPreferences("LoanAppPrefs", MODE_PRIVATE);
        boolean isVerified = preferences.getBoolean("isVerified", false);

        if (isVerified) {
            // If verified, show the dashboard fragment

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);

            return;
        }

        viewPager = findViewById(R.id.viewPager);
        pagerAdapter = new ScreenSlidePagerAdapter();
        viewPager.setAdapter(pagerAdapter);
        skipbtn = findViewById(R.id.skip_button);

        skipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LogInActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private class ScreenSlidePagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return 4; // Number of pages
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            View view = null;
            switch (position) {
                case 0:
                    view = inflater.inflate(R.layout.activity_page1, container, false);
                    break;
                case 1:
                    view = inflater.inflate(R.layout.activity_page2, container, false);
                    break;
                case 2:
                    view = inflater.inflate(R.layout.activity_page3, container, false);
                    break;
                case 3:
                    view = inflater.inflate(R.layout.activity_page4, container, false);
                    break;
            }
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }
}
