package com.example.mynewsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.mynewsapp.Fragment.Business;
import com.example.mynewsapp.Fragment.Entertainment;
import com.example.mynewsapp.Fragment.Main;
import com.example.mynewsapp.Fragment.Sport;
import com.example.mynewsapp.models.Article;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String API_KEY = "a7005718783643a99d8d61f79325aa58";
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Article> articles = new ArrayList<>();
    private Adapter adapter;
    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ft = getSupportFragmentManager().beginTransaction();
        currentFragment = new Main();
        ft.replace(R.id.constraint_layout, currentFragment);
        ft.commit();


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    Fragment currentFragment = null;
    FragmentTransaction ft;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    currentFragment = new Main();
                    ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.constraint_layout, currentFragment);
                    ft.commit();
                    return true;
                case R.id.navigation_business:
                    currentFragment = new Business();
                    ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.constraint_layout, currentFragment);
                    ft.commit();
                    return true;
                case R.id.navigation_entertainment:
                    currentFragment = new Entertainment();
                    ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.constraint_layout, currentFragment);
                    ft.commit();
                    return true;
                case R.id.navigation_sport:
                    currentFragment = new Sport();
                    ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.constraint_layout, currentFragment);
                    ft.commit();
                    return true;
            }
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.constraint_layout, selectedFragment);
            transaction.commit();
            return true;
        }

    };

}
