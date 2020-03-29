package com.jedmay.c196finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import Database.WGUTermRoomDatabase;
import Model.Term;

public class Terms extends AppCompatActivity {

    WGUTermRoomDatabase db;
    ListView lvw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Terms");
        lvw = findViewById(R.id.termListView);
        View rootView = lvw.getRootView();

        db = WGUTermRoomDatabase.getDatabase(getApplicationContext());

        lvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), Term.class);
                int termId;
                //List<Term> termList = db.termDao().getAllTerms();
            }
        });

        FloatingActionButton fab = findViewById(R.id.addTermFab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
