package com.example.ex1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.ex1.R;

/**
 * Created by ihazor on 10-Nov-16.
 */

public class MyArrayAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final String[] values;


    public MyArrayAdapter(Context context, String[] values){
        super(context, R.layout.activity_food_type,values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
