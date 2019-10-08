package com.example.endevina2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;


public class Ranking extends AppCompatActivity {

    static ArrayList<String> records = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LinearLayout LinearLayoutView = new LinearLayout(this);


        TextView DisplayStringArray = new TextView(this);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ranking);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        int intentos=intent.getIntExtra("intentos",100);
        String high=nombre+": "+intentos;


        records.add((high));

       // TextView Ranking = (TextView) findViewById(R.id.Ranking);


        DisplayStringArray.setTextSize(25);
        LinearLayoutView.addView(DisplayStringArray);

        for (int i=0; i<records.size();i++){
            DisplayStringArray.append(records.get(i));
            DisplayStringArray.append("\n");
        }
        setContentView(LinearLayoutView);

    }



    }

