package com.example.workingwithapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Receiver extends Activity {

    String url = "https://jsonplaceholder.typicode.com/posts";  // Ensure this is correct and accessible
    Button addNew;
    ListView listView;
    RequestQueue requestQueue;
    ArrayList<String> todoTitles;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reciever);

        addNew = findViewById(R.id.newBtn);
        listView = findViewById(R.id.listView);  // Ensure this ID matches your layout
        ArrayList<String> titleArrayList = new ArrayList<>();

        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);

                    for(int i=0; i<jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String title = jsonObject.getString("title");
                        titleArrayList.add(title);
                    }

                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Receiver.this, android.R.layout.simple_expandable_list_item_1, titleArrayList);
                    listView.setAdapter(arrayAdapter);

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Receiver.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);


        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Receiver.this, Sender.class);
                startActivity(intent);
            }
        });
    }
}
