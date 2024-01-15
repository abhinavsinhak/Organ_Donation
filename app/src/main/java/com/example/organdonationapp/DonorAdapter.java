package com.example.organdonationapp;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
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

        holder.buttonExpandCollapse.setOnClickListener(v -> {
            if (holder.layoutExpandCollapse.getVisibility() == View.GONE) {
                holder.layoutExpandCollapse.setVisibility(View.VISIBLE);
            } else {
                holder.layoutExpandCollapse.setVisibility(View.GONE);
            }
        });

        holder.buttonCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + contact.mobile)); // Replace with the actual mobile number
            v.getContext().startActivity(intent);
        });
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
        public Button buttonExpandCollapse;
        public LinearLayout layoutExpandCollapse;
        public Button buttonCall;
        public DonorViewHolder(View view) {
            super(view);
            nameTextView = view.findViewById(R.id.nameTextView);
            organTextView = view.findViewById(R.id.organTextView);
            genderTextView = view.findViewById(R.id.genderTextView);
            mobileTextView = view.findViewById(R.id.mobileTextView);
            buttonExpandCollapse = view.findViewById(R.id.buttonExpandCollapse);
            layoutExpandCollapse = view.findViewById(R.id.layoutExpandCollapse);
            buttonCall = view.findViewById(R.id.buttonCall);
            // Initialize other fields as needed
        }
    }
}