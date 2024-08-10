package com.example.recyclerviewexample;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    ImageView img;
    TextView nameTxt, emailTxt;

    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        img = itemView.findViewById(R.id.img);
        nameTxt = itemView.findViewById(R.id.nameTxt);
        emailTxt = itemView.findViewById(R.id.emailTxt);
    }
}
