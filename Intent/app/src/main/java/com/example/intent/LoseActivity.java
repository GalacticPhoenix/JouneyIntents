package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);

        Intent intent = getIntent();
        String captainName = intent.getStringExtra("captainName");

        TextView loseMessage = findViewById(R.id.textView_lose_message);
        loseMessage.setText(String.format("Mission Failed, Captain %s. You are lost in space.", captainName));
    }
}