package com.safia.magi_world.Model;

import com.safia.magi_world.Controller.MainActivity;

public class Guerrier extends Personnage {


    public Guerrier(int numJoueur, int force, int agilite, int intelligence) {
        super(numJoueur, force, agilite, intelligence);
        classe="Guerrier";
        scream = "Woarg ! ";
    }
    //Methode d'attaque du Guerrier
    @Override
    protected void sort(int choix) {
        String narrateur = "";
        switch (choix){
            case 1:
                opponent.removeLife(strength);
                narrateur= num + " utilise Coup d'épée et inflige " + strength + " de dégâts !";
                System.out.print(narrateur);
                System.out.println("\n"+ opponent.num + " perd "+ strength + " point de vie.");
                break;
            case 2:
                opponent.removeLife(strength * 2);
                life -= (strength / 2);
                narrateur =  num + " utilise Coup de rage, inflige " + (strength * 2) + " de dégâts et perd "+ (strength/2)+ " points de vie !";
                System.out.print(narrateur);
                System.out.println("\n"+ opponent.num + " perd "+ (strength*2) + " point de vie.");
                break;
        }

    }

}