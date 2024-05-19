package com.example.myproject;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class StoryView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_view);

        int storyResId = getIntent().getIntExtra("storyResId", 0);
        if (storyResId != 0) {
            String story = getResources().getString(storyResId);
            TextView storyTextView = findViewById(R.id.storyTextView);
            storyTextView.setText(story);
        }
    }
}
