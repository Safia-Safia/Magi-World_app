package com.safia.magi_world.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.safia.magi_world.R;

public class Choice_classActivity extends AppCompatActivity {
    private ImageButton mGButton, mMButton, mRButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_class);

        mGButton = findViewById(R.id.guerrier_Button);
        mMButton = findViewById(R.id.mage_Button);
        mRButton = findViewById(R.id.rodeur_Button);

        mGButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent guerrierButtonIntent = new Intent(Choice_classActivity.this, Characteritic_Activity.class);
                startActivity(guerrierButtonIntent);
            }
        });
        mMButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent guerrierButtonIntent = new Intent(Choice_classActivity.this, Characteritic_Activity.class);
                startActivity(guerrierButtonIntent);
            }
        });
        mRButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent guerrierButtonIntent = new Intent(Choice_classActivity.this, Characteritic_Activity.class);
                startActivity(guerrierButtonIntent);
            }
        });

    }
}
