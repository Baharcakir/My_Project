package com.example.myproject;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

public class Story extends AppCompatActivity implements View.OnClickListener {

    private Button backButton;
    private ImageView Rapunzel;
    private ImageView HanselandGretel;
    private ImageView LittleRedRidingHood;
    private ImageView Pinocchio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        backButton = findViewById(R.id.backButton);
        Rapunzel = findViewById(R.id.rapunzel);
        HanselandGretel = findViewById(R.id.hanselAndGretel);
        LittleRedRidingHood = findViewById(R.id.littleRedRidingHood);
        Pinocchio = findViewById(R.id.pinocchio);

        Rapunzel.setOnClickListener(this);
        HanselandGretel.setOnClickListener(this);
        LittleRedRidingHood.setOnClickListener(this);
        Pinocchio.setOnClickListener(this);
        backButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();

        if (viewId == R.id.rapunzel) {
            Toast.makeText(this, "Rapunzel clicked", Toast.LENGTH_SHORT).show();
            openStoryView(R.string.Rapunzel);
        } else if (viewId == R.id.hanselAndGretel) {
            Toast.makeText(this, "Hansel and Gretel clicked", Toast.LENGTH_SHORT).show();
            openStoryView(R.string.HanselandGretel);
        } else if (viewId == R.id.littleRedRidingHood) {
            Toast.makeText(this, "Little Red Riding Hood clicked", Toast.LENGTH_SHORT).show();
            openStoryView(R.string.LittleRedRidingHood);
        } else if (viewId == R.id.pinocchio) {
            Toast.makeText(this, "Pinocchio clicked", Toast.LENGTH_SHORT).show();
            openStoryView(R.string.Pinocchio);
        } else if (viewId == R.id.backButton) {
            Toast.makeText(this, "Back button clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    private void openStoryView(int storyResId) {
        Intent intent = new Intent(this, StoryView.class);
        intent.putExtra("storyResId", storyResId);
        startActivity(intent);
    }
}
