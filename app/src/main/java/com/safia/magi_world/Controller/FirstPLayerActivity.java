package com.safia.magi_world.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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

public class FirstPLayerActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton mWariorBtn, mMageBtn, mRodeurBtn;
    private Button mNextbtn;
    private EditText mLevel, mStrength, mAgility, mIntelligence;
    private int level, life, strength, agility, intelligence;
    String characterClass;
    private static Character player1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_chara);


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
       int playerNumber = getIntent().getIntExtra(MainActivity.PLAYER_NUMBER,1);
        TextView mNumJoeur = findViewById(R.id.creat_du_joeur);
        mNumJoeur.setText(getString(R.string.creation_joueur, playerNumber));

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.nextbtn) {
           if( checkValid()) {
               //introduction();
               Intent intent = new Intent();
              // intent.putExtra(MainActivity.PLAYER,player1);
               setResult(RESULT_OK, intent);
               finish();

           }
        }
        if (v.getId() == R.id.btn_warrior) {
            characterClass = "guerrier";
            mWariorBtn.setBackgroundColor(getResources().getColor(R.color.onClickOnClass));
            mMageBtn.setBackgroundColor(getResources().getColor(R.color.noColor));
            mRodeurBtn.setBackgroundColor(getResources().getColor(R.color.noColor));
        }
        if (v.getId() == R.id.btn_rodeur) {
            characterClass = "rodeur";
            mRodeurBtn.setBackgroundColor(getResources().getColor(R.color.onClickOnClass));
            mMageBtn.setBackgroundColor(getResources().getColor(R.color.noColor));
            mWariorBtn.setBackgroundColor(getResources().getColor(R.color.noColor));
        }
        if (v.getId() == R.id.btn_mage) {
            characterClass = "mage";
            mMageBtn.setBackgroundColor(getResources().getColor(R.color.onClickOnClass));
            mWariorBtn.setBackgroundColor(getResources().getColor(R.color.noColor));
            mRodeurBtn.setBackgroundColor(getResources().getColor(R.color.noColor));
        }
    }


    // Introduction of the character cho

    private void introduction (){
       new AlertDialog.Builder(this)
               .setTitle(getString(R.string.creation_joueur, 1))
               .setMessage(player1.introduction())
               .setPositiveButton("SUIVANT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              Intent intent = new Intent(FirstPLayerActivity.this, SecondPlayerActivity.class);
              startActivity(intent);
            }
        })
               .create()
               .show();
    }

    //Check if the conditions are valid.

    public boolean checkValid () {
        //life = level * 5;
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
        }
    else {
        switch (characterClass) {
            case "GUERRIER":
                player1 = new Guerrier(level, strength, intelligence, agility);
                break;
            case "RODEUR":
                player1 = new Rodeur(level, strength, intelligence, agility);
                break;
            case "MAGE":
                player1 = new Mage(level, strength, intelligence, agility);
                break;
        }
    }
        return true;
    }


}
