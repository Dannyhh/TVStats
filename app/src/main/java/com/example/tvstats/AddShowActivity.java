package com.example.tvstats;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddShowActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_show);
    }
    //TODO: Add the layout and any functions for this class
    public void addShow(View view) {
        //get the name from name field
        EditText nameEdit = findViewById(R.id.NameText);
        String title = nameEdit.getText().toString();

        //get the total episodes from total field
        EditText totalEp = findViewById(R.id.TotalEpisodes);
        int total = Integer.parseInt(totalEp.getText().toString());

        //get the watched count from watched field
        EditText watchedEp = findViewById(R.id.CurrentEpisodes);
        int watched = Integer.parseInt(nameEdit.getText().toString());

        //get the rating from rating field
        EditText ratingField = findViewById(R.id.Rating);
        int rating = Integer.parseInt(ratingField.getText().toString());

        //get the date from date field
        EditText dateField = findViewById(R.id.DateCompleted);
        String date = dateField.getText().toString();


        MainActivity.dbh.addShow(title, total, watched, rating, date);
        gotoMain(view);
    }
    public void gotoMain(View view) {
        Intent myIntent = new Intent(view.getContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
    }
}
