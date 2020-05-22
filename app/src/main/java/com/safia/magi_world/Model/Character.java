package com.safia.magi_world.Model;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class Character implements Parcelable {

    protected String num;
    protected String scream;
    protected String classe;



    protected int level, life, strength, agility, intelligence;
    public String playersName;
    protected Character opponent;
    public void setOpponent(Character opponent) { this.opponent = opponent; }

    //Constructeur avec paramètre
    public Character(int level, int strength, int agility, int intelligence, String playersName) {
        this.playersName = playersName;
        this.level = level;
        this.life = level*5;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract String introduction();

    protected void removeLife(int lifeToRemove) {
        life -= lifeToRemove;
    }

    protected Character(Parcel in) {
        this.playersName= in.readString();
        this.level = in.readInt();
        this.life = in.readInt();
        this.strength = in.readInt();
        this.agility = in.readInt();
        this.intelligence = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(playersName);
        dest.writeInt(level);
        dest.writeInt(life);
        dest.writeInt(strength);
        dest.writeInt(agility);
        dest.writeInt(intelligence);
    }

    public abstract String getName();

    public int getLife() {
        return life;
    }

    public abstract void basicAttack(Character opponent);

    public abstract String basicAttackString(Character opponent);

    public abstract void specialAttack(Character opponent);

    public abstract String specialAttackString(Character opponent);
}

