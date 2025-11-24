package com.example.intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ResearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_research);

        Intent intent = getIntent();
        String captainName = intent.getStringExtra("captainName");
        int fuelLevel = intent.getIntExtra("fuelLevel", 100);
        boolean hasAlienArtifact = intent.getBooleanExtra("hasAlienArtifact", false);

        TextView storyTextView = findViewById(R.id.textView_research_story);

        ArrayList<String> inventory = new ArrayList<>();
        inventory.add("Data Log");
        if (hasAlienArtifact) {
            inventory.add("Alien Artifact");
        }

        StringBuilder inventoryText = new StringBuilder("Inventory: ");
        for (String item : inventory) {
            inventoryText.append(item).append(", ");
        }

        storyTextView.setText(String.format("Captain %s, you have found a data log. Your fuel is %d. %s", captainName, fuelLevel, inventoryText.toString()));

        Button researchButton = findViewById(R.id.button_research_website);
        researchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.nasa.gov"));
                startActivity(browserIntent);

                Intent nextIntent = new Intent(ResearchActivity.this, EncryptedMessageActivity.class);
                nextIntent.putExtra("captainName", captainName);
                nextIntent.putExtra("fuelLevel", fuelLevel);
                nextIntent.putExtra("hasAlienArtifact", hasAlienArtifact);
                startActivity(nextIntent);
            }
        });

        Button ignoreButton = findViewById(R.id.button_continue_without_research);
        ignoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent = new Intent(ResearchActivity.this, WormholeActivity.class);
                nextIntent.putExtra("captainName", captainName);
                nextIntent.putExtra("fuelLevel", fuelLevel);
                nextIntent.putExtra("hasAlienArtifact", hasAlienArtifact);
                startActivity(nextIntent);
            }
        });
    }
}