package com.techzonecs.tremble.controller;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.techzonecs.tremble.R;
import com.techzonecs.tremble.model.Session;
import com.techzonecs.tremble.utilities.SessionConnection;

import java.net.URI;
import java.util.ArrayList;

public class SessionListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        populateSessionList();

    }

    private void populateSessionList() {
        // Construct the data source
        ArrayList<Session> arrayOfSessions;
        SessionConnection sessionConnect = new SessionConnection();
        arrayOfSessions = sessionConnect.getSessionArray();

        Log.d("testing" , arrayOfSessions.toString());

        // Create the adapter to convert the array to views
        //CustomUsersAdapter adapter = new CustomUsersAdapter(this, arrayOfUsers);
        // Attach the adapter to a ListView
        //ListView listView = (ListView) findViewById(R.id.lvUsers);
        //listView.setAdapter(adapter);
    }

}


