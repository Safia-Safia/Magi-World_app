package com.safia.magi_world.Model;


import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Toast;

import com.safia.magi_world.Controller.GameActivity;

public class Mage extends Character {


    public Mage(int level, int strength, int agility, int intelligence, String playersName) {
        super(level, strength, agility, intelligence, playersName);
        classe = "Mage";
        scream = "Abracadabraaaa ! ";
    }


    //Variable Viemax évite d'aller au dessus du niveau de vie initialement choisit
    int lifeMax = life;

    public Mage(Parcel in) {
        super(in);
    }

    @Override
    public String getName() {
        return playersName;
    }

    public static final Parcelable.Creator<Character> CREATOR = new Parcelable.Creator<Character>(){
        @Override
        public Mage createFromParcel(Parcel source) {
            return new Mage(source);
        }

        @Override
        public Mage[] newArray(int size) {
            return new Mage[0];
        }
    };

    @Override
    public void basicAttack(Character opponent) {
        //num + " utilise Boule de feu et inflige " + intelligence + " de dégâts !";
        //System.out.println("\n" + opponent.num + " perd " + intelligence + " point de vie.");
        opponent.removeLife(intelligence);
         }
    @Override
    public String basicAttackString(Character opponent) {
        return (  getName()+" utilise Boule de Feu et inflige " + intelligence + " dommage(s)!");
    }
    @Override
    public void specialAttack(Character opponent) {
        if ((intelligence * 2) + life > lifeMax) {
           // Toast.makeText(this, "Vous ne pouvez pas avoir plus de vie qu'initialement", Toast.LENGTH_SHORT).show();
        } else {
            life += (intelligence * 2);
        }    }
    @Override
    public String specialAttackString(Character opponent) {
        return getName()+" utilise Soin et regagne " + (intelligence * 2) + " de vitalité !\n";
    }

    @Override
    public String introduction() {
        return "Abracadabraa ! Je suis le Mage , de  niveau "+ level + " , je possède "+ life + " de vitalité, "+ strength+
                " de force, "+ agility+ " d'agilité et "+ intelligence+ " d'intelligence !\n";
    }

}