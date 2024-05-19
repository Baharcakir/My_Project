package com.example.myproject;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StoryView extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_view);

        // Intent'ten seçilen hikayenin kaynak kimliğini al
        int storyResId = getIntent().getIntExtra("storyResId", -1);

        // Seçilen hikayeyi metin dosyasından oku
        String story = readStoryFromTxtFile(this, storyResId);

        // TextView'i bul ve metni ayarla
        TextView storyTextView = findViewById(R.id.storyTextView);
        storyTextView.setText(story);
    }

    // Metin dosyasını okuyan yardımcı fonksiyon
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
