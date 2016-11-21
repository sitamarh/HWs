package com.example.ex1;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity
    implements  FoodListFragment.OnFragmentInteractionListener,
        MainFragment.OnFragmentInteractionListener{

    MenuItem menuButtonSendOrder;

    public boolean BigScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getResources().getConfiguration().smallestScreenWidthDp >= 600){
            BigScreen = true;
        } else {
            BigScreen = false;
        }


        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }

            MainFragment mainFragment = new MainFragment();

            mainFragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,mainFragment).commit();


            if (BigScreen) {
                FoodListFragment foodListFragment = new FoodListFragment();

                foodListFragment.setArguments((getIntent().getExtras()));

                getSupportFragmentManager().beginTransaction().add(R.id.second_fragment_container, foodListFragment).commit();
            }
        }
    }
    @Override
    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.action_item, menu);

        menuButtonSendOrder = menu.getItem(0);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_item) {
            if (MainFragment.food_mark == 1 && MainFragment.number_of_sheep > 0) {
                Intent intent = new Intent(this, Main2Activity.class);

                startActivity(intent);

                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}