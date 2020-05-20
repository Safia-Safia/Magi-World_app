package com.safia.magi_world.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Rodeur extends Character implements Parcelable {

    public Rodeur(int numJoueur, int strength, int agility, int intelligence) {
        super(numJoueur,strength, agility, intelligence);
        classe="Rodeur";
        scream = "Psst...! ";
    }


    public Rodeur(Parcel in) {
        super(in);
    }

    public static final Parcelable.Creator<Character> CREATOR = new Parcelable.Creator<Character>(){
        @Override
        public Rodeur createFromParcel(Parcel source) {
            return new Rodeur(source);
        }

        @Override
        public Rodeur[] newArray(int size) {
            return new Rodeur[0];
        }
    };



    @Override
    public void basicAttack(Character opponent) {
        opponent.removeLife(agility);

    }

    @Override
    public String basicAttackString(Character opponent) {
        return  " utilise Tire à l'Arc et inflige " + agility + " de dégâts !";
    }

    @Override
    public void specialAttack(Character opponent) {
        agility+=(level/2);
    }

    @Override
    public String specialAttackString(Character opponent) {
        return num + " utilise concentration et gagne "+ (agility / 2) + " en agilité !\n";
    }


    @Override
    public String introduction() {
        return "Pst" + "Je suis le Rodeur de niveau "+ level + " , je possède " +life+" de vitalité, "+ strength+
                " de force, "+ agility+ " d'agilité et "+ intelligence+ " d'intelligence !\n";
    }

}