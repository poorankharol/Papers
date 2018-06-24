package com.kharol.papers.course;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kharol.papers.R;

public class Civil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_civil);
        getSupportActionBar().setTitle("Civil Engineering");
    }
}
