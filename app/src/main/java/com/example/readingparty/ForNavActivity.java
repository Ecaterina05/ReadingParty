package com.example.readingparty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ForNavActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.for_nav_activity);

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_nav);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HelloFragment()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment=null;
                switch (item.getItemId())
                {
                    case R.id.home:
                        selectedFragment= new FirstFragment();
                        break;
                    case R.id.logOutMenu:

                        selectedFragment=new HelloFragment();
                        break;
                    case R.id.favorites:
                        selectedFragment=new FavoritesFragment();
                    case R.id.categories:
                        selectedFragment=new CategoriesFragment();

                    case R.id.categories:
                        selectedFragment=new CategoriesFragment();

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();

                return true;

            }
        });


    }

    @Override
    public void onBackPressed() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FirstFragment()).commit();
    }
}