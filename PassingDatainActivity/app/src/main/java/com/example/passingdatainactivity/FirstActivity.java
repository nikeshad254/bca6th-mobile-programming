package com.example.passingdatainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {
    String genderVal;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);

        EditText fName = findViewById(R.id.fName);
        EditText lName = findViewById(R.id.lName);
        EditText className = findViewById(R.id.className);
        EditText rollNo = findViewById(R.id.rollNo);
        EditText address = findViewById(R.id.address);
        RadioGroup genderGrp = findViewById(R.id.radioGrp);


        Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
        intent.putExtra("fName", fName.getText());
        intent.putExtra("lName", lName.getText());
        intent.putExtra("className", className.getText());


        genderGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                genderVal = rb.getText().toString();
            }
        });


    }
}
