/**
 * @author Noémie Farizon
 */
package com.example.coloraddict;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RulesActivity extends AppCompatActivity {
    private Button mMenuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        mMenuButton = (Button) findViewById(R.id.regleMenu);

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