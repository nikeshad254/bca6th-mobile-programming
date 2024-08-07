package com.example.listviewexample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    ListView pLv;
    ListView nLv;
    String[] list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        List<Nation> nationList = new ArrayList<Nation>();

        nationList.add(new Nation("Nepal", R.drawable.nepal, "np"));
        nationList.add(new Nation("India", R.drawable.india, "in"));
        nationList.add(new Nation("China", R.drawable.china, "in"));

        pLv = findViewById(R.id.progListView);
        list = getResources().getStringArray(R.array.prog_arr);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, list);

        pLv.setAdapter(arrayAdapter);


        nLv = findViewById(R.id.nationListView);
        NationListAdapter nationAdapter = new NationListAdapter(this, nationList);
        nLv.setAdapter(nationAdapter);
    }
}
