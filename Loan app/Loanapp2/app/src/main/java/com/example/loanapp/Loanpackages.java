package com.example.loanapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Loanpackages extends Fragment {

    Button button11,button12,button13,button14;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_loanpackages, container, false);


        button11 = view.findViewById(R.id.apply1);
        button12 = view.findViewById(R.id.apply2);
        button13 = view.findViewById(R.id.apply3);
        button14 = view.findViewById(R.id.apply4);


        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Apply_Activity.class);
                startActivity(intent);
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Apply_Activity.class);
                startActivity(intent);
            }
        });
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Apply_Activity.class);
                startActivity(intent);
            }
        });
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Apply_Activity.class);
                startActivity(intent);
            }
        });



        return view;

    }
}