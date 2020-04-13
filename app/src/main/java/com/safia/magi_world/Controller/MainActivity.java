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

        Button mPlayB = findViewById(R.id.activity_main_play_btn);

        mPlayB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scoreActivityIntent = new Intent(MainActivity.this, ClassesIndexActivity.class);
                startActivity(scoreActivityIntent);
            }
        });
    }
}
