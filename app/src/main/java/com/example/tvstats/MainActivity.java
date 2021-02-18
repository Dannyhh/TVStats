package com.example.tvstats;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // List of background images
    ArrayList<Integer> backgroundImages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        backgroundImages.add(R.drawable.basic);
    }

    public void gotoAdd(View view) {
    }
    public void gotoMyShows(View view) {
    }
    public void gotoStats(View view) {
    }
    public void gotoSettings(View view) {
    }
}