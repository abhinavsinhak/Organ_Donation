package com.example.organdonationapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class DonorAdapter extends RecyclerView.Adapter<DonorAdapter.DonorViewHolder> {

    private ArrayList<ContactModel> contactList;

    public DonorAdapter(ArrayList<ContactModel> contactList) {
        this.contactList = contactList;
    }

    @Override
    public DonorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.donor_item, parent, false);
        return new DonorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DonorViewHolder holder, int position) {
        ContactModel contact = contactList.get(position);
        holder.nameTextView.setText(contact.name);
        holder.organTextView.setText(contact.organ);
        holder.mobileTextView.setText(contact.mobile);
        holder.genderTextView.setText(contact.gender);
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public static class DonorViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView;
        public TextView organTextView;
        public TextView mobileTextView;
        public TextView genderTextView;
        // Add other fields as needed

        public DonorViewHolder(View view) {
            super(view);
            nameTextView = view.findViewById(R.id.nameTextView);
            organTextView = view.findViewById(R.id.organTextView);
            genderTextView = view.findViewById(R.id.genderTextView);
            mobileTextView = view.findViewById(R.id.mobileTextView);
            // Initialize other fields as needed
        }
    }
}