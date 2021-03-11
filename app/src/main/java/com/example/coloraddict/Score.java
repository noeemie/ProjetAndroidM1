package com.example.coloraddict;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class Score extends AppCompatActivity {
    private ScrollView mScrollScore;
    private Button mButtonMenu;
    private TextView mScoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        mScrollScore = (ScrollView) findViewById(R.id.scrollScore);
        mButtonMenu = (Button) findViewById(R.id.scoreMenu);
        mScoreText = (TextView) findViewById(R.id.score);

        mButtonMenu.setEnabled(true);

        mButtonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The user just clicked
                // come back to Menu
            }
        });
    }
}