package com.minhaz.muhammad.pstudiary2019;



import android.app.SearchManager;
import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.arlib.floatingsearchview.FloatingSearchView;

import java.io.IOException;
import java.util.ArrayList;

public class NutritionAndFoodList extends AppCompatActivity implements SearchView.OnQueryTextListener, SearchView.OnCloseListener {


    private CustomAdapter listAdapter;
    private ExpandableListView myList;
    private ArrayList<Parent> parentList = new ArrayList<>();
    Cursor c = null;           //zihan
    DatabaseHelper myDbHelper;      //zihan

    @Override
    public boolean onClose() {
        listAdapter.fillerData("");
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        listAdapter.fillerData(query);
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        listAdapter.fillerData(newText);
        expandAll();
        return false;
    }

    class ChildShortClick implements ExpandableListView.OnChildClickListener
    {

        ChildShortClick(){}



        @Override
        public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
            TextView name = v.findViewById(R.id.nameText);
            TextView occupation = v.findViewById(R.id.occupationText);
            TextView mobile = v.findViewById(R.id.mobile);
            TextView email = v.findViewById(R.id.eemail);
            new CustomDialog(NutritionAndFoodList.this, name.getText().toString(), occupation.getText().toString(), mobile.getText().toString(), email.getText().toString(), ((Parent) NutritionAndFoodList.this.parentList.get(groupPosition)).getName()).show();
            return false;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agriculture_list);

        myDbHelper = new DatabaseHelper(getApplicationContext());       //zihan


        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        SearchView search = findViewById(R.id.search);


        assert searchManager != null;
        search.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        search.setIconifiedByDefault(false);
        search.setFocusable(false);
        search.setOnQueryTextListener(this);
        search.setOnCloseListener(this);

        displayList();

        expandAll();
    }

    private void expandAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++) {
            myList.expandGroup(i);
        }
    }

    //method to expand all groups
    private void displayList() {

        //display the list
        loadSomeData();

        //get reference to the ExpandableListView
        myList = (ExpandableListView) findViewById(R.id.expagrilist);
        //create the adapter by passing your ArrayList data
        listAdapter = new CustomAdapter(this, parentList);
        //attach the adapter to the list
        myList.setAdapter(listAdapter);
        myList.setOnChildClickListener(new NutritionAndFoodList.ChildShortClick());

    }


    private void loadSomeData() {



        datafromDb("nfs_bio","বায়োকেমিস্ট্রি এন্ড ফুড এনালাইসিস");
        datafromDb("nfs_human","হিউম্যান নিউট্রিশন এন্ড ডাইটেটিক্স");
        datafromDb("nfs_micro","ফুড মাইক্রোবায়োলজি");
        datafromDb("nfs_food","ফুড টেকনোলজী এন্ড ইঞ্জিনিয়ারিং");
        datafromDb("nfs_post","পোস্ট-হারভেস্ট টেকনোলজি এন্ড মার্কেটিং");
        datafromDb("nfs_com","কমিউনিটি হেলথ্ এন্ড হাইজিন");
        datafromDb("nfs_envsan","এনভায়রনমেন্টাল স্যানিটেশন বিভাগ");//i dont know





    }

    public void datafromDb(String table_name,String department_name){
        ArrayList<Child> childList = new ArrayList<Child>();


        try {
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }

        myDbHelper.openDataBase();


        c = myDbHelper.query(table_name, null, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {
                Child child = new Child( c.getString(0),  c.getString(1), c.getString(2),  c.getString(3));
                childList.add(child);
            } while (c.moveToNext());
            Parent parent = new Parent(department_name, childList);
            parentList.add(parent);

        }
    }



}

