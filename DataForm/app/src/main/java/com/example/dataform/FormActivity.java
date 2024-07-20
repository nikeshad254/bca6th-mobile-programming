package com.example.dataform;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class FormActivity extends Activity {
    String spinnerVal="", hobbies="", genderVal="";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);

        EditText name = findViewById(R.id.name);
        EditText address = findViewById(R.id.address);
        CheckBox hobby1 = findViewById(R.id.hobby1);
        CheckBox hobby2 = findViewById(R.id.hobby2);
        CheckBox hobby3 = findViewById(R.id.hobby3);
        CheckBox hobby4 = findViewById(R.id.hobby4);

        RadioGroup genderGrp = findViewById(R.id.genderGrp);
        genderGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                genderVal = rb.getText().toString();
            }
        });

        Spinner programSpinner = findViewById(R.id.programSpinner);

        ArrayAdapter<CharSequence> programAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.program_array,
                android.R.layout.simple_spinner_item
        );

        programAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        programSpinner.setAdapter(programAdapter);

        // to fill up the spinner with value
        programSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerVal = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinnerVal = "";
            }
        });

        Button submitBtn = findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hobbies = "";
                if(hobby1.isChecked()) hobbies += hobby1.getText() + " , ";
                if(hobby2.isChecked()) hobbies += hobby2.getText() + " , ";
                if(hobby3.isChecked()) hobbies += hobby3.getText() + " , ";
                if(hobby4.isChecked()) hobbies += hobby4.getText() + " , ";

                if(name.getText().toString() == "" || address.getText().toString() == ""
                || genderVal == "" || spinnerVal == "" || hobbies == ""
                ){
                    Toast.makeText(FormActivity.this, "Fill all the fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(FormActivity.this, DisplayActivity.class);
                intent.putExtra("name", name.getText().toString());
                intent.putExtra("address", address.getText().toString());
                intent.putExtra("gender", genderVal);
                intent.putExtra("program", spinnerVal);
                intent.putExtra("hobbies", hobbies);
                startActivity(intent);
            }
        });

    }

}
