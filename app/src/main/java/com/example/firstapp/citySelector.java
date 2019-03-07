package com.example.firstapp;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.support.v7.widget.LinearLayoutManager;
import java.util.List;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 */
public class citySelector extends Fragment {


    public citySelector() {
        // Required empty public constructor
    }

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager  mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_city_selector, container, false);

//        super.onCreate(savedInstanceState);
//        Bundle args = getArguments();
//        if (args != null) {
//            String value = args.getString("color");
//
//            view.setBackgroundColor(Color.parseColor(value));
//        }




        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        String[] myString = getResources().getStringArray(R.array.recycler_data);
        String[] countriesArr = getResources().getStringArray(R.array.countries);

        List<String> recyclerData = Arrays.asList(myString);
        List<String> countries = Arrays.asList(countriesArr);

        mAdapter = new MyRecyclerViewAdapter(recyclerData, countries);

        mRecyclerView.setAdapter(mAdapter);






        return view;
    }


}
