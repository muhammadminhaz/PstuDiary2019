package com.minhaz.muhammad.pstudiary2019;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.arlib.floatingsearchview.FloatingSearchView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.security.PublicKey;
import java.sql.SQLException;
import java.util.ArrayList;

public class AgricultureList extends AppCompatActivity implements
        SearchView.OnQueryTextListener, SearchView.OnCloseListener {

    //public String

//    private ArrayList<Parent> parentList = new ArrayList();
//    boolean isDataLoad = false;
//    private CustomAdapter listAdapter;
//    private ExpandableListView myList;
//    View rootView = null;
//    private SearchView search;
//    BufferedReader reader = null;
//    ArrayList<Child> childList;
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
//
    class ChildShortClick implements ExpandableListView.OnChildClickListener
    {

        ChildShortClick(){}



        @Override
        public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
            TextView name = v.findViewById(R.id.nameText);
            TextView occupation = v.findViewById(R.id.occupationText);
            TextView mobile = v.findViewById(R.id.mobile);
            TextView email = v.findViewById(R.id.eemail);
            new CustomDialog(AgricultureList.this, name.getText().toString(), occupation.getText().toString(), mobile.getText().toString(), email.getText().toString(), ((Parent) AgricultureList.this.parentList.get(groupPosition)).getName()).show();
            return false;
        }
    }
