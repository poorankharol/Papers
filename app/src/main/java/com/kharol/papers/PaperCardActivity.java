package com.kharol.papers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import com.kharol.papers.course.AutoMobile;
import com.kharol.papers.course.Civil;
import com.kharol.papers.course.ComputerScience;
import com.kharol.papers.course.Electical;
import com.kharol.papers.course.ElectronicsCommunication;
import com.kharol.papers.course.InformationTechnology;
import com.kharol.papers.course.Mechanical;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PaperCardActivity extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paper_card);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.paperlist);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);


        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener()
        {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id)
            {
                if (childPosition==0)
                {
                    startActivity(new Intent(getApplicationContext(), AutoMobile.class ));
                }
                if (childPosition==1)
                {
                    startActivity(new Intent(getApplicationContext(), Civil.class ));
                }
                if (childPosition==2)
                {
                    startActivity(new Intent(getApplicationContext(), ComputerScience.class ));
                }
                if (childPosition==3)
                {
                    startActivity(new Intent(getApplicationContext(), Electical.class ));
                }
                if (childPosition==4)
                {
                    startActivity(new Intent(getApplicationContext(), ElectronicsCommunication.class ));
                }
                if (childPosition==5)
                {
                    startActivity(new Intent(getApplicationContext(), InformationTechnology.class ));
                }
                if (childPosition==6)
                {
                    startActivity(new Intent(getApplicationContext(), Mechanical.class ));
                }
                return false;
            }
        });

    }
    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Bachelor Of Engineering");
        //listDataHeader.add("Now Showing");
        //listDataHeader.add("Coming Soon..");

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("Automobile Engineering");
        top250.add("Civil Engineering");
        top250.add("Computer Science & Engineering");
        top250.add("Electrical Engineering");
        top250.add("Electronics & Communication Engineering");
        top250.add("Information Technology");
        top250.add("Mechanical Engineering");

       /* List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("The Conjuring");
        nowShowing.add("Despicable Me 2");
        nowShowing.add("Turbo");
        nowShowing.add("Grown Ups 2");
        nowShowing.add("Red 2");
        nowShowing.add("The Wolverine");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("2 Guns");
        comingSoon.add("The Smurfs 2");
        comingSoon.add("The Spectacular Now");
        comingSoon.add("The Canyons");
        comingSoon.add("Europa Report");*/

        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
       // listDataChild.put(listDataHeader.get(1), nowShowing);
        //listDataChild.put(listDataHeader.get(2), comingSoon);
    }
}
