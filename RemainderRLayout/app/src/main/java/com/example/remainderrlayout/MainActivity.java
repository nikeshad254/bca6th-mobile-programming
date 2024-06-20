package com.example.remainderrlayout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.Nullable;

import java.util.ArrayList;

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


        // add item into time
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("8:00 am");
        arrayList.add("10:00 am");
        arrayList.add("12:00 am");
        timeSpinner = findViewById(R.id.times);
        ArrayAdapter<String> timeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayList);
        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeSpinner.setAdapter(timeAdapter);

    }
}
