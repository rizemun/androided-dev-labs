package com.example.firstapp;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.app.Fragment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.os.Bundle;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.Locale;




public class LR1SecondActivity extends AppCompatActivity {


    private DrawerLayout mDrawerLayout;
    private String locationCur="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lr1_second);





//        mRecyclerView = findViewById(R.id.my_recycler_view);
//        mRecyclerView.setHasFixedSize(true);
//        mLayoutManager = new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(mLayoutManager);
//        mRecyclerView.setAdapter(mAdapter);

//        String[] myString = getResources().getStringArray(R.array.recycler_data);
//        List<String> recyclerData = Arrays.asList(myString);
//
//        mAdapter = new MyRecyclerViewAdapter(recyclerData);


        mDrawerLayout = findViewById(R.id.my_drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        Bundle args;
        Fragment fragment;

        if (savedInstanceState == null) {
            fragmentManager = getFragmentManager();
            fragmentTransaction =
                    fragmentManager.beginTransaction();

            fragment = new lab02Fragment3();

            fragmentTransaction.replace(R.id.fragmentPos, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

            navigationView.setCheckedItem(R.id.my_item3);
        }

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        FragmentManager fragmentManager;
                        FragmentTransaction fragmentTransaction;
                        Bundle args;
                        Fragment fragment;

                        switch (menuItem.getItemId()) {
                            case R.id.my_item1:
                                fragmentManager = getFragmentManager();
                                fragmentTransaction =
                                        fragmentManager.beginTransaction();

//                            args = new Bundle();
//                            args.putString("color", "blue");
                                fragment = new citySelector();
//                            fragment.setArguments(args);

                                fragmentTransaction.replace(R.id.fragmentPos, fragment);
                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.commit();
                                break;
                            case R.id.my_item2:
                                fragmentManager = getFragmentManager();
                                fragmentTransaction =
                                        fragmentManager.beginTransaction();

                                fragment = new lab02Fragment2();
//                                if(!locationCur.equals("")) {
//                                    args = new Bundle();
//                                    args.putString("abc", locationCur);
//                                    fragment.setArguments(args);
//                                }
                                fragmentTransaction.replace(R.id.fragmentPos, fragment);
                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.commit();

                                break;
                            case R.id.my_item3:
                                fragmentManager = getFragmentManager();
                                fragmentTransaction =
                                        fragmentManager.beginTransaction();

//                            args = new Bundle();
//                            args.putString("color", "cyan");
                                fragment = new lab02Fragment3();
//                            fragment.setArguments(args);

                                fragmentTransaction.replace(R.id.fragmentPos, fragment);
                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.commit();

                                break;
                            case R.id.my_item4:
                                fragmentManager = getFragmentManager();
                                fragmentTransaction =
                                        fragmentManager.beginTransaction();

//                            args = new Bundle();
//                            args.putString("color", "purple");
                                fragment = new lab02Fragment4();
//                            fragment.setArguments(args);

                                fragmentTransaction.replace(R.id.fragmentPos, fragment);
                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.commit();

                                break;

                        }

                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;

                    }
                });
    }


}

