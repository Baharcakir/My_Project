package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AntonymQuiz extends AppCompatActivity {

    private TextView questionText;
    private Button option1Button;
    private Button option2Button;
    private Button option3Button;

    private Question[] questions = new Question[] {
            new Question("Büyük kelimesinin zıt anlamlısı nedir?", new String[] {"Küçük", "Cüce ", "Kalıp"}, 0),
            new Question("Ağır kelimesinin zıt anlamlısı nedir?", new String[] {"Şişko", "Hafif", "Kadın"}, 1),
            new Question("Yukarı kelimesinin zıt anlamlısı nedir?", new String[] {"Sol", "Sağ", "Aşağı"}, 2),
            new Question("Genç kelimesinin zıt anlamlısı nedir?", new String[] {"Zaman", "Yaşlı", "Adam"}, 1),
            new Question("Kirli kelimesinin zıt anlamlısı nedir?", new String[] {"Temiz", "Kapalı", "Hijyen"}, 0),
            new Question("Gündüz kelimesinin zıt anlamlısı nedir?", new String[] {"Sabah", "Öğle", "Gece"}, 2),
            new Question("Zengin kelimesinin zıt anlamlısı nedir?", new String[] {"Koca", "Fiyat", "Fakir"}, 2),
            new Question("Doğru kelimesinin zıt anlamlısı nedir?", new String[] {"Soru", "Yanlış", "Cevap"}, 1),
            new Question("Sert kelimesinin zıt anlamlısı nedir?", new String[] {"Yumuşak", "Opak", "Temiz"}, 0),
            new Question("Taze kelimesinin zıt anlamlısı nedir?", new String[] {"Bayat", "Kirli", "Islak"}, 0),
    };

    private int currentQuestionIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antonym_quiz);

        questionText = findViewById(R.id.question_text);
        option1Button = findViewById(R.id.option1_button);
        option2Button = findViewById(R.id.option2_button);
        option3Button = findViewById(R.id.option3_button);

        option1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(0);
            }
        });

        option2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(1);
            }
        });

        option3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(2);
            }
        });

        loadNextQuestion();
    }

    private void loadNextQuestion() {
        if (currentQuestionIndex < questions.length) {
            Question currentQuestion = questions[currentQuestionIndex];
            questionText.setText(currentQuestion.getQuestionText());
            option1Button.setText(currentQuestion.getOptions()[0]);
            option2Button.setText(currentQuestion.getOptions()[1]);
            option3Button.setText(currentQuestion.getOptions()[2]);
        } else {
            showScore();
        }
    }

    private void checkAnswer(int selectedOptionIndex) {
        Question currentQuestion = questions[currentQuestionIndex];
        if (selectedOptionIndex == currentQuestion.getCorrectOptionIndex()) {
            score++;
        }
        currentQuestionIndex++;
        loadNextQuestion();
    }

    private void showScore() {
        Toast.makeText(this, "You scored " + score + " out of " + questions.length, Toast.LENGTH_LONG).show();
        // Optionally, reset quiz or finish activity
    }
}

class Question {
    private String questionText;
    private String[] options;
    private int correctOptionIndex;

    public Question(String questionText, String[] options, int correctOptionIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}