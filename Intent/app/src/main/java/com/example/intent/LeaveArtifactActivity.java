package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LeaveArtifactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_artifact);

        Intent intent = getIntent();
        String captainName = intent.getStringExtra("captainName");
        int fuelLevel = intent.getIntExtra("fuelLevel", 100);
        boolean hasAlienArtifact = intent.getBooleanExtra("hasAlienArtifact", false);

        TextView storyTextView = findViewById(R.id.textView_leave_artifact_story);
        storyTextView.setText(String.format("Captain %s, you have left the artifact. Your fuel is now %d.", captainName, fuelLevel));

        Button continueButton = findViewById(R.id.button_continue_mission);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent = new Intent(LeaveArtifactActivity.this, AvoidLifeformActivity.class);
                nextIntent.putExtra("captainName", captainName);
                nextIntent.putExtra("fuelLevel", fuelLevel);
                nextIntent.putExtra("hasAlienArtifact", hasAlienArtifact);
                startActivity(nextIntent);
            }
        });
    }
}