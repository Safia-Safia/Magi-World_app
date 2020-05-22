package com.safia.magi_world.Controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.safia.magi_world.Model.Character;
import com.safia.magi_world.R;
import com.safia.magi_world.View.TurnRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mBasicAttack, mSpecialAttack;
    private TextView j1,j2,v1,v2;
    private Character player1 ;
    private Character player2 ;

    private RecyclerView.Adapter mAdapter;
    private List<String> mNumberOfTurn = new ArrayList<>();
    private List<String> mAttackList = new ArrayList<>();

    public TextView mPlayers_turn;
    private Character currentPlayer = player1;
    private Character currentOpponent = player2;
    private int nbrOfturn = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        player1 = getIntent().getParcelableExtra(MainActivity.PLAYER_ONE);
        player2= getIntent().getParcelableExtra(MainActivity.PLAYER_TWO);

        j1 = findViewById(R.id.textview_player1_life);
        j1.setText(getString(R.string.player_number_action, 1));
        j2 = findViewById(R.id.textview_player2_life);
        j2.setText(getString(R.string.player_number_action, 2));

        v1 = findViewById(R.id.textview_vie1);
        v2 = findViewById(R.id.textview_vie2);
        v1.setText( getString ( R.string.level_Of_Life, player1.getLife()));
        v2.setText( getString ( R.string.level_Of_Life, player2.getLife()));

       mPlayers_turn = findViewById(R.id.players_turn);
       mPlayers_turn.setText(getString(R.string.playerTurn, 1));

       setUpOpponent();

        mBasicAttack = findViewById(R.id.basic_attack);
        mSpecialAttack = findViewById(R.id.special_attack);
        mBasicAttack.setOnClickListener(this);
        mSpecialAttack.setOnClickListener(this);

        displayRV();

    }

    @Override
    public void onClick(View v) {
        fight(v);
    }

    public void setUpOpponent (){
        player1.setOpponent(player2);
        player2.setOpponent(player1);
        this.currentPlayer = player1;
        this.currentOpponent = player2;
    }

    public void switchAttackingPlayer(){
        Character temp = this.currentPlayer;
        this.currentPlayer = currentOpponent;
        currentOpponent= temp;
    }


    public void fight (View v){

        mNumberOfTurn.add(getString(R.string.turnNbr,++nbrOfturn));

            if (v.getId() == R.id.basic_attack) {
                currentPlayer.basicAttack(currentOpponent);
                mAttackList.add(currentPlayer.basicAttackString(currentOpponent));

            } else {
                if (v.getId() == R.id.special_attack) {
                currentPlayer.specialAttack(currentOpponent);
                mAttackList.add(currentPlayer.specialAttackString(currentOpponent));
                }
            }

        Character temp; //Joueur temporaire à utiliser pour la permutation
        //if the current player is the player1, the player2 is the opponent, swap

        if (this.currentPlayer == player1) {
            mPlayers_turn.setText(getString(R.string.playerTurn, 2));
            v1.setText( getString ( R.string.level_Of_Life, currentPlayer.getLife()));
            v2.setText( getString ( R.string.level_Of_Life, currentOpponent.getLife()));

        } else {
            if (this.currentPlayer == player2)
            mPlayers_turn.setText(getString(R.string.playerTurn, 1));
            v2.setText( getString ( R.string.level_Of_Life, currentPlayer.getLife()));
            v1.setText( getString ( R.string.level_Of_Life, currentOpponent.getLife()));
        }
        switchAttackingPlayer();

        if (currentPlayer.getLife() <= 0 || currentOpponent.getLife() <=0){
            endGame();
        }
    }


    private void endGame () {
        if (player2.getLife() <=0){
          new AlertDialog.Builder(this)
                .setTitle(getString(R.string.endGame))
                .setMessage("Après un combat intense entre ces deux valeureux champions,"+ player2.getName()+" est tombé..."+ player1.getName()+ " a gagné !")
                .setPositiveButton("Acceuil", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent();
                        startActivity(intent);
                        finish();
                    }
                })
                .create()
                .show();}
        else if (player1.getLife()<=0){new AlertDialog.Builder(this)
                .setTitle(getString(R.string.endGame))
                .setMessage("Après un combat intense entre ces deux valeureux champions,"+ player1.getName()+" est tombé..."+ player2.getName()+ " a gagné !")
                .setPositiveButton("Acceuil", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent();
                        startActivity(intent);
                        finish();     }
                })
                .create()
                .show();

        }

    }
    public void displayRV() {
        RecyclerView rv = findViewById(R.id.turn_recycler_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        mAdapter = new TurnRecyclerViewAdapter(this.mNumberOfTurn,this.mAttackList);
        rv.setAdapter(mAdapter);
    }
}
