package com.safia.magi_world.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.safia.magi_world.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mPlayA = findViewById(R.id.activity_main_play_btn1);
        Button mPlayB = findViewById(R.id.activity_main_play_btn2);
        Button mPlayC = findViewById(R.id.activity_main_play_btn3);

        mPlayA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playActivityIntent = new Intent(MainActivity.this, FirstPLayerActivity.class);
             //   playActivityIntent.putExtra("Numero Joueur", 1);
                startActivity(playActivityIntent);
            }
        });

        mPlayB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rolesActivityIntent = new Intent(MainActivity.this, RolesListActivity.class);
                startActivity(rolesActivityIntent);
            }
        });

        mPlayC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regleActivityIntent = new Intent(MainActivity.this, ReglesActivity.class);
                startActivity(regleActivityIntent);
            }
        });
    }

    //TODO dans le bouton commencer, ajouter des ImagesButton pour nous guider vers la classe désirée
}