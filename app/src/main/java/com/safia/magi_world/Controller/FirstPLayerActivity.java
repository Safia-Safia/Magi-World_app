package com.safia.magi_world.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.safia.magi_world.Model.Personnage;
import com.safia.magi_world.R;

public class FirstPLayerActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton mWariorBtn, mMageBtn, mRodeurBtn;
    private Button mNextbtn;
    private static Personnage player1;
    private EditText mLevel, mStrength, mAgility, mIntelligence;
    private AlertDialog.Builder dialogueBox;
    String characterClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_class);


        mLevel = findViewById(R.id.editText);
        mStrength = findViewById(R.id.editText2);
        mAgility = findViewById(R.id.editText3);
        mIntelligence = findViewById(R.id.editText4);

        mWariorBtn = findViewById(R.id.guerrier_Button);
        mMageBtn = findViewById(R.id.mage_Button);
        mRodeurBtn = findViewById(R.id.rodeur_Button);

        mWariorBtn.setOnClickListener(this);
        mRodeurBtn.setOnClickListener(this);
        mMageBtn.setOnClickListener(this);

        mNextbtn = findViewById(R.id.nextbtn);
        mNextbtn.setOnClickListener(this);
      //  mNextButton.setEnabled(false);


    }


    @Override
    public void onClick(View v) {
    if (v.getId() == R.id.nextbtn){
        Intent intent = new Intent (this,SecondPlayerActivity.class);
        startActivity(intent);
    }

    if (v.getId() == R.id.guerrier_Button){
        characterClass = "guerrier";
    }
    }
}
