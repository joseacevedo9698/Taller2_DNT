package com.example.taller2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;


import java.util.ArrayList;

public class SecundaryActivity extends AppCompatActivity {

    private ListView listView;
    Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundary);

        listView = (ListView) findViewById(R.id.listView);


        final ArrayList<Equipo> listado =  getIntent().getParcelableArrayListExtra("lista");
        adapter = new Adapter(SecundaryActivity.this,R.layout.item_row,listado);
        listView.setAdapter(adapter);





    }




}
