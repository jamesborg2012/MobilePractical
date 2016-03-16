package com.example.james.mobilepractical;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
{
    String [] menuItems;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menuItems= getResources().getStringArray(R.array.menuItem);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, menuItems);

        ListView list = (ListView) findViewById(R.id.lView);

        list.setAdapter(adapter);
    }





}
