package com.example.coloraddict;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class Settings extends AppCompatActivity {
    private Switch mMusicSwitch;
    private Switch mSoundSwitch;
    private Button mMenuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        mMusicSwitch = (Switch) findViewById(R.id.musique);
        mSoundSwitch = (Switch) findViewById(R.id.bruitage);
        mMenuButton = (Button) findViewById(R.id.reglageMenu);

        mMenuButton.setEnabled(true);

        mMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The user just clicked
                // come back to Menu
            }
        });
    }
}