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

public class BusinessAdministrationManagementList extends AppCompatActivity implements SearchView.OnQueryTextListener, SearchView.OnCloseListener {


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
            new CustomDialog(BusinessAdministrationManagementList.this, name.getText().toString(), occupation.getText().toString(), mobile.getText().toString(), email.getText().toString(), ((Parent) BusinessAdministrationManagementList.this.parentList.get(groupPosition)).getName()).show();

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
        myList.setOnChildClickListener(new BusinessAdministrationManagementList.ChildShortClick());

    }


    private void loadSomeData() {



        datafromDb("bam_ais","একাউন্টিং এন্ড ইনফরমেশন সিস্টেমস");
        datafromDb("bam_economics","ইকোনোমিক্স এন্ড সোশিওলজি");
        datafromDb("bam_finance","ফিন্যান্স এন্ড ব্যাংকিং");
        datafromDb("bam_lcm","ল্যাংগুয়েজ এন্ড কমিউনিকেশন");
        datafromDb("bam_management","ম্যানেজমেন্ট স্টাডিজ");
        datafromDb("bam_marketing","মার্কেটিং");






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