//
//
//
//    class ChildLongClick implements AdapterView.OnItemLongClickListener {
//        ChildLongClick() {
//        }
//
//        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
//            if (ExpandableListView.getPackedPositionType(id) != 1) {
//                return false;
//            }
//            int groupPosition = ExpandableListView.getPackedPositionGroup(id);
//            int childPosition = ExpandableListView.getPackedPositionChild(id);
//            TextView mobile = (TextView) view.findViewById(R.id.mobile);
//            Intent callIntent = new Intent("android.intent.action.CALL");
//            callIntent.setData(Uri.parse("tel:" + mobile.getText().toString()));
//            AgricultureList.this.startActivity(callIntent);
//            return true;
//        }
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_agriculture_list);
//        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        this.search=(SearchView)findViewById(R.id.search);
//        this.search.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
//        this.search.setIconifiedByDefault(false);
//        this.search.setOnQueryTextListener(this);
//        this.search.setOnCloseListener(this);
//        this.search.setFocusable(false);
//        this.search.setQueryHint("Search...");
//
//
//
//
//
//
//        displayList();
//
//    }
//
//    private void expandAll()
//    {
//        int count = this.listAdapter.getGroupCount();
//        for(int i =0; i < count; i++)
//        {
//            this.myList.expandGroup(i);
//        }
//    }
//
//    private void displayList() {
//        if(!this.isDataLoad)
//        {
//            loadSomeData();
//            this.isDataLoad=true;
//        }
//
//        myList = findViewById(R.id.expagrilist);
//        listAdapter = new CustomAdapter(this, this.parentList);
//        myList.setAdapter(this.listAdapter);
//
//        myList.setOnChildClickListener(new ChildShortClick());
//        myList.setOnItemLongClickListener(new ChildLongClick());
//
//    }
//
//    private void loadSomeData() {
//
//        Throwable th;
////        int j;
//
//        ArrayList<String> departmentList = new ArrayList<>();
//        ArrayList<String> departmentListBangla = new ArrayList<>();
//        departmentList.add("ag_botany");
//        departmentList.add("ag_chemistry");
//        departmentList.add("ag_engg");
//        departmentList.add("ag_ext");
//        departmentList.add("ag_forest");
//        departmentList.add("ag_krisitotto");
//        departmentList.add("ag_animal");
//        departmentList.add("ag_kit");
//        departmentList.add("ag_kouli");
//        departmentList.add("ag_biotech");
//        departmentList.add("ag_hort");
//        departmentList.add("ag_patho");
//        departmentList.add("ag_soil");
//        departmentList.add("ag_stat");
//        departmentListBangla.add("কৃষি উদ্ভিদ বিজ্ঞান");
//        departmentListBangla.add("কৃষি রসায়ন");
//        departmentListBangla.add("কৃষি প্রকৌশলী");
//        departmentListBangla.add("কৃষি সম্প্রসারন ও গ্রামীন উন্নয়ন");
//        departmentListBangla.add("এগ্রোফরেস্ট্রি ");
//        departmentListBangla.add("কৃষিতত্ব");
//        departmentListBangla.add("পশু বিজ্ঞান");
//        departmentListBangla.add("কীটতত্ত্ব");
//        departmentListBangla.add("কৌলিতত্ত্ব ও উদ্ভিদ প্রজনন");
//        departmentListBangla.add("বায়োটেকনোলজি");
//        departmentListBangla.add("উদ্যানতত্ত্ব");
//        departmentListBangla.add("উদ্ভিদ রোগতত্ত্ব");
//        departmentListBangla.add("মৃত্তিকা বিজ্ঞান");
//        departmentListBangla.add("পরিসখ্যান");
//
//
//
//
//
//
//
////        for (int i = 0; i < departmentList.size();i++)
////        {
////            ArrayList<String> name;
////            ArrayList<String> occupation;
////            ArrayList<String> mobile;
////            ArrayList<String> email;
////            int k;
////            this.childList = new ArrayList<>();
////            ArrayList<String> childArray = new ArrayList<>();
////            reader = null;
////
////            try
////            {
////                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getAssets().open(String.valueOf(departmentList.get(i)) + ".txt")));
////
////                while (true)
////                {
////                    try {
////                        String mLine = bufferedReader.readLine();
////                        if (mLine == null)
////                        {
////                            break;
////                        }
////                        childArray.add(mLine);
////                    } catch (IOException ex)
////                    {
////                        reader = bufferedReader;
////                    } catch (Throwable th2) {
////                        th = th2;
////                        reader = bufferedReader;
////                    }
////                }
////
////                if (bufferedReader !=null)
////                {
////                    try {
////                        bufferedReader.close();
////                        reader = bufferedReader;
////                    } catch (IOException e2) {
////                        reader = bufferedReader;
////                    }
////                } else {
////                    reader = bufferedReader;
////                }
////            }  catch (IOException e3)
////            {
////                if(reader!= null) {
////                    try{
////                        reader.close();
////                    } catch (IOException e4){
////
////                    }
////                }
////
////                name = new ArrayList<>();
////                occupation = new ArrayList<>();
////                mobile = new ArrayList<>();
////                email = new ArrayList<>();
////                for(int j=0;j<childArray.size();j+=4)
////                {
////                    name.add((String)childArray.get(j));
////                }
////                for(int j=1;j<childArray.size();j+=4)
////                {
////                    occupation.add((String)childArray.get(j));
////                }
////                for(int j=2;j<childArray.size();j+=4)
////                {
////                    mobile.add((String)childArray.get(j));
////                }
////                for(int j=3;j<childArray.size();j+=4)
////                {
////                    email.add((String)childArray.get(j));
////                }
////
////                for (k=0;k<name.size();k++)
////                {
////                    Child child = new Child(name.get(k), occupation.get(k),mobile.get(k),email.get(k));
////                    child.setDept(departmentListBangla.get(i));
////                    this.childList.add(child);
////                }
////
////                this.parentList.add(new Parent(departmentList.get(i),this.childList));
////            } catch (Throwable th3){
////                th=th3;
////            }
////
////            name = new ArrayList<>();
////            occupation = new ArrayList<>();
////            mobile = new ArrayList<>();
////            email = new ArrayList<>();
////            for(int j=0; j < childArray.size(); j+=4)
////            {
////                name.add(childArray.get(j));
////            }
////
////            for(int j=1; j < childArray.size(); j+=4)
////            {
////                occupation.add(childArray.get(j));
////            }
////            for(int j=2; j < childArray.size(); j+=4)
////            {
////                mobile.add(childArray.get(j));
////            }
////            for(int j=3; j < childArray.size(); j+=4)
////            {
////                email.add(childArray.get(j));
////            }
////
////
////            for (k=0;k<childArray.size();k++)
////            {
////                Child child2 = new Child(name.get(k),occupation.get(k),mobile.get(k),email.get(k));
////                child2.setDept(departmentListBangla.get(i));
////                this.childList.add(child2);
////            }
////            this.parentList.add(new Parent(departmentListBangla.get(i),this.childList));
////        }
////        return;
////        throw  th;
////        if (reader!=null)
////        {
////            try{
////                reader.close();
////            } catch (IOException e5)
////            { }
////        }
////        throw th;
//
//    }
//
//
//    @Override
//    public boolean onClose() {
//        this.listAdapter.fillerData("");
//        expandAll();
//        return false;
//    }
//
//    @Override
//    public boolean onQueryTextSubmit(String query) {
//        this.listAdapter.fillerData(query);
//        return false;
//    }
//
//    @Override
//    public boolean onQueryTextChange(String query) {
//        this.listAdapter.fillerData(query);
//        return false;
//    }
//}


    private CustomAdapter listAdapter;
    private ExpandableListView myList;
    private ArrayList<Parent> parentList = new ArrayList<>();
    Cursor c = null;           //zihan
    DatabaseHelper myDbHelper;      //zihan
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

