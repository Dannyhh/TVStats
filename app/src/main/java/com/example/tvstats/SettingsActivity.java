package com.example.tvstats;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class SettingsActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }
    //TODO: Add the layout and any functions for this class

    public void resetData(View v){
        MainActivity.dbh.dropTable();
    }
}