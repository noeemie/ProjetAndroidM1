/**
 * @author Lucas Marc-Martin
 * @date 18.03.2021
 */
package com.example.coloraddict;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PseudoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pseudo);
    }

    public void goToBluetooth(View v){
        startActivity(new Intent(PseudoActivity.this, BluetoothActivity.class));
    }

    public void goToMenu1(View v){
        startActivity(new Intent(PseudoActivity.this, MenuActivity.class));
    }
}