package com.kharol.papers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.kharol.papers.ui.ListAdapterSyllabus;
import com.kharol.papers.ui.ListApdaterIT;

public class PaperCardSyllabus extends AppCompatActivity {


    ListView syllabus;
    String[] subjects = {"2180703 - Artificial Intelligence",
            "2180709 - IOT and Applications"};
    Integer image_id[] = {R.mipmap.ic_c_ai, R.mipmap.ic_c_iot};
    Integer image_d[]={R.drawable.ic_arrow_downward_black_24dp,R.drawable.ic_arrow_downward_black_24dp};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paper_card_syllabus);
        syllabus=findViewById(R.id.syllabus);
        ListAdapterSyllabus listAdapterSyllabus=new ListAdapterSyllabus(subjects,image_id,image_d,this);
        syllabus.setAdapter(listAdapterSyllabus);
    }
}
