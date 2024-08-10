package com.example.gridviewexample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    GridView defaultGrid;
    GridView dynamicGrid;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        defaultGrid = findViewById(R.id.defaultGridView);
        dynamicGrid = findViewById(R.id.customGridView);

        String[] list = getResources().getStringArray(R.array.strCompanyArr);
        ArrayAdapter<String> defaultAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, list);

        defaultGrid.setAdapter(defaultAdapter);

        // custom grid
        List<Company> companies = new ArrayList<Company>();

        companies.add(new Company("Facebook", R.drawable.facebook));
        companies.add(new Company("Amazon", R.drawable.amazon));
        companies.add(new Company("Netflix", R.drawable.netflix));
        companies.add(new Company("Google", R.drawable.google));

        CompanyAdapter companyAdapter = new CompanyAdapter(this,  companies);
        dynamicGrid.setAdapter(companyAdapter);

    }
}
