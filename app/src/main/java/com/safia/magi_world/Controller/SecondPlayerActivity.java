
package com.safia.magi_world.Controller;

        import androidx.appcompat.app.AppCompatActivity;

        import android.annotation.SuppressLint;
        import android.os.Bundle;
        import android.text.Editable;
        import android.text.TextWatcher;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ImageButton;
        import android.widget.TextView;

        import com.safia.magi_world.R;



public class SecondPlayerActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mWariorBtn, mMageBtn, mRodeurBtn;
    private Button mNextButton;
    private String characterClass;
    private EditText mLevel, mStrenght, mAgility, mIntelligence;

    @SuppressLint("StringFormatMatches")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_chara);

        mWariorBtn = findViewById(R.id.btn_warrior);
        mMageBtn = findViewById(R.id.mage_Button);
        mRodeurBtn = findViewById(R.id.rodeur_Button);
        mNextButton = findViewById(R.id.nextbtn);

        mLevel = findViewById(R.id.edit_level);
        mStrenght = findViewById(R.id.edit_strength);
        mAgility = findViewById(R.id.edit_agility);
        mIntelligence = findViewById(R.id.edit_intelligence);


        mWariorBtn.setOnClickListener(this);
        mRodeurBtn.setOnClickListener(this);
        mMageBtn.setOnClickListener(this);
       mNextButton.setOnClickListener(this);
        mNextButton.setEnabled(false);

        TextView mNumJoueur = findViewById(R.id.creat_du_joeur);
        mNumJoueur.setText(getString(R.string.creation_joueur,2));


        mIntelligence.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mNextButton.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {
               /* if (intelligence > 100) {
                    mIntelligence.setError(getString(R.string.supA100));
                }*/
            }
        });

    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.nextbtn){
           // Intent intent = new Intent (this,PlayActivity.class);
            //startActivity(intent);
            mNextButton.setEnabled(false);
        }
        if (v.getId() == R.id.btn_warrior){
            characterClass = "guerrier";
        }
        if (v.getId() == R.id.rodeur_Button){
            characterClass = "rodeur";
        }
        if (v.getId() == R.id.mage_Button){
            characterClass = "mage";
        }
    }
}