//    public void showDialog() {
//
//
//        Dialog dialog = new Dialog(this);
//        dialog.setContentView(R.layout.dialog);
//
//
//        TextView name = findViewById(R.id.nameText);
//        TextView occu = findViewById(R.id.occupationText);
//        TextView dept = findViewById(R.id.dept);
//        final TextView number = findViewById(R.id.mobile);
//        TextView email = findViewById(R.id.eemail);
//
//
//
//
//
//
//
////        Button call=findViewById(R.id.call);
////        call.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Intent callIntent = new Intent(Intent.ACTION_CALL);
////
////               callIntent.setData(Uri.parse("tel:" + number.getText().toString()));
////
////            }
////        });
//
//        dialog.show();
//    }

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
        myList.setOnChildClickListener(new ChildShortClick());

    }


    private void loadSomeData() {




      datafromDb("ag_botany","কৃষি উদ্ভিদ বিজ্ঞান");
      datafromDb("ag_chemistry","কৃষি রসায়ন");
      datafromDb("ag_engg","কৃষি প্রকৌশলী");
      datafromDb("ag_ext","কৃষি সম্প্রসারন ও গ্রামীন উন্নয়ন");
      datafromDb("ag_forest","এগ্রোফরেস্ট্রি");
      datafromDb("ag_krisitotto","কৃষিতত্ব");
      datafromDb("ag_animal","পশু বিজ্ঞান");
      datafromDb("ag_kit","কীটতত্ত্ব");
      datafromDb("ag_kouli","কৌলিতত্ত্ব ও উদ্ভিদ প্রজনন");
      datafromDb("ag_biotech","বায়োটেকনোলজি");
      datafromDb("ag_hort","উদ্যানতত্ত্ব");
      datafromDb("ag_patho","উদ্ভিদ রোগতত্ত্ব");
      datafromDb("ag_soil","মৃত্তিকা বিজ্ঞান");
      datafromDb("ag_stat","পরিসখ্যান");





    }



//zihan
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
























    /*
    ArrayList<String> list;
    FloatingSearchView searchView;
    ListView listView;
    ArrayAdapter arrayAdapter;





    private CustomAdapter adapter;
    private ExpandableListView expandList;
    private ArrayList<Parent> expListItems;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agriculture_list);





        expandList = findViewById(R.id.expagrilist);
        expListItems = PrepareData();
        adapter = new CustomAdapter(this, expListItems);
        expandList.setAdapter(adapter);
        for(int i=0; i < adapter.getGroupCount(); i++)
            expandList.expandGroup(i);









    }

    public ArrayList<Parent> PrepareData() {

        String dept[] = {"A-G", "H-N", "O-U", "V-Z"};
        String name[] = {"1", "2", "3", "4", "5",
                "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15","16",
                "17","18","19","20"};
        String occu[] = {"Brazil", "Mexico", "Croatia", "Cameroon",
                "Netherlands", "chile", "Spain", "Australia", "Colombia",
                "Greece", "Greece", "chile", "chile", "chile", "chile","Colombia","Colombia","Colombia","Colombia","Colombia"};

        int size = 5;
        ArrayList<Parent> list = new ArrayList<>();
        ArrayList<Child> children;

        for(String depts: dept)
        {
            Parent parent = new Parent();
            parent.setName(depts);
            children = new ArrayList<>();

            for (int j=0;j<4;j++)
            {
                Child child = new Child();
                child.setName(occu[j]);
                child.setOccupation(name[j]);

                children.add(child);
            }

            parent.setList(children);
            list.add(parent);

            size = size+5;


        }


        return list;
    }
*/









