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

public class GeneralServicesActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, SearchView.OnCloseListener {


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
            new CustomDialog(GeneralServicesActivity.this, name.getText().toString(), occupation.getText().toString(), mobile.getText().toString(), email.getText().toString(), ((Parent) GeneralServicesActivity.this.parentList.get(groupPosition)).getName()).show();
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
        myList.setOnChildClickListener(new GeneralServicesActivity.ChildShortClick());

    }


    private void loadSomeData() {


        //Put data here

        datafromDb("off_establish","সংস্থাপন শাখা");
        datafromDb("off_affears","কউন্সিল অ্যাফেয়ার্স");
        datafromDb("off_edu","শিক্ষা ও বৃত্তি শাখা");
        datafromDb("off_information","তথ্য প্রদান ইউনিট");
        datafromDb("off_proquire","প্রকিউরমেন্ট এন্ড স্টোর শাখা");
        datafromDb("off_finan","অর্থ ও হিসাব বিভাগ");
        datafromDb("off_accounts","একাউন্টস বিল এন্ড সেলারি সেকশন");
        datafromDb("off_fund","ক্যাশ ফান্ড এন্ড পেনশন সেকশন ");
        datafromDb("off_audit","অডিট সেকশন");
        datafromDb("off_budget","বাজেট সেকশন");
        datafromDb("off_plan","পরিকল্পনা, উন্নয়ন ও ওয়ার্কস");
        datafromDb("off_eng ","প্রকৌশল বিভাগ");
        datafromDb("off_exam","পরীক্ষা নিয়ন্ত্রক শাখা");
        datafromDb("off_library","কেন্দ্রীয় গ্রন্থাগার");
        datafromDb("off_physical","শারীরিক শিক্ষা");
        datafromDb("off_publication","জনসংযোগ ও প্রকাশনা শাখা");
        datafromDb("off_farm","কৃষি খামার");
        datafromDb("off_ictcell","আইসিটি সেল");
        datafromDb("off_ictcenter","আইসিটি সেন্টার");
        datafromDb("off_research","কেন্দ্রীয় গবেষণাগার");
        datafromDb("off_rearchcenter","সেন্টার ফর রিসার্চ এন্ড ট্রেনিং");
        datafromDb("off_legal","এস্টেট এ্যাফেয়ার্স এন্ড লিগ্যাল এ্যাডভাইজরি শাখা");
        datafromDb("off_mosq","কেন্দ্রীয় জামে মসজিদ");
        datafromDb("off_srijoni","সৃজনী বিদ্যানিকেতন ");
        datafromDb("off_teachersassociation","শিক্ষক সমিতি");
        datafromDb("off_associarion","অফিসার্স অ্যাসোসিয়েশান ");
        datafromDb("off_staffassociation","কর্মচারী পরিষদ ");
//        datafromDb("off_businessclub","বিজনেস ক্লাব");
//        datafromDb("off_debatclub","ডিবেটিং সোসাইটি");
        //datafromDb("off_budget","সেকশন");







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


