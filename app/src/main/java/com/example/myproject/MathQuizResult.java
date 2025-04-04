package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class MathQuizResult extends AppCompatActivity {

    TextView textResult;
    int great;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_quiz_result);

        Objects.requireNonNull(getSupportActionBar()).hide();

        great = getIntent().getIntExtra("RA", 0);
        textResult = findViewById(R.id.textResult);

        textResult.setText("You answered "+ great + " / 10");

    }
}