package com.example.menuexamples;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        registerForContextMenu(button);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            // Handle settings action
            Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.context_menu,
                menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.context_menu_item1)
        {
            // Handle context menu item 1
            Toast.makeText(this, "Context Menu Item 1 clicked", Toast.LENGTH_SHORT).show();
            return true;
        }else if (id == R.id.context_menu_item2) {
            // Handle context menu item 2
            Toast.makeText(this, "Context Menu Item 2 clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onContextItemSelected(item);
    }

    public void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.popup_menu_item1) {
                    // Handle popup menu item 1
                    Toast.makeText(MainActivity.this, "Popup Menu Item 1 clicked", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (id == R.id.popup_menu_item2) {
                    // Handle popup menu item 2
                    Toast.makeText(MainActivity.this, "Popup Menu Item 2 clicked", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });
        popupMenu.show();
    }
}
