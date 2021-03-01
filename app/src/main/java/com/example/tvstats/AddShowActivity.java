package com.example.tvstats;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddShowActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_show);
    }


    public void addShow(View view) {
        //get the name from name field
        EditText nameEdit = findViewById(R.id.NameText);
        String title = nameEdit.getText().toString();

        //if there is no title throw an error and return
        if(title.length() == 0){
            exceptionToast(view.getContext(),
                    "Must input a title for your show");
            return;
        }

        //get the status of the show
        Spinner statusField = findViewById(R.id.status_spinner);
        String status = statusField.getSelectedItem().toString();
        String date = "";
        if(status.equals("Completed")) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy");
            date = sdf.format(new Date());
        }

        try {
            //get the total episodes from total field
            EditText totalEp = findViewById(R.id.TotalEpisodes);
            int total = Integer.parseInt(totalEp.getText().toString());
            if(total < 0){
                exceptionToast(view.getContext(),
                        "Must have a positive number of total episodes");
                return;
            }

            //get the watched count from watched field
            EditText watchedEp = findViewById(R.id.CurrentEpisodes);
            int watched = Integer.parseInt(watchedEp.getText().toString());
            if(watched > total){
                exceptionToast(view.getContext(),
                        "Watched episodes must be less than total episodes");
                return;
            }
            else if(watched < 0){
                exceptionToast(view.getContext(),
                        "Must have a positive number of watched episodes");
                return;
            }

            //get the rating from rating field
            Spinner ratingField = findViewById(R.id.rating_spinner);
            int rating = Integer.parseInt(ratingField.getSelectedItem().toString());

            MainActivity.dbh.addShow(title, total, watched, rating, status, date);
            gotoMain();
        }
        catch (Exception e){
            exceptionToast(view.getContext(),
                    "Must input a number for total or watched episodes");
        }

    }
    public void gotoMain(){
        Intent intent = new Intent(AddShowActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public static void exceptionToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
