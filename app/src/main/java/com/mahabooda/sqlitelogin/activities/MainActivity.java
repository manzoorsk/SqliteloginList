package com.mahabooda.sqlitelogin.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.mahabooda.sqlitelogin.network.DatabaseHelper;
import com.mahabooda.sqlitelogin.R;
import com.mahabooda.sqlitelogin.adapters.UsersRecyclerAdapter;
import com.mahabooda.sqlitelogin.models.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private AppCompatActivity activity = MainActivity.this;
    private AppCompatTextView textViewName;
    private RecyclerView recyclerViewUsers;
    private ArrayList<User> listUsers;
    private UsersRecyclerAdapter usersRecyclerAdapter;
    private DatabaseHelper databaseHelper;
    private ListView listView;
    private String emailFromIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Users Activity");
        initViews();
        initObjects();
    }
    private void initViews() {
        textViewName = (AppCompatTextView) findViewById(R.id.user_name);
//        recyclerViewUsers = (RecyclerView) findViewById(R.id.recyclerViewUsers);
        listView =(ListView) findViewById(R.id.list);
    }
    private void initObjects() {
        listUsers = new ArrayList<>();
        usersRecyclerAdapter = new UsersRecyclerAdapter(getApplicationContext(),listUsers);

//        RecyclerView

//        usersRecyclerAdapter = new UsersRecyclerAdapter(listUsers);
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerViewUsers.setLayoutManager(mLayoutManager);
//        recyclerViewUsers.setItemAnimator(new DefaultItemAnimator());
//        recyclerViewUsers.setHasFixedSize(true);
//        recyclerViewUsers.setAdapter(usersRecyclerAdapter);
//        databaseHelper = new DatabaseHelper(activity);
//        ListView
        listView.setAdapter(usersRecyclerAdapter);
        databaseHelper = new DatabaseHelper(activity);
        emailFromIntent = getIntent().getStringExtra("USERNAME");
        textViewName.setText(emailFromIntent);

        getDataFromSQLite();
    }

    private void getDataFromSQLite() {
        // AsyncTask is used that SQLite operation not blocks the UI Thread.
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                listUsers.clear();
                listUsers.addAll(databaseHelper.getAllUser());

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                usersRecyclerAdapter.notifyDataSetChanged();
            }
        }.execute();
    }

}
