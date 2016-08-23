package com.example.vi.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NavActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.rc_data) RecyclerView rc_data;
    //@BindView(R.id.tv_nav_username) TextView tv_nav_username;
    TextView tv_nav_username;

    RecyclerviewAdapter recyclerviewAdapter;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(NavActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View v = navigationView.getHeaderView(0);
        //ButterKnife.bind(NavActivity.this,v);

        tv_nav_username = (TextView)v.findViewById(R.id.tv_nav_username);

        init();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_logout) {

            Intent intent = new Intent(NavActivity.this,LoginPageActivity.class);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void init(){

        sharedPreferences = getSharedPreferences(getResources().getString(R.string.prefer_name),Context.MODE_PRIVATE);

        GridLayoutManager gridLayoutVertical = new GridLayoutManager(this,1);
        rc_data.setHasFixedSize(true);
        rc_data.setLayoutManager(gridLayoutVertical);

        recyclerviewAdapter = new RecyclerviewAdapter(this);
        rc_data.setAdapter(recyclerviewAdapter);

        String name = getIntent().getStringExtra(getResources().getString(R.string.tag_name));
        tv_nav_username.setText(name);

    }

    @Override
    protected void onResume() {
        super.onResume();

        String name = sharedPreferences.getString(getResources().getString(R.string.tag_name),null);
        String phone = sharedPreferences.getString(getResources().getString(R.string.tag_phone),null);
        String email = sharedPreferences.getString(getResources().getString(R.string.tag_email),null);

        if(name!=null){
            recyclerviewAdapter.addItem(recyclerviewAdapter.getItemCount(),name,
                    phone, email);
        }
    }

    private void logView(String printText){
        Log.i("LogView",printText);
    }
}
