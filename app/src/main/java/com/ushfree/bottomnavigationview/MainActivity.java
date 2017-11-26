package com.ushfree.bottomnavigationview;

import android.support.v4.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final BottomNavigationView navigationView = (BottomNavigationView)findViewById(R.id.navigationView);
        navigationView.setOnNavigationItemSelectedListener(mSelected);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.pager, new Fragment1()).commit();
    }
    BottomNavigationView.OnNavigationItemSelectedListener mSelected = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.frag1:
                    fragment = new Fragment1();
                    break;
                case R.id.frag2:
                    fragment = new Fragment2();
                    break;
                case R.id.frag3:
                    fragment = new Fragment3();
                    break;
            }
            final FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.pager, fragment).commit();
            return true;
        }
    };
}
