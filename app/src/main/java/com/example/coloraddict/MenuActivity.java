/**
 * @author Lucas Marc-Martin
 * @date 18.03.2021
 */

package com.example.coloraddict;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        PlayBackgroundSound();
    }

    public void goToRules(View v){
        startActivity(new Intent(MenuActivity.this, RulesActivity.class));
    }

    public void goToSettings(View v){
        startActivity(new Intent(MenuActivity.this, SettingsActivity.class));
    }

    public void goToPseudo(View v){
        startActivity(new Intent(MenuActivity.this, PseudoActivity.class));
    }

    /**
     * Start the background music
     */
    public void PlayBackgroundSound() {
        Intent intent = new Intent(MenuActivity.this, BackgroundSoundService.class);
        startService(intent);
    }
}