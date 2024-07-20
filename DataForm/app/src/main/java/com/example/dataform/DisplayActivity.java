package com.example.dataform;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class DisplayActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        TextView name = findViewById(R.id.name);
        TextView address = findViewById(R.id.address);
        TextView program = findViewById(R.id.program);
        TextView gender = findViewById(R.id.gender);
        TextView hobbies = findViewById(R.id.hobby);

        Intent intent = getIntent();

        name.setText("name: "+ intent.getStringExtra("name"));
        address.setText("address: "+ intent.getStringExtra("address"));
        program.setText("program: "+ intent.getStringExtra("program"));
        gender.setText("gender: "+ intent.getStringExtra("gender"));
        hobbies.setText("hobbies: "+ intent.getStringExtra("hobbies"));
    }
}
