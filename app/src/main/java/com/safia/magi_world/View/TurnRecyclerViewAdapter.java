package com.safia.magi_world.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.safia.magi_world.R;

import java.util.List;

public class TurnRecyclerViewAdapter extends RecyclerView.Adapter <TurnRecyclerViewAdapter.MyViewHolder>  {

    private List<String> mNumberOfTurn;
    private List<String> mAttackList;

    public TurnRecyclerViewAdapter(List<String> numberOfTurn, List<String> attackList) {
        this.mNumberOfTurn = numberOfTurn;
        this.mAttackList = attackList;
        }

    @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            View v = inflater.inflate(R.layout.history, parent, false);
            return new MyViewHolder(v);
        }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.display(mNumberOfTurn.get(position),mAttackList.get(position));

    }

    @Override
        public int getItemCount() {
            return mNumberOfTurn.size();
        }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView numberOfTurn;
        TextView attackDamages;

        public MyViewHolder (View itemView){
            super(itemView);
            numberOfTurn = itemView.findViewById(R.id.number_of_turn);
            attackDamages = itemView.findViewById(R.id.attack_history);
        }
        public void display (String numberOfTurn, String attackDamages){
            this.numberOfTurn.setText(numberOfTurn);
            this.attackDamages.setText(attackDamages);
        }    }
}
