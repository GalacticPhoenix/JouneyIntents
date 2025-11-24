package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PlanetAActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_a);

        Intent intent = getIntent();
        String captainName = intent.getStringExtra("captainName");
        int fuelLevel = intent.getIntExtra("fuelLevel", 100);
        boolean hasAlienArtifact = intent.getBooleanExtra("hasAlienArtifact", false);

        TextView storyTextView = findViewById(R.id.textView_planet_a_story);
        storyTextView.setText(String.format("Captain %s, you have arrived at Planet A. Your fuel is at %d. What are your orders?", captainName, fuelLevel));


        Button exploreButton = findViewById(R.id.button_explore_planet_a);
        Button scanButton = findViewById(R.id.button_scan_planet_a);

        exploreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent = new Intent(PlanetAActivity.this, PlanetBActivity.class);
                nextIntent.putExtra("captainName", captainName);
                nextIntent.putExtra("fuelLevel", fuelLevel - 10);
                nextIntent.putExtra("hasAlienArtifact", hasAlienArtifact);
                startActivity(nextIntent);
            }
        });

        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent = new Intent(PlanetAActivity.this, OrbitActivity.class);
                nextIntent.putExtra("captainName", captainName);
                nextIntent.putExtra("fuelLevel", fuelLevel - 5);
                nextIntent.putExtra("hasAlienArtifact", hasAlienArtifact);
                startActivity(nextIntent);
            }
        });
    }
}