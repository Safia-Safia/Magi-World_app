package com.safia.magi_world.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.safia.magi_world.Controller.GameActivity;
import com.safia.magi_world.Controller.MainActivity;

public class Guerrier extends Character {


    public Guerrier(int niveau, int force, int agilite, int intelligence, String playersName) {
        super(niveau, force, agilite, intelligence, playersName);
        classe="Guerrier";
        scream = "Woarg ! ";
    }

    @Override
    public String getName() {
        return playersName;
    }

    public Guerrier(Parcel in) {
        super(in);
    }



    public static final Parcelable.Creator<Character> CREATOR = new Parcelable.Creator<Character>(){
        @Override
        public Guerrier createFromParcel(Parcel source) {
            return new Guerrier(source);
        }

        @Override
        public Guerrier[] newArray(int size) {
            return new Guerrier[0];
        }
    };
    //Methode d'attaque du Guerrier

    @Override
    public void basicAttack(Character opponent) {
        opponent.removeLife(strength);
    }

    @Override
    public String basicAttackString(Character opponent) {
        return  getName()+" utilise Coup d'épée et inflige " + strength + " de dégâts !";
    }

    @Override
    public void specialAttack(Character currentOpponent) {
        currentOpponent.removeLife(strength * 2);
        life -= (strength / 2);
        System.out.println("\n"+ currentOpponent.num + " perd "+ (strength*2) + " point de vie.");
    }

    @Override
    public String specialAttackString(Character opponent) {
        return  getName()+ " utilise Coup de rage, inflige " + (strength * 2) + " de dégâts et perd "+ (strength/2)+ " points de vie !";
    }

    @Override
    public String introduction() {
        return scream + "Je suis le "+ classe+" de  niveau "+ level + " , je possède "+ life + " de vitalité, "+ strength+
                " de force, "+ agility+ " d'agilité et "+ intelligence+ " d'intelligence !\n";
    }
}