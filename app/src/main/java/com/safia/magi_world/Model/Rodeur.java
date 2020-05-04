package com.safia.magi_world.Model;

public class Rodeur extends Character {

    public Rodeur(int numJoueur, int strength, int agility, int intelligence) {
        super(numJoueur,strength, agility, intelligence);
        classe="Rodeur";
        scream = "Psst...! ";
    }
    //Methode d'attaque du Rodeur
    @Override
    protected void sort(int choix) {
        String narrateur="";
        switch (choix){
            case 1:
                opponent.removeLife(agility);
                narrateur= num + " utilise Tire à l'Arc et inflige " + agility + " de dégâts !";
                System.out.print(narrateur);
                System.out.println("\n"+ opponent.num + " perd "+ agility + " point de vie.");
                break;
            case 2:
                agility+=(level/2);
                narrateur =  num + " utilise concentration et gagne "+ (agility / 2) + " en agilité !\n";
                System.out.print(narrateur);
                break;
        }
    }

    @Override
    public String introduction() {
        return "Pst" + "Je suis le Mage de niveau "+ level + " , je possède 3 de vitalité, "+ strength+
                " de force, "+ agility+ " d'agilité et "+ intelligence+ " d'intelligence !\n";
    }
}