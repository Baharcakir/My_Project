package com.example.myproject;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SynonymQuizResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synonym_quiz_result);

        TextView tvName = findViewById(R.id.tv_name);
        TextView tvScore = findViewById(R.id.tv_score);
        Button btnFinish = findViewById(R.id.btn_finish);

        int totalQuestions = getIntent().getIntExtra(Constants.TOTAL_QUESTIONS, 0);
        int correctAnswers = getIntent().getIntExtra(Constants.CORRECT_ANSWER, 0);
        tvScore.setText("Your score is " + correctAnswers + " out of " + totalQuestions);

        btnFinish.setOnClickListener(v -> {
            startActivity(new Intent(this, SynonymAntonym.class));
        });
    }
}
