package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AvoidLifeformActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avoid_lifeform);

        Intent intent = getIntent();
        String captainName = intent.getStringExtra("captainName");
        int fuelLevel = intent.getIntExtra("fuelLevel", 100);
        boolean hasAlienArtifact = intent.getBooleanExtra("hasAlienArtifact", false);

        TextView storyTextView = findViewById(R.id.textView_avoid_lifeform_story);
        storyTextView.setText(String.format("Captain %s, you have avoided the lifeform. Your fuel level is %d.", captainName, fuelLevel));

        Button nextButton = findViewById(R.id.button_travel_to_wormhole);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent = new Intent(AvoidLifeformActivity.this, WormholeActivity.class);
                nextIntent.putExtra("captainName", captainName);
                nextIntent.putExtra("fuelLevel", fuelLevel);
                nextIntent.putExtra("hasAlienArtifact", hasAlienArtifact);
                startActivity(nextIntent);
            }
        });
    }
}