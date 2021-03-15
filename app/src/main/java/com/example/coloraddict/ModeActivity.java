package com.example.coloraddict;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ModeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);
    }

    public void goToPseudo(View v){
        startActivity(new Intent(ModeActivity.this, PseudoActivity.class));
    }

    public void goToMain(View v){
        startActivity(new Intent(ModeActivity.this, MenuActivity.class));
    }
}