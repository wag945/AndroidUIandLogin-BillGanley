package com.example.bill.androiduiandlogin_billganley;

import android.support.v7.widget.RecyclerView;
import java.util.List;
import java.util.ArrayList;
import android.view.LayoutInflater;
import android.content.Context;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private ArrayList<UserProfile> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    MyRecyclerViewAdapter(Context context, ArrayList<UserProfile> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserProfile up = mData.get(position);
        holder.mFirstNameTextView.setText("Name:" + up.getFirstname());
        holder.mLastNameTextView.setText(up.getSurname());
        holder.mUsernameTextView.setText("Username: " + up.getUsername());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mFirstNameTextView;
        TextView mLastNameTextView;
        TextView mUsernameTextView;

        ViewHolder(View itemView) {
            super(itemView);
            mFirstNameTextView = itemView.findViewById(R.id.textviewFirstname);
            mLastNameTextView = itemView.findViewById(R.id.textviewLastname);
            mUsernameTextView = itemView.findViewById(R.id.textviewUser);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    UserProfile getItem(int id) {
        //return mData.get(id);
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}