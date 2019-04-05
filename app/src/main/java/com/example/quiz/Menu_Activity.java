package com.example.quiz;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class Menu_Activity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private  BottomNavigationView btn_nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_);

        btn_nav = findViewById(R.id.btn_nav);
        btn_nav.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment selectedFragment){
        if (selectedFragment!= null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_container,selectedFragment)
                    .commit();
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.home:
                loadFragment(new home());
                break;
            case R.id.profile:
                loadFragment(new profile());
                break;
        }
        return true;
    }
}
