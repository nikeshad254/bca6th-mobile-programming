package com.example.recyclerviewexample;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        List<Contact> contacts = new ArrayList<Contact>();
        contacts.add(new Contact("Alice Smith", "alice.smith@mail.com", R.drawable.a));
        contacts.add(new Contact("Bob Johnson", "bob.johnson@mail.com", R.drawable.b));
        contacts.add(new Contact("Catherine Green", "catherine.green@mail.com", R.drawable.c));
        contacts.add(new Contact("David Brown", "david.brown@mail.com", R.drawable.d));
        contacts.add(new Contact("Eva White", "eva.white@mail.com", R.drawable.e));
        contacts.add(new Contact("Frank Black", "frank.black@mail.com", R.drawable.f));
        contacts.add(new Contact("Grace Blue", "grace.blue@mail.com", R.drawable.g));
        contacts.add(new Contact("Henry Yellow", "henry.yellow@mail.com", R.drawable.h));

        contacts.add(new Contact("Isabelle Red", "isabelle.red@mail.com", R.drawable.a));
        contacts.add(new Contact("Jack Grey", "jack.grey@mail.com", R.drawable.b));
        contacts.add(new Contact("Katherine Pink", "katherine.pink@mail.com", R.drawable.c));
        contacts.add(new Contact("Leon Brown", "leon.brown@mail.com", R.drawable.d));
        contacts.add(new Contact("Megan Orange", "megan.orange@mail.com", R.drawable.e));
        contacts.add(new Contact("Nathan Purple", "nathan.purple@mail.com", R.drawable.f));
        contacts.add(new Contact("Olivia Green", "olivia.green@mail.com", R.drawable.g));
        contacts.add(new Contact("Paul White", "paul.white@mail.com", R.drawable.h));


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ContactViewAdapter(MainActivity.this, contacts));

    }
}
