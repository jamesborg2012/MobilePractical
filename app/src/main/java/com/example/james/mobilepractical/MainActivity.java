package com.example.james.mobilepractical;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.sql.SQLException;


public class MainActivity extends AppCompatActivity
{
    String [] menuItems;
    ArrayAdapter<String> adapter;
    String dbName = "NewsFeed";
    String Table_Name = "NewsList";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //SQLiteDatabase checkData = openOrCreateDatabase(dbName, MODE_PRIVATE, null);
        //this.deleteDatabase("NewsFeed");
        checkDb();


        menuItems= getResources().getStringArray(R.array.menuItem);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, menuItems);

        ListView list = (ListView) findViewById(R.id.lView);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position)
                {
                    case 0:
                        Intent newActivity = new Intent(MainActivity.this, PostActivity.class);
                        startActivity(newActivity);
                        break;

                    case 1:
                        Intent newsActivity = new Intent(MainActivity.this, NewsActivity.class);
                        startActivity(newsActivity);
                        break;
                }
            }
        });
    }

    public boolean checkDb()
    {
        SQLiteDatabase checkData = null;
        String path = Environment.getDataDirectory() +
                      "/data/com.example.james.mobilepractical/databases/" + dbName;
        try {
            checkData = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
            checkData.execSQL("Create Table if not exists " + Table_Name + "(ID INTEGER PRIMARY KEY," +
                              " Title TEXT NOT NULL, Description TEXT NOT NULL, Image TEXT NOT NULL," +
                              " Section TEXT NOT NULL);");
            //checkData.execSQL("Drop table if exists " + Table_Name);
            checkData.close();
        }
        catch (SQLiteException e)
        {
            checkData = openOrCreateDatabase("dbName", MODE_PRIVATE, null);
            e.getMessage();
        }
        return checkData != null;


    }







}
