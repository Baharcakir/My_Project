package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class homepage extends AppCompatActivity {
    CardView gameCard;
    CardView storyCard;
    CardView synonymCard;
    CardView toDoCard;
    CardView operationsCard;

    CardView flagsCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        gameCard = findViewById(R.id.gameCard);
        storyCard = findViewById(R.id.storyCard);
        operationsCard = findViewById(R.id.operationsCard);
        synonymCard = findViewById(R.id.synonymCard);
        toDoCard = findViewById(R.id.toDoCard);
        flagsCard = findViewById(R.id.flagsCard);

        gameCard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent (homepage.this,Game.class);
                startActivity(intent);
            }
        });
        operationsCard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent (homepage.this,MathQuiz.class);
                startActivity(intent);
            }
        });

        synonymCard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent (homepage.this,SynonymAntonym.class);
                startActivity(intent);
            }
        });
        flagsCard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent (homepage.this,SynonymAntonym.class);
                startActivity(intent);
            }
        });
        toDoCard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent (homepage.this, TaskList.class);
                startActivity(intent);
            }
        });
        storyCard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent (homepage.this,SynonymAntonym.class);
                startActivity(intent);
            }
        });

    }
}