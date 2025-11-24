package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EncryptedMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypted_message);

        Intent intent = getIntent();
        String captainName = intent.getStringExtra("captainName");
        int fuelLevel = intent.getIntExtra("fuelLevel", 100);

        TextView storyTextView = findViewById(R.id.textView_encrypted_message_story);

        if (fuelLevel > 50) {
            storyTextView.setText(String.format("Congratulations Captain %s! You have found the habitable planet with %d fuel remaining.", captainName, fuelLevel));
        } else {
            storyTextView.setText(String.format("Captain %s, you have found the habitable planet, but your fuel is critically low at %d.", captainName, fuelLevel));
        }

        Button nextButton = findViewById(R.id.button_go_to_habitable_planet);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent = new Intent(EncryptedMessageActivity.this, WinActivity.class);
                nextIntent.putExtra("captainName", captainName);
                startActivity(nextIntent);
            }
        });
    }
}