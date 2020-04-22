package com.safia.magi_world.View;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.safia.magi_world.Model.RulesList;
import com.safia.magi_world.R;

import java.util.ArrayList;


public class RulesAdapter extends RecyclerView.Adapter<RulesAdapter.MyViewHolder> {

    private ArrayList<RulesList> mRulesLists;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView1;
        public TextView mTextView2;

        public MyViewHolder(final View itemView) {
            super(itemView);
            mTextView1 = itemView.findViewById(R.id.activity_titre_regle);
            mTextView2 = itemView.findViewById(R.id.activity_text_regle);
        }
    }

    public RulesAdapter(ArrayList<RulesList> exampleList) {
        mRulesLists = exampleList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.regles_adapter, parent, false);
        MyViewHolder evh = new MyViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        RulesList currentItem = mRulesLists.get(position);

        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
    }

    @Override
    public int getItemCount() {
        return mRulesLists.size();
    }
}