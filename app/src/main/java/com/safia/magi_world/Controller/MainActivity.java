package com.safia.magi_world.Controller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.safia.magi_world.Model.Character;
import com.safia.magi_world.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String PLAYER_NUMBER ="PLAYER_NUMBER";
    public static final int PLAYER_REQUEST_CODE = 1;
    public static final String PLAYER = "PLAYER";
    private static Character p1 = null;
    private static Character p2 = null;
    int playerNumber;

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
                playerNumber =1;
                Intent playActivityIntent = new Intent(MainActivity.this, PlayerCreationActivity.class);
                playActivityIntent.putExtra(PLAYER,playerNumber);
                startActivityForResult(playActivityIntent, PLAYER_REQUEST_CODE);
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
                Intent regleActivityIntent = new Intent(MainActivity.this, RulesActivity.class);
                startActivity(regleActivityIntent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PLAYER_REQUEST_CODE) {
            if (resultCode ==RESULT_OK) {
                if (playerNumber == 1) {
                    p1 = data.getParcelableExtra(PLAYER);
                    Log.i("onActivityResult",p1.getLife()+"");
                    Intent playActivityIntent = new Intent(MainActivity.this, PlayerCreationActivity.class);
                    playActivityIntent.putExtra(PLAYER_NUMBER, ++playerNumber);
                    startActivityForResult(playActivityIntent, PLAYER_REQUEST_CODE);
                }else {
                    p2 = data.getParcelableExtra(PLAYER);
                    Intent gameActivityIntent = new Intent(MainActivity.this, GameActivity.class);
                    gameActivityIntent.putExtra("player_one", p1);
                    gameActivityIntent.putExtra("player_two", p2);
                    startActivity(gameActivityIntent);
                }
            }
        }
    }

    public static List<Character> getPlayers() {
        List<Character> playersList = new ArrayList<>();
        playersList.add(p1);
        playersList.add(p2);
        return playersList;
    }
}