package com.example.ex1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {

    private static Integer food_mark = 0;

    private static Integer number_of_sheep = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);
        button.setClickable(false);

        EditText editText = (EditText) findViewById(R.id.edit_message);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                EditText editText = (EditText) findViewById(R.id.edit_message);

                String value = editText.getText().toString();

                Integer intValue = 0;

                if (value.isEmpty() == false) {

                    intValue = Integer.parseInt(value);
                }

                SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar3);

                seekBar.setProgress(intValue);

                number_of_sheep = intValue;

                Button button = (Button) findViewById(R.id.button);

                if (food_mark == 1 && number_of_sheep > 0) {
                    button.setClickable(true);
                } else {
                    button.setClickable(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                EditText editText = (EditText) findViewById(R.id.edit_message);

                String value = editText.getText().toString();

                Integer intValue = 0;

                if (value.isEmpty() == false) {

                    intValue = Integer.parseInt(value);
                }

                SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar3);

                seekBar.setProgress(intValue);

                number_of_sheep = intValue;

                Button button = (Button) findViewById(R.id.button);

                if (food_mark == 1 && number_of_sheep > 0) {
                    button.setClickable(true);
                } else {
                    button.setClickable(false);
                }
            }
        });

        SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar3);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                Integer seekBarValue = seekBar.getProgress();

                TextView textView = (TextView)findViewById(R.id.edit_message);
                textView.setText(seekBarValue.toString());

                number_of_sheep = seekBarValue;

                Button button = (Button) findViewById(R.id.button);

                if (food_mark == 1 && number_of_sheep > 0) {
                    button.setClickable(true);
                } else {
                    button.setClickable(false);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                /*Integer seekBarValue = seekBar.getProgress();

                TextView textView = (TextView)findViewById(R.id.edit_message);
                textView.setText(seekBarValue.toString());

                number_of_sheep = seekBarValue;

                Button button = (Button) findViewById(R.id.button);

                if (food_mark == 1 && number_of_sheep > 0) {
                    button.setClickable(true);
                } else {
                    button.setClickable(false);
                }*/
            }
        });
    }

    public void boxClicked(View view) {

        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);

        if (checkBox.isChecked()) {
            food_mark = 1;
        } else {
            food_mark = 0;
        }

        Button button = (Button) findViewById(R.id.button);

        if (food_mark == 1 && number_of_sheep > 0) {
            button.setClickable(true);
        } else {
            button.setClickable(false);
        }
    }

    public void buttonClick(View view){
        Intent intent = new Intent(this, Main2Activity.class);

        startActivity(intent);
    }
}