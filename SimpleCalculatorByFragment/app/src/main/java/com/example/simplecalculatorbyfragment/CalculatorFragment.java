package com.example.simplecalculatorbyfragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class CalculatorFragment extends Fragment {

    private EditText num1EditText;
    private EditText num2EditText;
    private TextView resultTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);

        num1EditText = view.findViewById(R.id.num1_edit_text);
        num2EditText = view.findViewById(R.id.num2_edit_text);
        Button calculateButton = view.findViewById(R.id.calculate_button);
        resultTextView = view.findViewById(R.id.result_text_view);

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
