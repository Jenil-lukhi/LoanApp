package com.example.loanapp;

import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);

        if (tabLayout != null) {

            tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.baseline_home_24));
            tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.baseline_poll_24));
            tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.cart));
            tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.baseline_person_24));

            PagerAdapter adapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
            viewPager.setAdapter(adapter);

            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    viewPager.setCurrentItem(tab.getPosition());
                    int tabIconColor = ContextCompat.getColor(MainActivity2.this, R.color.blue);
                    tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {
                    int tabIconColor = ContextCompat.getColor(MainActivity2.this, R.color.black);
                    tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });


            int tabIconColor = ContextCompat.getColor(MainActivity2.this, R.color.blue);
            if (tabLayout.getTabAt(tabLayout.getSelectedTabPosition()) != null &&
                    Objects.requireNonNull(tabLayout.getTabAt(tabLayout.getSelectedTabPosition())).getIcon() != null) {
                Objects.requireNonNull(tabLayout.getTabAt(tabLayout.getSelectedTabPosition())).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }
        }
    }
}
