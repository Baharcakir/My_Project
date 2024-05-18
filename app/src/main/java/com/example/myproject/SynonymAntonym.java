package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SynonymAntonym extends AppCompatActivity {

    private Button synonymButton;
    private Button antonymButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synonym_antonym);

        synonymButton = findViewById(R.id.synonymButton);
        antonymButton = findViewById(R.id.antonymButton);

        synonymButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSynonymActivity();
            }
        });

        antonymButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAntonymActivity();
            }
        });
    }

    private void openSynonymActivity() {
        Intent intent = new Intent(this, SynonymQuiz.class);
        startActivity(intent);
    }

    private void openAntonymActivity() {
        Intent intent = new Intent(this, AntonymQuiz.class);
        startActivity(intent);
    }
}