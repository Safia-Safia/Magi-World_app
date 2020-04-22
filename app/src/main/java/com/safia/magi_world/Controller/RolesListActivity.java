package com.safia.magi_world.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.safia.magi_world.Model.RolesList;
import com.safia.magi_world.R;
import com.safia.magi_world.View.DifferentRolesListAdapter;

import java.util.ArrayList;

public class RolesListActivity extends AppCompatActivity {

    private RecyclerView.Adapter mAdapter;

    //This class is used to show a list of the different roles in the game.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roles_list);

        ArrayList<RolesList> differentRoles = new ArrayList<>();
        differentRoles.add(new RolesList(R.drawable.ic_guerrier, "Guerrier", "Attaque Basique -Coup d'épée :\nEffectue des dommageségaux à\nla force du joueur sur l’adversaire.\n"+
                "Attaque Spéciale -\n Coup de Rage : Effectue des dommages égaux à la force du joueur fois deux sur l’adversaire. Le joueur lançant l'attaque perd de la vitalité : la valeur de sa force divisée par 2.\n"));
        differentRoles.add(new RolesList(R.drawable.ic_rodeur, "Rodeur", "Attaque Basique -Tir à l’Arc :\nEffectue des dommages égaux à\nl’agilité du joueur sur l’adversaire.\n"+
                "Attaque Spéciale -\n Concentration : Le joueur gagne son niveau divisé par 2 en agilité.\n"));
        differentRoles.add(new RolesList(R.drawable.ic_mage, "Mage", "Attaque Basique -Boule de feu :\nEffectue des dommages égaux à\nl’intelligence du joueur sur l’adversaire.\n"+
                "Attaque Spéciale -\n Soin : Le joueur soigne sa vie et regagne sa quantité d’intelligence fois 2 en points de vie. Attention, il ne peut pas avoir plus de vie qu’il n’en avait au départ.\n"));


        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mAdapter = new DifferentRolesListAdapter(differentRoles);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
    }
}
