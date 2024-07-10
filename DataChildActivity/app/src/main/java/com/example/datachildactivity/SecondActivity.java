package com.example.datachildactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class SecondActivity extends Activity {
    EditText unameTxt;
    Button submitButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        unameTxt = findViewById(R.id.editTxt);
        submitButton = findViewById(R.id.submitBtn);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(unameTxt.getText().length() < 1) return;

                Intent resultIntent = new Intent();
                resultIntent.putExtra("username", unameTxt.getText().toString());
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
