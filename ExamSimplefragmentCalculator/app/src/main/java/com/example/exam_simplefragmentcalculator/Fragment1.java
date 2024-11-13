package com.example.exam_simplefragmentcalculator;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {

    EditText num1EditText;
    EditText num2EditText;
    TextView resultTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment, container, false);

        num1EditText = view.findViewById(R.id.num1);
        num2EditText = view.findViewById(R.id.num2);
        Button calculateButton = view.findViewById(R.id.btn);
        resultTextView = view.findViewById(R.id.result);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSum();
            }
        });

        return view;
    }

    private void calculateSum() {
        String num1Str = num1EditText.getText().toString();
        String num2Str = num2EditText.getText().toString();

        if (TextUtils.isEmpty(num1Str) || TextUtils.isEmpty(num2Str)) {
            resultTextView.setText("Please enter both numbers");
            return;
        }

        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double sum = num1 + num2;

        resultTextView.setText("Result: " + sum);
    }
}
