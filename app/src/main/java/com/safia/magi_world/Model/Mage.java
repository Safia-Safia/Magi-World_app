package com.safia.magi_world.Model;


public class Mage extends Character {


    public Mage(int numJoueur, int strength, int agility, int intelligence) {
        super(numJoueur, strength, agility, intelligence);
        classe = "Mage";
        scream = "Abracadabraaaa ! ";
    }

    //Variable Viemax évite d'aller au dessus du niveau de vie initialement choisit
    int lifeMax = life;
//Methode sort pour le mage

    @Override
    protected void sort(int choix) {
        String narrateur = "";
        switch (choix) {
            case 1:
                narrateur = num + " utilise Boule de feu et inflige " + intelligence + " de dégâts !";
                System.out.print(narrateur);
                System.out.println("\n" + opponent.num + " perd " + intelligence + " point de vie.");
                opponent.removeLife(intelligence);
                break;
            case 2: //Soin
                if ((intelligence * 2) + life > lifeMax) {
                    System.out.println("Vous ne pouvez pas avoir plus de vie qu'initialement ! Passez votre tour !");
                } else {
                    life += (intelligence * 2);
                    narrateur = num + " utilise Soin et regagne " + (intelligence * 2) + " de vitalité !\n";
                    System.out.print(narrateur);
                }
                break;

        }
    }

    @Override
    public String introduction() {
        return scream + "Je suis le "+ classe+" "+num +", de  niveau "+ level + " , je possède "+ life + " de vitalité, "+ strength+
                " de force, "+ agility+ " d'agilité et "+ intelligence+ " d'intelligence !\n";
    }
}