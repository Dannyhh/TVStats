package com.example.tvstats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    /*TODO: add the ability for user to uplaod image for show
     *TODO: Then add these images the the backGround images list
     *TODO: Then cycle these images in the background of MainActivity w/ blur
     */
    ArrayList<Integer> backgroundImages = new ArrayList<>();
    DatabaseHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        backgroundImages.add(R.drawable.basic);
    }

    //go to the view that allows a user to add a show
    public void gotoAdd(View view) {
        Intent myIntent = new Intent(view.getContext(), AddShowActivity.class);
        startActivityForResult(myIntent, 0);
    }
    //go to the view that allows a user to view their added shows
    public void gotoMyShows(View view) {
        Intent myIntent = new Intent(view.getContext(), MyShowsActivity.class);
        startActivityForResult(myIntent, 0);
    }
    //go to the stats page which shows information about what they have watched
    public void gotoStats(View view) {
        Intent myIntent = new Intent(view.getContext(), StatsActivity.class);
        startActivityForResult(myIntent, 0);
    }
    //go to the settings page
    public void gotoSettings(View view) {
        Intent myIntent = new Intent(view.getContext(), SettingsActivity.class);
        startActivityForResult(myIntent, 0);
    }
}