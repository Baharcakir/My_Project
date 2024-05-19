package com.example.myproject;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import android.content.Context;
import java.util.Locale;

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
        boolean isTurkish = Locale.getDefault().getLanguage().equals("tr");

        if (viewId == R.id.rapunzel) {
            Toast.makeText(this, "rapunzel clicked", Toast.LENGTH_SHORT).show();
            if (isTurkish) {
                openStoryView(R.raw.rapunzel);
            }else {openStoryView(R.raw.rapunzel_en);}
        } else if (viewId == R.id.hanselAndGretel) {
            Toast.makeText(this, "hansel and Gretel clicked", Toast.LENGTH_SHORT).show();
            if (isTurkish) {
                openStoryView(R.raw.hansel);
            }else {openStoryView(R.raw.hansel_en);}
        } else if (viewId == R.id.littleRedRidingHood) {
            Toast.makeText(this, "little Red Riding Hood clicked", Toast.LENGTH_SHORT).show();
            if (isTurkish) {
                openStoryView(R.raw.littlered);
            }else {openStoryView(R.raw.littlered_en);}
        } else if (viewId == R.id.pinocchio) {
            Toast.makeText(this, "pinocchio clicked", Toast.LENGTH_SHORT).show();
            if (isTurkish) {
                openStoryView(R.raw.pinocchio);
            }else {openStoryView(R.raw.pinocchio_en);}
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

    private String readStoryFromTxtFile(Context context, int resourceId) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            // Kaynak dosyasını aç
            InputStream inputStream = context.getResources().openRawResource(resourceId);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            // Satır satır oku ve stringBuilder'a ekle
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }

            // Dosyayı kapat
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Okunan metni geri döndür
        return stringBuilder.toString();
    }

}
