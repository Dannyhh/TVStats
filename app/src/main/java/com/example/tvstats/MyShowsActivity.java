package com.example.tvstats;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class MyShowsActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_shows);
        buildButtons("");
    }
    //TODO: Add the layout and any functions for this class

    public void buildButtons(String search){
        Cursor c;
        if(search.equals("")) {
             c = MainActivity.dbh.search("");
        }
        else{
            c = MainActivity.dbh.search(search);
        }
        //int, string, int, int, int, string, string
        while(c.moveToNext()){
            Button temp = new Button(this);
            temp.setText(c.getString(1));


            LinearLayout ll = (LinearLayout)findViewById(R.id.button_ll);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    200);
            ll.addView(temp, lp);
        }
    }
}