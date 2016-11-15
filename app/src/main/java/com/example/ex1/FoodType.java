package com.example.ex1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import java.util.List;

public class FoodType extends AppCompatActivity {

    Integer[] imageId = {
            R.drawable.gefilte,
            R.drawable.kneydalach,
            R.drawable.kogel,
            R.drawable.rogalach,
            R.drawable.tshulent
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_food_type);

        ListView listView = (ListView)findViewById(R.id.listView);

        final String[] foodList = getResources().getStringArray(R.array.food_array);

        MyArrayAdapter adapter = new MyArrayAdapter(this,foodList,imageId);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                MainActivity.foodSelected = foodList[+ position];
                MainActivity.showFood = 1;

                finish();
            }
        });
    }
}
