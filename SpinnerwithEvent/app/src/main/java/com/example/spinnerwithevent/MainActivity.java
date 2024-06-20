package com.example.spinnerwithevent;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.lang.reflect.Array;

public class MainActivity extends Activity {
    Spinner planetSpinner;
    TextView messageView;
    String[] planetArr;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        planetSpinner = findViewById(R.id.planetSpinner);
        messageView = findViewById(R.id.msgView);


        ArrayAdapter<CharSequence> planetAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.planet_array,
                android.R.layout.simple_spinner_item
        );

        planetAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        planetSpinner.setAdapter(planetAdapter);



        planetSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // show in the Text View
                messageView.setText("You selected: " +parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // ntg
            }
        });


    }
}
