package com.safia.magi_world.Model;

public class Guerrier extends Character {


    public Guerrier(int niveau, int force, int agilite, int intelligence) {
        super(niveau, force, agilite, intelligence);
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

    @Override
    public String introduction() {
        return scream + "Je suis le "+ classe+" "+num +", de  niveau "+ level + " , je possède "+ life + " de vitalité, "+ strength+
                " de force, "+ agility+ " d'agilité et "+ intelligence+ " d'intelligence !\n";
    }

}