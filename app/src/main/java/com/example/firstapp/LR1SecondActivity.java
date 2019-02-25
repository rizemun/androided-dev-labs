package com.example.firstapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.os.Bundle;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

public class LR1SecondActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lr1_second);

        mDrawerLayout = findViewById(R.id.my_drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);


        navigationView.setCheckedItem(R.id.my_item3);


        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        Bundle args;
        Fragment fragment;

        fragmentManager = getFragmentManager();
        fragmentTransaction =
                fragmentManager.beginTransaction();

        args = new Bundle();
        args.putString("color", "cyan");
        fragment = new lab02Fragment3();
        fragment.setArguments(args);

        fragmentTransaction.replace(R.id.fragmentPos, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();





        navigationView.setNavigationItemSelectedListener(
            new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem menuItem) {
                    FragmentManager fragmentManager;
                    FragmentTransaction fragmentTransaction;
                    Bundle args;
                    Fragment fragment;

                    switch(menuItem.getItemId()){
                        case R.id.my_item1:
                            fragmentManager = getFragmentManager();
                            fragmentTransaction =
                                    fragmentManager.beginTransaction();

                            args = new Bundle();
                            args.putString("color", "blue");
                            fragment = new lab02Fragment();
                            fragment.setArguments(args);

                            fragmentTransaction.replace(R.id.fragmentPos, fragment);
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();
                            break;
                        case R.id.my_item2:
                            fragmentManager = getFragmentManager();
                            fragmentTransaction =
                                    fragmentManager.beginTransaction();

                            args = new Bundle();
                            args.putString("color", "green");
                            fragment = new lab02Fragment2();
                            fragment.setArguments(args);

                            fragmentTransaction.replace(R.id.fragmentPos, fragment);
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();

                            break;
                        case R.id.my_item3:
                            fragmentManager = getFragmentManager();
                            fragmentTransaction =
                                    fragmentManager.beginTransaction();

                            args = new Bundle();
                            args.putString("color", "cyan");
                            fragment = new lab02Fragment3();
                            fragment.setArguments(args);

                            fragmentTransaction.replace(R.id.fragmentPos, fragment);
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();

                            break;
                        case R.id.my_item4:
                            fragmentManager = getFragmentManager();
                            fragmentTransaction =
                                    fragmentManager.beginTransaction();

                            args = new Bundle();
                            args.putString("color", "purple");
                            fragment = new lab02Fragment4();
                            fragment.setArguments(args);

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

