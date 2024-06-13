package com.example.remainderrlayout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {
    Spinner dateSpinner;
    Spinner timeSpinner;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // add item into date
        dateSpinner = findViewById(R.id.dates);
        ArrayAdapter<CharSequence> dateAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.dates_array,
                android.R.layout.simple_spinner_item
        );
        dateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dateSpinner.setAdapter(dateAdapter);


        // add item into date
        timeSpinner = findViewById(R.id.times);
        ArrayAdapter<CharSequence> timeAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.time_array,
                android.R.layout.simple_spinner_item
        );
        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeSpinner.setAdapter(timeAdapter);

    }
}
