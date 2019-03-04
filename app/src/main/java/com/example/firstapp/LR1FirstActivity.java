package com.example.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;

public class LR1FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lr1_first);

    }

    public void onBut1Click(View view){
        EditText nameElem = findViewById(R.id.editText2);
        Intent intent = new Intent(this, LR1SecondActivity.class);
        intent.putExtra("isFirst", "yes");
        startActivity(intent);
    }



}
