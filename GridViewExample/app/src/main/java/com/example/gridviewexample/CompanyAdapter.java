package com.example.gridviewexample;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CompanyAdapter extends ArrayAdapter<Company> {
    private Activity context;
    private final List<Company> companies;


    public CompanyAdapter(@NonNull Activity context, List<Company> companies) {
        super(context, R.layout.company, companies);
        this.context = context;
        this.companies = companies;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater= context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.company, null,false);

        TextView title = (TextView) rowView.findViewById(R.id.text1);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img1);

        title.setText(companies.get(position).name);
        imageView.setImageResource(companies.get(position).imgId);

        return rowView;
    }
}
