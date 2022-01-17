package com.qhai.calculator;

import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.*;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private EditText display;
    private String mathOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);
        display.setShowSoftInputOnFocus(false);
        display.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                checkDisplay();
            }
        });
    }

    private void checkDisplay() {
        if (getString(R.string.display).equals(display.getText().toString())
                || display.getText().toString().equals("Lỗi")) {
            display.setText("");
        }
    }

    private void showDisplay(String str) {
        if (str.equals("NaN")) {
            display.setText("Lỗi");
            display.setSelection("Lỗi".length());
        } else {
            display.setText(str);
            display.setSelection(str.length());
        }
    }

    private double formatNumber(Double number) {
        return Math.ceil(number * 10000 * 10000) / 10000 / 10000;
    }

    private void updateText(String stringToAdd) {
        checkDisplay();
        String oldString = display.getText().toString();
        int cursorPosition = display.getSelectionStart();
        String leftString = oldString.substring(0, cursorPosition);
        String rightString = oldString.substring(cursorPosition);
        display.setText(String.format("%s%s%s", leftString, stringToAdd, rightString));
        display.setSelection(cursorPosition + 1);
    }

    public void clearBtn(View view) {
        display.setText("0");
    }

    public void pointBtn(View view) {
        checkDisplay();
        updateText(".");
    }



//    + - x : buttons
public void plusMinusBtn(View view) {
    checkDisplay();
    String stringExpression = display.getText().toString();
    stringExpression.replaceAll("÷", "/");
    stringExpression.replaceAll("×", "*");


    Expression exp = new Expression(stringExpression);

    String result = String.valueOf(exp.calculate()*(-1));

    showDisplay(result);
}

    public void divideBtn(View view) {
        checkDisplay();
        updateText("÷");
    }

    public void addBtn(View view) {
        checkDisplay();
        updateText("+");
    }

    public void subtractBtn(View view) {
        checkDisplay();
        updateText("-");
    }

    public void mutiplyBtn(View view) {
        checkDisplay();
        updateText("×");
    }

    public void equalBtn(View view) {
        String stringExpression = display.getText().toString();
        stringExpression = stringExpression.replaceAll("÷", "/");
        stringExpression = stringExpression.replaceAll("×", "*");

        Expression exp = new Expression(stringExpression);

        String result = String.valueOf(formatNumber(exp.calculate()));

        showDisplay(result);
    }
//  end + - x : buttons


//    number button
public void zeroBtn(View view) {
    checkDisplay();
    updateText("0");
}

    public void oneBtn(View view) {
        checkDisplay();
        updateText("1");
    }

    public void twoBtn(View view) {
        checkDisplay();
        updateText("2");
    }

    public void threeBtn(View view) {
        checkDisplay();
        updateText("3");
    }

    public void fourBtn(View view) {
        checkDisplay();
        updateText("4");
    }

    public void fiveBtn(View view) {
        checkDisplay();
        updateText("5");
    }

    public void sixBtn(View view) {
        checkDisplay();
        updateText("6");
    }

    public void sevenBtn(View view) {
        checkDisplay();
        updateText("7");
    }

    public void eightBtn(View view) {
        checkDisplay();
        updateText("8");
    }

    public void nineBtn(View view) {
        checkDisplay();
        updateText("9");
    }
//  end number buttons
}