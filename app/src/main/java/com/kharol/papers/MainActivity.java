package com.kharol.papers;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    CardView papercardId,papercardSyllabus;
    private Boolean isFabOpen=false;
    private FloatingActionButton fab,fab1,fab2;
    private Animation fab_open,fab_close,rotate_forward,rotate_backard;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab= (FloatingActionButton)findViewById(R.id.fab);
        fab1= (FloatingActionButton) findViewById(R.id.fab1);
        fab2= (FloatingActionButton) findViewById(R.id.fab2);
        fab_open= AnimationUtils.loadAnimation(this,R.anim.fab_open);
        fab_close= AnimationUtils.loadAnimation(this,R.anim.fab_close);
        rotate_forward= AnimationUtils.loadAnimation(this,R.anim.rotate_forward);
        rotate_backard= AnimationUtils.loadAnimation(this,R.anim.rotate_backward);
        fab.setOnClickListener(this);
        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);
        papercardId=findViewById(R.id.papercardId);
        papercardId.setOnClickListener(this);
        papercardSyllabus=findViewById(R.id.papercardSyllabus);
        papercardSyllabus.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.papercardId:
                startActivity(new Intent(getApplicationContext(),PaperCardActivity.class));
                break;
            case R.id.papercardSyllabus:
                startActivity(new Intent(getApplicationContext(),PaperCardSyllabus.class));
                break;
            case R.id.fab:
                animateFab();
                break;
            case R.id.fab1:
                 startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                break;
            case R.id.fab2:
                //startActivity(new Intent(getActivity(), StatusScheduler.class));
                break;
        }
    }
    @Override
    public void onBackPressed()
    {
        Log.d("CDA", "onBackPressed Called");
        Intent setIntent = new Intent(Intent.ACTION_MAIN);
        setIntent.addCategory(Intent.CATEGORY_HOME);
        setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(setIntent);
    }
    private void animateFab()
    {
        if (isFabOpen)
        {
            fab.startAnimation(rotate_backard);
            fab1.startAnimation(fab_close);
            fab2.startAnimation(fab_close);
            fab1.setClickable(false);
            fab2.setClickable(false);
            isFabOpen=false;
            Log.d("FAB","close");
        }
        else {
            fab.startAnimation(rotate_forward);
            fab1.startAnimation(fab_open);
            fab2.startAnimation(fab_open);
            fab1.setClickable(true);
            fab2.setClickable(true);
            isFabOpen=true;
            Log.d("FAB","open");
        }
    }
}
