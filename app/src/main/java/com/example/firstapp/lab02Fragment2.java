package com.example.firstapp;


import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class lab02Fragment2 extends Fragment {


    private String currentCity = "";

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager  mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    public lab02Fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lab02_2, container, false);


        mRecyclerView = view.findViewById(R.id.my_recycler_view2);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);



        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            String value = args.getString("abc");


            if(!value.equals("")) {
                currentCity = value;
            }
        }




        String[] myString = new String[1];
        myString[0] = currentCity;

        List<String> recyclerData = Arrays.asList(myString);
        List<String> countries = new ArrayList();
        countries.add("Россия");
        mAdapter = new MyRecyclerViewAdapter(recyclerData, countries);

        mRecyclerView.setAdapter(mAdapter);


        return view;
    }


}
