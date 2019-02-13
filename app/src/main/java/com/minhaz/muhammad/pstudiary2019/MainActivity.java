package com.minhaz.muhammad.pstudiary2019;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void Developers(MenuItem item) {
        Intent i = new Intent(this, DeveloperActivity.class);
        startActivity(i);
    }

    public void ProVC(View view) {

       CustomDialog customDialog = new CustomDialog(MainActivity.this,"a","a","a","a","a");
       customDialog.show();
    }

    public void VC(View view) {
        CustomDialog customDialog = new CustomDialog(MainActivity.this,"a","a","a","a","a");
        customDialog.show();
    }

    public void EmergencyList(View view) {
        Intent i = new Intent(this,EmergencyActivity.class);
        startActivity(i);

    }

    public void ExternalList(View view) {
        Intent i = new Intent(this,ExternalActivity.class);
        startActivity(i);
    }

    public void DeanList(View view) {
        Intent i = new Intent(this,DeanOfficeActivity.class);
        startActivity(i);
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            //TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position) {
                case 0:
                    Faculty tab1 = new Faculty();
                    return tab1;
                case 1:
                    Administration tab2 = new Administration();
                    return tab2;
                case 2:
                    Services tab3 = new Services();
                    return tab3;


            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }
    }

    public void AgriList(View view) {

        Intent intent = new Intent(this, AgricultureList.class);
        startActivity(intent);
    }

    public void FishList(View view)
    {
        Intent intent = new Intent(this, FisheriesList.class);
        startActivity(intent);

    }

    public void CseList(View view)
    {
        Intent intent = new Intent(this, ComputerScienceList.class);
        startActivity(intent);

    }

    public void BamList(View view)
    {
        Intent intent = new Intent(this, BusinessAdministrationManagementList.class);
        startActivity(intent);

    }

    public void VeteList(View view)
    {
        Intent intent = new Intent(this, VeterinaryList.class);
        startActivity(intent);

    }

    public void DmList(View view)
    {
        Intent intent = new Intent(this, DisasterManagementList.class);
        startActivity(intent);

    }

    public void LandList(View view)
    {
        Intent intent = new Intent(this, LandManagementList.class);
        startActivity(intent);

    }

    public void FoodList(View view)
    {
        Intent intent = new Intent(this, NutritionAndFoodList.class);
        startActivity(intent);

    }

    public void GeneralList(View view) {
        Intent intent = new Intent (this, GeneralServicesActivity.class);
        startActivity(intent);
    }

    public void RegisterList(View view) {
        Intent intent = new Intent (this, RegisterOfficeActivity.class);
        startActivity(intent);
    }



}
