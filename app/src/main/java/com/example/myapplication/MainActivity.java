package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Integer Cout;
    SQLiteDatabase db;
    DB databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new DB(getApplicationContext());
        db = databaseHelper.getReadableDatabase();
        Cursor coutCursor =  db.rawQuery("select * from "+ DB.TABLE, null);
        Cout = coutCursor.getCount();
        if(Cout == 2) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Привет ты запустил меня 3 раза)!", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("number", Cout);
            db.insert("Task", null, contentValues);
        }

    }
    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();

    }
}