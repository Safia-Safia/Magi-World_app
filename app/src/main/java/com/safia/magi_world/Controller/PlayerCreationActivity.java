package com.safia.magi_world.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.safia.magi_world.Model.Character;
import com.safia.magi_world.Model.Guerrier;
import com.safia.magi_world.Model.Mage;
import com.safia.magi_world.Model.Rodeur;
import com.safia.magi_world.R;

public class PlayerCreationActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton mWariorBtn, mMageBtn, mRodeurBtn;
    private Button mNextbtn;
    private EditText mLevel, mStrength, mAgility, mIntelligence;
    private int level, life, strength, agility, intelligence;
    private TextView mlife;
    String characterClass;
    public static Character player;
    public int playerNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_chara);

        mlife = findViewById(R.id.life);
        mLevel = findViewById(R.id.edit_level);
        mStrength = findViewById(R.id.edit_strength);
        mAgility = findViewById(R.id.edit_agility);
        mIntelligence = findViewById(R.id.edit_intelligence);

        mWariorBtn = findViewById(R.id.btn_warrior);
        mMageBtn = findViewById(R.id.btn_mage);
        mRodeurBtn = findViewById(R.id.btn_rodeur);

        mWariorBtn.setOnClickListener(this);
        mRodeurBtn.setOnClickListener(this);
        mMageBtn.setOnClickListener(this);

        mNextbtn = findViewById(R.id.nextbtn);
        mNextbtn.setOnClickListener(this);
        playerNumber = getIntent().getIntExtra(MainActivity.PLAYER_NUMBER, 1);

        TextView mNumJoeur = findViewById(R.id.creat_du_joeur);
        mNumJoeur.setText(getString(R.string.player_number, playerNumber));

        mLevel.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                level = Integer.parseInt(mLevel.getText().toString());
                life = level * 5;
                mlife.setText(getString(R.string.life_creation_player, life));
            }


            @Override
            public void afterTextChanged(Editable s) {
                if (mLevel.getText().toString().isEmpty()) {
                    life = 0;
                    mlife.setText(getString(R.string.life_creation_player, life));
                }
            }

        });
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.nextbtn) {
            if (checkValid()) {
                introduction();
            }
        }
        if (v.getId() == R.id.btn_warrior) {
            characterClass = "GUERRIER";
            mWariorBtn.setBackgroundColor(getResources().getColor(R.color.onClickOnClass));
            mMageBtn.setBackgroundColor(getResources().getColor(R.color.noColor));
            mRodeurBtn.setBackgroundColor(getResources().getColor(R.color.noColor));
        }
        if (v.getId() == R.id.btn_rodeur) {
            characterClass = "RODEUR";
            mRodeurBtn.setBackgroundColor(getResources().getColor(R.color.onClickOnClass));
            mMageBtn.setBackgroundColor(getResources().getColor(R.color.noColor));
            mWariorBtn.setBackgroundColor(getResources().getColor(R.color.noColor));
        }
        if (v.getId() == R.id.btn_mage) {
            characterClass = "MAGE";
            mMageBtn.setBackgroundColor(getResources().getColor(R.color.onClickOnClass));
            mWariorBtn.setBackgroundColor(getResources().getColor(R.color.noColor));
            mRodeurBtn.setBackgroundColor(getResources().getColor(R.color.noColor));
        }
    }


    // Introduction of the character

    private void introduction() {
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.player_number, playerNumber))
                .setMessage(player.introduction())
                .setPositiveButton("SUIVANT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent();
                        intent.putExtra(MainActivity.PLAYER, player);
                        Log.i("onClick",player.getLife()+"");
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                })
                .create()
                .show();
    }


    //Check if the conditions are valid.

    public boolean checkValid() {

        level = Integer.parseInt(mLevel.getText().toString());
        strength = Integer.parseInt(mStrength.getText().toString());
        intelligence = Integer.parseInt(mIntelligence.getText().toString());
        agility = Integer.parseInt(mAgility.getText().toString());

        if (strength + intelligence + agility != level) {
            Toast.makeText(this, "La sommes des characteristiques doit être égale au niveau.", Toast.LENGTH_LONG).show();
            return false;
        }
        if (characterClass == null) {
            Toast.makeText(this, "Choisissez votre personnage!", Toast.LENGTH_LONG).show();
            return false;
        } else {
            Log.i("checkValid",characterClass);
            switch (characterClass) {
                case "GUERRIER":
                    player = new Guerrier(level, strength, intelligence, agility);
                    break;
                case "RODEUR":
                    player = new Rodeur(level, strength, intelligence, agility);
                    break;
                case "MAGE":
                    player = new Mage(level, strength, intelligence, agility);
                    break;
            }
        }
        return true;
    }


}
