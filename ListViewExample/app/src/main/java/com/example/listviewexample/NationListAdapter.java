package com.example.listviewexample;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class NationListAdapter extends ArrayAdapter<Nation> {
    private Activity context;
    private final List<Nation> nations;


    public NationListAdapter(@NonNull Activity context, List<Nation> nations) {
        super(context, R.layout.listitem, nations);
        this.nations = nations;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater= context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listitem, null,false);

        TextView title = (TextView) rowView.findViewById(R.id.text1);
        TextView code = (TextView) rowView.findViewById(R.id.text2);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

        title.setText(nations.get(position).name);
        code.setText(nations.get(position).code);
        imageView.setImageResource(nations.get(position).flag);

        return rowView;

    }
}
