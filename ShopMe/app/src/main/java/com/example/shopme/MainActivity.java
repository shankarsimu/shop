package com.example.shopme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    //  Button button;
    Intent intent;
    BottomNavigationView bottomNavigation;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(this));
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(HomeFragment.newInstance("", ""));
        getIntent();
        GridView gv = (GridView) findViewById(R.id.gridView);
        gv.setAdapter(new GridImageAdapter(this));
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                // Toast.makeText(MainActivity.this, "Image Position: " + position, Toast.LENGTH_SHORT).show();
                intent = new Intent(getApplicationContext(), Category.class);
                startActivity(intent);

            }
        });
    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            openFragment(HomeFragment.newInstance("", ""));
                            return true;
                        case R.id.navigation_category:
//                                 openFragment(CategoryFragment.newInstance("", ""));
                            intent = new Intent(getApplicationContext(), Category.class);
                            startActivity(intent);
                            return true;
                        case R.id.navigation_search:
                            openFragment(SearchFragment.newInstance("", ""));
                            return true;
                        case R.id.navigation_offer:
                          intent = new Intent(getApplicationContext(), OfferActivity.class);
                            startActivity(intent);
//                            openFragment(OfferFragment.newInstance("", ""));
//                            return true;
                        case R.id.navigation_cart:
                            intent = new Intent(getApplicationContext(), CartActivity.class);
                            startActivity(intent);

                            // openFragment(CartFragment.newInstance("", ""));
                            return true;
                    }
                    return false;
                }
            };
}
