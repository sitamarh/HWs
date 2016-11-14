package com.example.ex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.List;

public class FoodType extends AppCompatActivity {
private String[] foodList = new String[] {
        "Gefilte Fish",
        "Kneidalach",
        "Kogel",
        "Rogalch",
        "Tsulent"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_food_type);

        ListView listView = (ListView)findViewById(R.id.listView);
        MyArrayAdapter adapter = new MyArrayAdapter(this,foodList);
        listView.setAdapter(adapter);
    }
}
