package com.kolev.programming_md;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button buttonCalculator = findViewById(R.id.button_calculator);
        Button drawingButton = findViewById(R.id.button_option_2);
        Button buttonOption3 = findViewById(R.id.button_option_3);
        Button buttonOption4 = findViewById(R.id.button_option_4);
        Button buttonOption5 = findViewById(R.id.button_option_5);
        Button buttonOption6 = findViewById(R.id.button_option_6);

        buttonCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuActivity.this, CalculatorActivity.class);
                startActivity(intent);
            }
        });

        drawingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuActivity.this, DrawActivity.class);
                startActivity(intent);
            }
        });

        buttonOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        buttonOption4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        buttonOption5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        buttonOption6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
}