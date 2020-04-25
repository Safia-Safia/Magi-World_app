
package com.safia.magi_world.Controller;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.text.Editable;
        import android.text.TextWatcher;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ImageButton;
        import com.safia.magi_world.R;



public class SecondPlayerActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mWariorBtn, mMageBtn, mRodeurBtn;
    private Button mNextButton;
    private String characterClass;
    private EditText mLevel, mStrenght, mAgility, mIntelligence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_class);

        mWariorBtn = findViewById(R.id.guerrier_Button);
        mMageBtn = findViewById(R.id.mage_Button);
        mRodeurBtn = findViewById(R.id.rodeur_Button);
        mNextButton = findViewById(R.id.nextbtn);

        mLevel = findViewById(R.id.editText);
        mStrenght = findViewById(R.id.editText2);
        mAgility = findViewById(R.id.editText3);
        mIntelligence = findViewById(R.id.editText4);


        mWariorBtn.setOnClickListener(this);
        mRodeurBtn.setOnClickListener(this);
        mMageBtn.setOnClickListener(this);
        mNextButton.setOnClickListener(this);
        mNextButton.setEnabled(false);



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
            Intent intent = new Intent (this,SecondPlayerActivity.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.guerrier_Button){
            characterClass = "guerrier";
        }
    }
}

