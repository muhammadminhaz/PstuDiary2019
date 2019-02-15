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

public class VeterinaryList extends AppCompatActivity implements SearchView.OnQueryTextListener, SearchView.OnCloseListener {


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
            new CustomDialog(VeterinaryList.this, name.getText().toString(), occupation.getText().toString(), mobile.getText().toString(), email.getText().toString(), ((Parent) VeterinaryList.this.parentList.get(groupPosition)).getName()).show();
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
        myList.setOnChildClickListener(new VeterinaryList.ChildShortClick());

    }


    private void loadSomeData() {

        datafromDb("dvm_anatomy","এনাটমী এন্ড হিসটোলজি");
        datafromDb("dvm_animalproduct","অ্যানিম্যাল প্রোডাক্টস এন্ড বাই প্রোডাক্টস টেকনোলজি");
        datafromDb("dvm_basicscience","বেসিক সায়েন্স");
        datafromDb("dvm_dairyscience","ডেইরী সায়েন্স");
        datafromDb("dvm_phygiology","ফিজিওলজি এন্ড ফার্মাকোলজি");
        datafromDb("dvm_generalanimalscience","জেনারেল এ্যানিম্যাল সায়েন্স এন্ড এ্যানিম্যাল নিউট্রিশন");
        datafromDb("dvm_animalbreeding","জেনেটিক্স এন্ড এনিমাল ব্রিডিং");
        datafromDb("dvm_medicine","মেডিসিন,সার্জারি অ্যান্ড অবস্টেট্রিক্স");
        datafromDb("dvm_microbiology","মাইক্রোবায়োলজি এন্ড পাবলিক হেলথ");
        datafromDb("dvm_paracytology","প্যাথলজি এন্ড প্যারাসাইটোলজি");
        datafromDb("dvm_poultry","পোল্ট্রি সায়েন্স");








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

