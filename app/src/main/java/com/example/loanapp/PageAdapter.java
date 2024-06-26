package com.example.loanapp;

import android.app.Person;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {

    private final int totalTabs;

    public PageAdapter(@NonNull FragmentManager fm, int totalTabs) {
        super(fm);
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        if (position == 0)
            return new Dashbord_Fragment();

        if (position == 1)
            return new Poll_Fragment();

        if (position ==2)
            return new Cart_Fragment();

//        if (position ==3)
//            return new Loanoffers();
//
//        if (position ==4)
//            return new Loanpackages();
//        if (position ==5)
//            return new Apply();

        return new Person_Fragment();

    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
