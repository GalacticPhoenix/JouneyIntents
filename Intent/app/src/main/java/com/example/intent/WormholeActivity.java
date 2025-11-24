package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WormholeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wormhole);

        Intent intent = getIntent();
        String captainName = intent.getStringExtra("captainName");
        int fuelLevel = intent.getIntExtra("fuelLevel", 100);

        TextView storyTextView = findViewById(R.id.textView_wormhole_story);

        int newFuelLevel = fuelLevel - 50;

        if (newFuelLevel <= 0) {
            storyTextView.setText(String.format("Captain %s, you are out of fuel in an unknown quadrant. Mission failed.", captainName));
        } else {
            storyTextView.setText(String.format("Captain %s, you have traversed the wormhole. Your fuel is critically low at %d.", captainName, newFuelLevel));
        }

        Button endMissionButton = findViewById(R.id.button_end_mission);
        endMissionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent = new Intent(WormholeActivity.this, LoseActivity.class);
                nextIntent.putExtra("captainName", captainName);
                startActivity(nextIntent);
            }
        });
    }
}