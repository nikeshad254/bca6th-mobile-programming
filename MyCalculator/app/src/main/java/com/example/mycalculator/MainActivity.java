package com.example.mycalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.google.android.material.button.MaterialButton;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends Activity implements View.OnClickListener {

    TextView solutionLbl, resultLbl;
    MaterialButton btnC, btnOpenBrace, btnCloseBrace;
    MaterialButton btnDiv, btnMult, btnSub, btnAdd;
    MaterialButton btn9, btn8, btn7, btn6, btn5, btn4, btn3, btn2, btn1, btn0;
    MaterialButton btnDot, btnBack, btnEqual;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        solutionLbl = findViewById(R.id.solutionLbl);
        resultLbl = findViewById(R.id.resultLbl);

        assignId(btnC, R.id.btnC);
        assignId(btnOpenBrace, R.id.btnOpenBrace);
        assignId(btnCloseBrace, R.id.btnCloseBrace);
        assignId(btnDiv, R.id.btnDiv);
        assignId(btnMult, R.id.btnMult);
        assignId(btnSub, R.id.btnSub);
        assignId(btnAdd, R.id.btnAdd);
        assignId(btn9, R.id.btn9);
        assignId(btn8, R.id.btn8);
        assignId(btn7, R.id.btn7);
        assignId(btn6, R.id.btn6);
        assignId(btn5, R.id.btn5);
        assignId(btn4, R.id.btn4);
        assignId(btn3, R.id.btn3);
        assignId(btn2, R.id.btn2);
        assignId(btn1, R.id.btn1);
        assignId(btn0, R.id.btn0);
        assignId(btnDot, R.id.btnDot);
        assignId(btnBack, R.id.btnBack);
        assignId(btnEqual, R.id.btnEqual);
    }

    void assignId(MaterialButton btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = solutionLbl.getText().toString();

        if (buttonText.equals("C")) {
            solutionLbl.setText("");
            resultLbl.setText("0");
            return;
        }
        if (buttonText.equals("=")) {
            String finalResult = getResult(dataToCalculate);
            solutionLbl.setText(finalResult);
            return;
        }
        if (buttonText.equals("B")) {
            if (dataToCalculate.length() > 0) {
                dataToCalculate = dataToCalculate.substring(0, dataToCalculate.length() - 1);
            }
        } else {
            dataToCalculate = dataToCalculate + buttonText;
        }
        solutionLbl.setText(dataToCalculate);

        String finalResult = getResult(dataToCalculate);

        if (!finalResult.equals("Err")) {
            resultLbl.setText(finalResult);
        }
    }

    String getResult(String data) {
        try {
            Expression expression = new ExpressionBuilder(data).build();
            double result = expression.evaluate();
            return String.valueOf(result);
        } catch (Exception e) {
            return "Err";
        }
    }
}
