package com.example.ex1;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

public class MainActivity extends FragmentActivity
    implements  FoodListFragment.OnFragmentInteractionListener,
        MainFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }

            MainFragment mainFragment = new MainFragment();

            mainFragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,mainFragment).commit();
        }
    }
    @Override
    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
    }
}