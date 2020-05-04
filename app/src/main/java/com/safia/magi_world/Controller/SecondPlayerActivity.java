
package com.safia.magi_world.Controller;

        import androidx.appcompat.app.AppCompatActivity;

        import android.annotation.SuppressLint;
        import android.app.AlertDialog;
        import android.content.DialogInterface;
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



public class SecondPlayerActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mWariorBtn, mMageBtn, mRodeurBtn;
    private Button mNextbtn;
    private EditText mLevel, mStrength, mAgility, mIntelligence;
    private int level, life, strength, agility, intelligence;
    String characterClass;
    private static Character player2;

    @SuppressLint("StringFormatMatches")
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

        TextView mNumJoueur = findViewById(R.id.creat_du_joeur);
        mNumJoueur.setText(getString(R.string.creation_joueur,2));



    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.nextbtn){
           // Intent intent = new Intent (this,PlayActivity.class);
            //startActivity(intent);
            mNextbtn.setEnabled(false);
        }
        if (v.getId() == R.id.btn_warrior){
            characterClass = "guerrier";
        }
        if (v.getId() == R.id.btn_rodeur){
            characterClass = "rodeur";
        }
        if (v.getId() == R.id.btn_mage){
            characterClass = "mage";
        }
    }
    private void introduction (){
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.creation_joueur, 1))
                .setMessage(player2.introduction())
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                      //  Intent intent = new Intent(FirstPLayerActivity.this, SecondPlayerActivity.class);
                        //startActivity(intent);
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
                    player2 = new Guerrier(level, strength, intelligence, agility);
                    break;
                case "RODEUR":
                    player2 = new Rodeur(level, strength, intelligence, agility);
                    break;
                case "MAGE":
                    player2 = new Mage(level, strength, intelligence, agility);
                    break;
            }
        }
        return true;
    }

}

