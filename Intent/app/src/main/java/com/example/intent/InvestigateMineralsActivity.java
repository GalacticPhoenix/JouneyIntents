package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InvestigateMineralsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investigate_minerals);

        Intent intent = getIntent();
        String captainName = intent.getStringExtra("captainName");
        int fuelLevel = intent.getIntExtra("fuelLevel", 100);
        boolean hasAlienArtifact = intent.getBooleanExtra("hasAlienArtifact", false);

        TextView storyTextView = findViewById(R.id.textView_investigate_minerals_story);

        int newFuelLevel = fuelLevel + 20;
        storyTextView.setText(String.format("Captain %s, we have gathered fuel. Our new fuel level is %d.", captainName, newFuelLevel));


        Button nextButton = findViewById(R.id.button_head_to_nebula);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent = new Intent(InvestigateMineralsActivity.this, ResearchActivity.class);
                nextIntent.putExtra("captainName", captainName);
                nextIntent.putExtra("fuelLevel", newFuelLevel);
                nextIntent.putExtra("hasAlienArtifact", hasAlienArtifact);
                startActivity(nextIntent);
            }
        });
    }
}