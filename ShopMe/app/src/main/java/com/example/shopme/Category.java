package com.example.shopme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Category extends AppCompatActivity {//implements ProductAdapter.CallBackUs, ProductAdapter.HomeCallBack {

    ExpandableCategoryListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getIntent();

        expListView = (ExpandableListView) findViewById(R.id.categoryExpList);


        prepareListData();

        listAdapter = new ExpandableCategoryListAdapter(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);

        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                return false;
            }
        });

        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
               // Toast.makeText(getApplicationContext(),listDataHeader.get(groupPosition) + " Expanded",Toast.LENGTH_SHORT).show();
            }
        });


        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
        listDataHeader.add("Foodgrains");
        listDataHeader.add("Oils");
        listDataHeader.add("Spices & Masala");
        listDataHeader.add("Bakery & Cakes");
        listDataHeader.add("Milk Products & Dairy");
        listDataHeader.add("Beverages");
        listDataHeader.add("Biscuits & Snacks");
        listDataHeader.add("Beauty & Hygiene");
        listDataHeader.add("Cleaing & Household");
        listDataHeader.add("Baby Care");
        listDataHeader.add("Eggs,Meat & Fish");

        List<String> Foodgrains = new ArrayList<String>();
        Foodgrains.add("The Shawshank Redemption");
        Foodgrains.add("The Godfather");
        Foodgrains.add("The Godfather: Part II");
        Foodgrains.add("Pulp Fiction");
        Foodgrains.add("The Good, the Bad and the Ugly");
        Foodgrains.add("The Dark Knight");
        Foodgrains.add("12 Angry Men");

        List<String> Oils = new ArrayList<String>();
        Oils.add("The Conjuring");
        Oils.add("Despicable Me 2");
        Oils.add("Turbo");
        Oils.add("Grown Ups 2");
        Oils.add("Red 2");
        Oils.add("The Wolverine");

        List<String>  Spices = new ArrayList<String>();
        Spices.add("2 Guns");
        Spices.add("The Smurfs 2");
        Spices.add("The Spectacular Now");
        Spices.add("The Canyons");
        Spices.add("Europa Report");

        List<String>  Bakery  = new ArrayList<String>();
        Bakery.add("2 Guns");
        Bakery.add("The Smurfs 2");
        Bakery.add("The Spectacular Now");
        Bakery.add("The Canyons");
        Bakery.add("Europa Report");


        List<String>  MilkProduct = new ArrayList<String>();
        MilkProduct.add("2 Guns");
        MilkProduct.add("The Smurfs 2");
        MilkProduct.add("The Spectacular Now");
        MilkProduct.add("The Canyons");
        MilkProduct.add("Europa Report");

        List<String>  Beverages = new ArrayList<String>();
        Beverages.add("2 Guns");
        Beverages.add("The Smurfs 2");
        Beverages.add("The Spectacular Now");
        Beverages.add("The Canyons");
        Beverages.add("Europa Report");

        List<String>  Biscuits = new ArrayList<String>();
        Biscuits.add("2 Guns");
        Biscuits.add("The Smurfs 2");
        Biscuits.add("The Spectacular Now");
        Biscuits.add("The Canyons");
        Biscuits.add("Europa Report");

        List<String>  Beauty = new ArrayList<String>();
        Beauty.add("2 Guns");
        Beauty.add("The Smurfs 2");
        Beauty.add("The Spectacular Now");
        Beauty.add("The Canyons");
        Beauty.add("Europa Report");

        List<String>  Cleaing = new ArrayList<String>();
        Cleaing.add("2 Guns");
        Cleaing.add("The Smurfs 2");
        Cleaing.add("The Spectacular Now");
        Cleaing.add("The Canyons");
        Cleaing.add("Europa Report");

        List<String>  BabyCare = new ArrayList<String>();
        BabyCare.add("2 Guns");
        BabyCare.add("The Smurfs 2");
        BabyCare.add("The Spectacular Now");
        BabyCare.add("The Canyons");
        BabyCare.add("Europa Report");

        List<String>  EggsMeatFish = new ArrayList<String>();
        EggsMeatFish.add("2 Guns");
        EggsMeatFish.add("The Smurfs 2");
        EggsMeatFish.add("The Spectacular Now");
        EggsMeatFish.add("The Canyons");
        EggsMeatFish.add("Europa Report");

        listDataChild.put(listDataHeader.get(0), Foodgrains);
        listDataChild.put(listDataHeader.get(1), Oils);
        listDataChild.put(listDataHeader.get(2),  Spices );
        listDataChild.put(listDataHeader.get(3), Bakery);
        listDataChild.put(listDataHeader.get(4), MilkProduct);
        listDataChild.put(listDataHeader.get(5),  Beverages );
        listDataChild.put(listDataHeader.get(6), Biscuits);
        listDataChild.put(listDataHeader.get(7), Beauty);
        listDataChild.put(listDataHeader.get(8),  Cleaing );
        listDataChild.put(listDataHeader.get(9), BabyCare);
        listDataChild.put(listDataHeader.get(10), EggsMeatFish);
    }
}


