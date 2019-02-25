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

    private void CreateFragment(String color){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        Fragment fragment = new lab02Fragment();

        Bundle args = new Bundle();
        args.putString("color", color);
        fragment.setArguments(args);

        fragmentTransaction.replace(R.id.fragmentPos, fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lr1_second);

        TextView myText = findViewById(R.id.textView2);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        myText.setText(name);



        mDrawerLayout = findViewById(R.id.my_drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);


        navigationView.setCheckedItem(R.id.my_item3);

        CreateFragment("cyan");

        navigationView.setNavigationItemSelectedListener(
            new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem menuItem) {


                    switch(menuItem.getItemId()){
                        case R.id.my_item1:

                            CreateFragment("blue");
                            break;
                        case R.id.my_item2:
                            CreateFragment("green");
                            break;
                        case R.id.my_item3:
                            CreateFragment("cyan");
                            break;
                        case R.id.my_item4:
                            CreateFragment("purple");
                            break;
                    }

                    menuItem.setChecked(true);
                    mDrawerLayout.closeDrawers();
                    return true;

                }
            });
    }
}

