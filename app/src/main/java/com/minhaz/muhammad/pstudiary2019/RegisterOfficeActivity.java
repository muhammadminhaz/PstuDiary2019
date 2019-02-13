package com.minhaz.muhammad.pstudiary2019;

import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;

public class RegisterOfficeActivity extends AppCompatActivity implements
        SearchView.OnQueryTextListener, SearchView.OnCloseListener {

    class ChildShortClick implements ExpandableListView.OnChildClickListener
    {

        ChildShortClick(){}



        @Override
        public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
            TextView name = v.findViewById(R.id.nameText);
            TextView occupation = v.findViewById(R.id.occupationText);
            TextView mobile = v.findViewById(R.id.mobile);
            TextView email = v.findViewById(R.id.eemail);
            new CustomDialog(RegisterOfficeActivity.this, name.getText().toString(), occupation.getText().toString(), mobile.getText().toString(), email.getText().toString(), ((Parent) RegisterOfficeActivity.this.parentList.get(groupPosition)).getName()).show();
            return false;
        }
    }

    private SearchView search;
    private CustomAdapter listAdapter;
    private ExpandableListView myList;
    private ArrayList<Parent> parentList = new ArrayList<Parent>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agriculture_list);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        search = (SearchView) findViewById(R.id.search);
        search.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        search.setIconifiedByDefault(false);
        search.setOnQueryTextListener(this);
        search.setOnCloseListener(this);

        //display the list
        displayList();
        //expand all Groups
        expandAll();
    }

    private void expandAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++) {
            myList.expandGroup(i);
        }


    }

    private void displayList() {

        //display the list
        loadSomeData();

        //get reference to the ExpandableListView
        myList = (ExpandableListView) findViewById(R.id.expagrilist);
        //create the adapter by passing your ArrayList data
        listAdapter = new CustomAdapter(this, parentList);
        //attach the adapter to the list
        myList.setAdapter(listAdapter);
        myList.setOnChildClickListener(new ChildShortClick());

    }

    private void loadSomeData() {

//        ArrayList<Child> countryList = new ArrayList<Child>();
//        Child country = new Child("প্রফেসর ডঃ স্বদেশ চন্দ্র সামন্ত", "রেজিস্ট্রার", "01816864529", "ashikur.pstu@yahoo.com");
//        countryList.add(country);
//
//
//        Parent continent = new Parent("রেজিস্ট্রার অফিস", countryList);
//        parentList.add(continent);
    }

    @Override
    public boolean onClose() {
        listAdapter.fillerData("");
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String query) {
        listAdapter.fillerData(query);
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        listAdapter.fillerData(query);
        expandAll();
        return false;
    }
}
