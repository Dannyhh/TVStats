package com.example.tvstats;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AddShowActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_show);
    }
    //TODO: Add the layout and any functions for this class
    public void addShow(View view) {
        gotoMain(view);
    }
    public void gotoMain(View view) {
        Intent myIntent = new Intent(view.getContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
    }
}
