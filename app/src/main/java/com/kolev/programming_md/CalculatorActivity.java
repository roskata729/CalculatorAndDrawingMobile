package com.kolev.programming_md;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView resultText;
    public String currentNumber = "0";
    public String leftNumber = "0";
    private String operation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Button button0 = findViewById(R.id.button_0);
        Button button1 = findViewById(R.id.button_1);
        Button button2 = findViewById(R.id.button_2);
        Button button3 = findViewById(R.id.button_3);
        Button button4 = findViewById(R.id.button_4);
        Button button5 = findViewById(R.id.button_5);
        Button button6 = findViewById(R.id.button_6);
        Button button7 = findViewById(R.id.button_7);
        Button button8 = findViewById(R.id.button_8);
        Button button9 = findViewById(R.id.button_9);
        Button buttonClear = findViewById(R.id.button_clear);
        Button buttonAdd = findViewById(R.id.button_add);
        Button buttonSubtract = findViewById(R.id.button_subtract);
        Button buttonMultiply = findViewById(R.id.button_multiply);
        Button buttonDivide = findViewById(R.id.button_divide);
        Button buttonEquals = findViewById(R.id.button_equal);

        resultText = findViewById(R.id.result_text);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
        buttonSubtract.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonEquals.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_0:
                numberClicked("0");
                break;
            case R.id.button_1:
                numberClicked("1");
                break;
            case R.id.button_2:
                numberClicked("2");
                break;
            case R.id.button_3:
                numberClicked("3");
                break;
            case R.id.button_4:
                numberClicked("4");
                break;
            case R.id.button_5:
                numberClicked("5");
                break;
            case R.id.button_6:
                numberClicked("6");
                break;
            case R.id.button_7:
                numberClicked("7");
                break;
            case R.id.button_8:
                numberClicked("8");
                break;
            case R.id.button_9:
                numberClicked("9");
                break;
            case R.id.button_add:
                operationClicked("+");
                break;
            case R.id.button_subtract:
                operationClicked("-");
                break;
            case R.id.button_multiply:
                operationClicked("*");
                break;
            case R.id.button_divide:
                operationClicked("/");
                break;
            case R.id.button_clear:
                clearClicked();
                break;
            case R.id.button_equal:
                equalsClicked();
                break;
        }
    }

    private void numberClicked(String number) {
        currentNumber = resultText.getText().toString();
        currentNumber += number;
        resultText.setText(currentNumber);
    }

    private void operationClicked(String operation) {
        this.operation = operation;
        leftNumber = resultText.getText().toString();
        resultText.setText("");
    }

    private void clearClicked() {
        resultText.setText("");
        currentNumber = "";
        leftNumber = "";
        operation = "";
    }

    private void equalsClicked() {
        String rightNumber = resultText.getText().toString();
        double result = 0.0;
        switch (operation) {
            case "+":
                result = Double.parseDouble(leftNumber) + Double.parseDouble(rightNumber);
                break;
            case "-":
                result = Double.parseDouble(leftNumber) - Double.parseDouble(rightNumber);
                break;
            case "*":
                result = Double.parseDouble(leftNumber) * Double.parseDouble(rightNumber);
                break;
            case "/":
                if (Double.parseDouble(rightNumber) != 0) {
                    result = Double.parseDouble(leftNumber) / Double.parseDouble(rightNumber);
                } else {
                    resultText.setText("Error");
                    return;
                }
                break;
        }
        resultText.setText(String.valueOf(result));
        operation = "";
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void openDrawActivity(View view) {
        Intent intent = new Intent(this, DrawActivity.class);
        intent.putExtra("operand1", Float.parseFloat(leftNumber));
        intent.putExtra("operand2", Float.parseFloat(currentNumber));
        startActivity(intent);
    }
}


