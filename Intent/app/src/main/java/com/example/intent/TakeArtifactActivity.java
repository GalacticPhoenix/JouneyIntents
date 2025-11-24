package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TakeArtifactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_artifact);

        Intent intent = getIntent();
        String captainName = intent.getStringExtra("captainName");
        int fuelLevel = intent.getIntExtra("fuelLevel", 100);

        TextView storyTextView = findViewById(R.id.textView_take_artifact_story);
        storyTextView.setText(String.format("Captain %s, you have taken the artifact. Your fuel is now %d.", captainName, fuelLevel));

        Toast.makeText(this, "Alien Artifact added to inventory!", Toast.LENGTH_SHORT).show();

        Button nextButton = findViewById(R.id.button_next_system);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent = new Intent(TakeArtifactActivity.this, ResearchActivity.class);
                nextIntent.putExtra("captainName", captainName);
                nextIntent.putExtra("fuelLevel", fuelLevel);
                nextIntent.putExtra("hasAlienArtifact", true);
                startActivity(nextIntent);
            }
        });
    }
}