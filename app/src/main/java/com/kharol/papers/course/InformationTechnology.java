package com.kharol.papers.course;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.kharol.papers.course.IT.SemesterEight;
import com.kharol.papers.course.IT.SemesterSeven;
import com.kharol.papers.R;
import com.kharol.papers.course.IT.SemesterSix;
import com.kharol.papers.ui.ListApdaterIT;

public class InformationTechnology extends AppCompatActivity
{
    ListView listit;
    String sem[]={"Semester 1","Semester 2","Semester 3","Semester 4","Semester 5","Semester 6","Semester 7","Semester 8"};
    Integer image_id[] = {R.mipmap.ic_one, R.mipmap.ic_two, R.mipmap.ic_three,
            R.mipmap.ic_four, R.mipmap.ic_five, R.mipmap.ic_six,
            R.mipmap.ic_seven, R.mipmap.ic_eight};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_technology);
        getSupportActionBar().setTitle("Information Technology");
        listit=findViewById(R.id.listit);
        //ArrayAdapter<String> stringArrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,sem);
        //listit.setAdapter(stringArrayAdapter);
        listit.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                if (i==5)
                {
                    startActivity(new Intent(getApplicationContext(), SemesterSix.class));
                }
                if(i==6)
                {
                    startActivity(new Intent(getApplicationContext(), SemesterSeven.class));
                }
                if (i==7)
                {
                    startActivity(new Intent(getApplicationContext(),SemesterEight.class));
                }

            }
        });
        ListApdaterIT listApdaterIT=new ListApdaterIT(sem,image_id,this);
        listit.setAdapter(listApdaterIT);
    }
}
