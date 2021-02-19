package com.example.tvstats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // List of background images
    ArrayList<Integer> backgroundImages = new ArrayList<>();
    DatabaseHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        backgroundImages.add(R.drawable.basic);
    }

    public void gotoAdd(View view) {
        Intent myIntent = new Intent(view.getContext(), AddShowActivity.class);
        startActivityForResult(myIntent, 0);
    }
    public void gotoMyShows(View view) {
        Intent myIntent = new Intent(view.getContext(), MyShowsActivity.class);
        startActivityForResult(myIntent, 0);
    }
    public void gotoStats(View view) {
        Intent myIntent = new Intent(view.getContext(), StatsActivity.class);
        startActivityForResult(myIntent, 0);
    }
    public void gotoSettings(View view) {
        Intent myIntent = new Intent(view.getContext(), SettingsActivity.class);
        startActivityForResult(myIntent, 0);
    }
}