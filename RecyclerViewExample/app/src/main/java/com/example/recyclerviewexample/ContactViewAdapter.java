package com.example.recyclerviewexample;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactViewAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    Activity context;
    List<Contact> contacts;

    public ContactViewAdapter(Activity context, List<Contact> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContactViewHolder(LayoutInflater.from(context).inflate(R.layout.contact_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.nameTxt.setText(contacts.get(position).name);
        holder.emailTxt.setText(contacts.get(position).email);
        holder.img.setImageResource(contacts.get(position).img);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
