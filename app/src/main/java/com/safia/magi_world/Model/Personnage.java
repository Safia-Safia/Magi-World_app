package com.safia.magi_world.Model;

public abstract class Personnage {

    protected String num,scream,classe;
    protected int level, life, strength, agility, intelligence;
    protected Personnage opponent;

    //Constructeur avec paramètre
    public Personnage(int numJoueur, int strength, int agility, int intelligence) {
        num = "Joueur " + numJoueur;
        level = strength + agility + intelligence;
        life = level * 5;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public void setOpponent(Personnage opponent) { this.opponent = opponent; }
    public Personnage getOpponent() { return opponent; }

    protected abstract void sort (int choix);
    //Methode permettant de choisir le mode d'attaque pour le joueur actif en appellant la methode abstraite 'sort'
  /*  public void playingChara() {
        int choix = 0;
        if (life >= 0) {
            do {
                choix = Main.askQuestion(num + " ( " + life + " de vitalité.) Veuillez choisir votre action " +
                        "(1 : Attaque Basique   2 : Attaque Speciale)");
            }while (choix != 1 && choix != 2);
            this.sort(choix);
        }
    }*/


    //Methode qui retire la vie
    protected void removeLife(int lifeToRemove) { life-=lifeToRemove; }

    //Methode présentation du joueur
    @Override
    public String toString() {
        return  scream + "Je suis le "+ classe+" "+num +", de  niveau "+ level + " , je possède "+ life + " de vitalité, "+ strength+
                " de force, "+ agility+ " d'agilité et "+ intelligence+ " d'intelligence !\n";
    }
}
