package com.example.coloraddict;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {
    private Switch mMusicSwitch;
    private Switch mSoundSwitch;
    private Button mMenuButton;

    public void goToMenu2(View v){
        startActivity(new Intent(SettingsActivity.this, MenuActivity.class));
    }

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