package com.example.ex1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    MenuItem menuButtonSendOrder;

    private static Integer food_mark = 0;

    private static Integer number_of_sheep = 0;

    public static String foodSelected = "";
    public static Integer showFood = 0;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        Button button = (Button) view.findViewById(R.id.button);
        button.setClickable(false);

        EditText editText = (EditText) view.findViewById(R.id.edit_message);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                EditText editText = (EditText) getView().findViewById(R.id.edit_message);

                String value = editText.getText().toString();

                Integer intValue = 0;

                if (value.isEmpty() == false) {

                    intValue = Integer.parseInt(value);
                }

                SeekBar seekBar = (SeekBar) getView().findViewById(R.id.seekBar3);

                seekBar.setProgress(intValue);

                number_of_sheep = intValue;

                Button button = (Button) getView().findViewById(R.id.button);

                if (food_mark == 1 && number_of_sheep > 0) {
                    button.setClickable(true);
                } else {
                    button.setClickable(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                EditText editText = (EditText) getView().findViewById(R.id.edit_message);

                String value = editText.getText().toString();

                Integer intValue = 0;

                if (value.isEmpty() == false) {

                    intValue = Integer.parseInt(value);
                }

                SeekBar seekBar = (SeekBar) getView().findViewById(R.id.seekBar3);

                seekBar.setProgress(intValue);

                number_of_sheep = intValue;

                Button button = (Button) getView().findViewById(R.id.button);

                if (food_mark == 1 && number_of_sheep > 0) {
                    button.setClickable(true);
                } else {
                    button.setClickable(false);
                }
            }
        });

        SeekBar seekBar = (SeekBar) view.findViewById(R.id.seekBar3);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                Integer seekBarValue = seekBar.getProgress();

                TextView textView = (TextView) getView().findViewById(R.id.edit_message);
                textView.setText(seekBarValue.toString());

                number_of_sheep = seekBarValue;

                Button button = (Button) getView().findViewById(R.id.button);

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
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

        });

        if (showFood.equals(1)) {
            Toast.makeText(getActivity(), getString(R.string.youSelected) + " " + foodSelected.toString(), Toast.LENGTH_SHORT).show();

            showFood = 0;
        }

        Button sButton = (Button) view.findViewById(R.id.selectButton);
        sButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                transaction.replace(R.id.fragment_container, new FoodListFragment());
                transaction.addToBackStack(null);

                transaction.commit();
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onResume() {
        super.onResume();

        if (showFood.equals(1)) {
            Toast.makeText(this.getContext(), getString(R.string.youSelected) + " " + foodSelected.toString(), Toast.LENGTH_SHORT).show();

            showFood = 0;
        }
    }

    public void boxClicked(View view) {

        CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkBox);

        if (checkBox.isChecked()) {
            food_mark = 1;
        } else {
            food_mark = 0;
        }

        Button button = (Button) view.findViewById(R.id.button);

        if (food_mark == 1 && number_of_sheep > 0) {
            button.setClickable(true);
        } else {
            button.setClickable(false);
        }
    }

    public void buttonClick(View view){
        Intent intent = new Intent(getActivity(), Main2Activity.class);

        startActivity(intent);
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this.getContext()).inflate(R.menu.action_item, menu);

        menuButtonSendOrder = menu.getItem(0);

        return super.onCreateOptionsMenu(menu);
    }
*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_item) {
            if (food_mark == 1 && number_of_sheep > 0) {
                Intent intent = new Intent(getActivity(), Main2Activity.class);

                startActivity(intent);

                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
