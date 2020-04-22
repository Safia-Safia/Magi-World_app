package com.safia.magi_world.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.safia.magi_world.Model.RulesList;
import com.safia.magi_world.R;
import com.safia.magi_world.View.RulesAdapter;

import java.util.ArrayList;

public class ReglesActivity extends AppCompatActivity {
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_list);


       ArrayList<RulesList> rules = new ArrayList<>();
        rules.add(new RulesList("Comment se déroule le jeu", "Le jeu commence par proposer au joueur 1 de choisir entre Guerrier, Rôdeur ou Mage.\n" +
                "Il doit ensuite choisir les characterisitiques du personnage.\n" +
                "C’est ensuite au tour du second joueur de choisir la classe et les caractéristiques de son personnage.\n" +
                "La partie démarre ensuite, le joueur 1 commence.\n" +
                "Chaque joueur joue tour à tour et choisit entre son Attaque Basique ou son Attaque spéciale.\n" +
                "Quand un joueur n’a plus de point de vie, la partie est terminée et l’autre joueur l’emporte."));
        rules.add(new RulesList("Les characteristiques","Chaque personnage possède 5 caractéristiques :\n" +
                "\n" +
                "Niveau : choisi par le joueur (min 1, max 100)\n" +
                "Vie : égale au niveau du joueur * 5\n" +
                "Force : choisie par le joueur (min 0, max 100)\n" +
                "Agilité : choisie par le joueur (min 0, max 100)\n" +
                "Intelligence : choisie par le joueur (min 0, max 100)\n" +
                "Attention le total force + agilité + intelligence doit être égal au niveau du joueur."));
        rules.add(new RulesList("Les sorts", "Chaque joueur possède 2 sorts :\n" +
                "Une attaque basique qui cause des dommages à l’adversaire.\n" +
                "Une attaque spéciale aux effets variés.\n"));

        mAdapter = new RulesAdapter(rules);
        RecyclerView recyclerView = findViewById(R.id.recyclerview2);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
    }
}
