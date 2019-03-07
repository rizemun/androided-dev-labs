package com.example.firstapp;


import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class lab02Fragment2 extends Fragment {


    public lab02Fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lab02_2, container, false);

//        super.onCreate(savedInstanceState);
//        Bundle args = getArguments();
//        if (args != null) {
//            String value = args.getString("color");
//
//            view.setBackgroundColor(Color.parseColor(value));
//        }

        return view;
    }


}
