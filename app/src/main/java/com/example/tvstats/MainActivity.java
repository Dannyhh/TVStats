package com.example.tvstats;

import androidx.appcompat.app.AppCompatActivity;

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
        setContentView(R.layout.activity_add_show);
    }
    public void gotoMyShows(View view) {
        setContentView(R.layout.activity_my_shows);
    }
    public void gotoStats(View view) {
        setContentView(R.layout.activity_stats);
    }
    public void gotoSettings(View view) {
        setContentView(R.layout.activity_settings);
    }
}