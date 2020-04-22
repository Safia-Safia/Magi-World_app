package com.safia.magi_world.View;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.safia.magi_world.R;
import com.safia.magi_world.Model.RolesList;

import java.util.ArrayList;


public class DifferentRolesListAdapter extends RecyclerView.Adapter<DifferentRolesListAdapter.MyViewHolder> {

    private ArrayList<RolesList> mRolesList;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;

        public MyViewHolder(final View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.classe);
            mTextView2 = itemView.findViewById(R.id.description);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        new AlertDialog.Builder(itemView.getContext())
                                .setTitle(mTextView1.getText())
                                .setMessage(mTextView2.getText())
                                .show();
                    }
            });
        }
    }

    public DifferentRolesListAdapter(ArrayList<RolesList> exampleList) {
        mRolesList = exampleList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.roles_adapter, parent, false);
        MyViewHolder evh = new MyViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        RolesList currentItem = mRolesList.get(position);

        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
    }

    @Override
    public int getItemCount() {
        return mRolesList.size();
    }
}