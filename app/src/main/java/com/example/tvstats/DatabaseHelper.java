package com.example.tvstats;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    //name of our database of shows
    private static final String TABLE_NAME = "my_shows";

    //names of the columns for our SQLITE database
    private static final String C0 = "ID";
    private static final String C1 = "title";
    private static final String C2 = "total_episodes";
    private static final String C3 = "watched_episodes";
    private static final String C4 = "rating";
    private static final String C5 = "status";
    private static final String C6 = "date_completed";


    public DatabaseHelper(Context context) {
        super(context,TABLE_NAME, null, 1);
    }

    //method to create our database rows
    @Override
    public void onCreate(SQLiteDatabase db) {
        //build the table for our shows, we don't allow for any nulls
        //rating must be 0<=rating<=10
        String createTable = "CREATE TABLE " + TABLE_NAME +
                "( " + C0 +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                C1 + " TEXT NOT NULL, " +
                C2 + " INTEGER NOT NULL, " +
                C3 + " INTEGER NOT NULL, " +
                C4 + " INTEGER CHECK("+C4+" >=0  AND "+C4+" <= 10) NOT NULL, " +
                C5 + " TEXT NOT NULL, " +
                C6 + " TEXT)";
        db.execSQL(createTable);
    }

    //create the database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    //function to add the shows, called by other classes/functions to insert data
    //TODO: determine if date completed should be automatically added if status is set to complete
    public boolean addShow(String title, int totalEp, int watchedEP, int rating, String status, String date){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(C1, title);
        values.put(C2, totalEp);
        values.put(C3, watchedEP);
        values.put(C4, rating);
        values.put(C5, status);
        values.put(C6, date);
        long result = db.insert(TABLE_NAME, null, values);
        getAll();
        return result != -1;
    }
    
    public void getAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString =
                "SELECT * FROM " + TABLE_NAME;
        Cursor c = db.rawQuery(queryString, null);
    }
    public boolean editShow(String whatToEdit, String newVal){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        //TODO: Create case statements to change updated fields
        if(whatToEdit.equals("title")){
            values.put(C1, newVal);
        }

        //TODO: insert query goes here
        boolean result = false;
        return result;
    }
}
