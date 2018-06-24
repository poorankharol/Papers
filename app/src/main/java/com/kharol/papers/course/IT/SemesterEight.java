package com.kharol.papers.course.IT;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.kharol.papers.R;
import com.kharol.papers.helper.DownloadTask;
import com.kharol.papers.ui.ListApdaterIT;

import static com.kharol.papers.urls.URLs.AI_180703;
import static com.kharol.papers.urls.URLs.AI_2180703;


public class SemesterEight extends AppCompatActivity
{
    ListView subjectlistofit8;
    String[] subjects = {"2180703 - Artificial Intelligence",
            "2180709 - IOT and Applications",
            "2180711 - Python Programming",
            "2180712 - Cloud Infrastructure and Services"
            , "2180713 - Web Data Management",
            "2180714 - iOS Programming",
            "2180715 - Android Programming",
            "2181607 - Mutlimedia and Animation"};
    Integer image_id[] = {R.mipmap.ic_c_ai, R.mipmap.ic_c_iot, R.mipmap.ic_c_phyton,
            R.mipmap.ic_c_cis, R.mipmap.ic_c_wdm, R.mipmap.ic_c_ios,
            R.mipmap.ic_c_android, R.mipmap.ic_c_ma};
    // Progress dialog
    AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester_eight);
        alertDialogBuilder = new AlertDialog.Builder(this);
        permission_check();

    }

    private void permission_check() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
                return;
            }
        }
        initialize();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 100 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
        {
            initialize();
        } else
            {
            permission_check();
        }
    }

    private void initialize()
    {
        subjectlistofit8 = findViewById(R.id.subjectlistofit8);
        ListApdaterIT listApdaterIT=new ListApdaterIT(subjects,image_id,this);
        subjectlistofit8.setAdapter(listApdaterIT);
        subjectlistofit8.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long l)
            {
                if (i == 0)
                {
                    CharSequence[] AI_CODES = {"180703", "2180703"};
                    AlertDialog.Builder builder = new AlertDialog.Builder(SemesterEight.this);
                    builder.setTitle("Select File To Download..!");
                    builder.setItems(AI_CODES, new DialogInterface.OnClickListener()
                    {
                        public void onClick(DialogInterface dialog, int item)
                        {
                            if (item == 0)
                            {
                                new DownloadTask(SemesterEight.this, AI_180703);
                            }
                            if (item == 1)
                            {
                                new DownloadTask(SemesterEight.this, AI_2180703);
                            }
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
                return true;
            }
        });
    }

}
