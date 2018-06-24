package com.kharol.papers.course;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kharol.papers.R;

public class ComputerScience extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_science);
        getSupportActionBar().setTitle("Computer Science & Engineering");
    }
}
