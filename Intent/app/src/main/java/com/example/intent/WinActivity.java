package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        Intent intent = getIntent();
        String captainName = intent.getStringExtra("captainName");

        TextView winMessage = findViewById(R.id.textView_win_message);
        winMessage.setText(String.format("Congratulations, Captain %s! You have found a new home for humanity!", captainName));
    }
}