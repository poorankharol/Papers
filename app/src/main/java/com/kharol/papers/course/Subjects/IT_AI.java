package com.kharol.papers.course.Subjects;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.kharol.papers.R;
import com.kharol.papers.helper.DownloadTask;
import com.kharol.papers.urls.URLs;

import org.json.JSONException;
import org.json.JSONObject;


import java.io.File;
import java.util.ArrayList;

import static com.kharol.papers.urls.URLs.AI_11;

public class IT_AI extends AppCompatActivity
{

    ListView it_ai;
    ArrayList<String> Store=new ArrayList<>();
    ArrayAdapter<String> stringArrayAdapter;
    private ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it__ai);
        load();
        it_ai=findViewById(R.id.it_ai);
        it_ai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                String selectedItem = (String) adapterView.getItemAtPosition(i);
                if (i==11)
                {
                    //TODO Check IN Storage
                    new DownloadTask(IT_AI.this,AI_11);
                    addNotification(selectedItem);
                    viewPDF(view,selectedItem);
                }
            }
        });

    }
    private void addNotification(String name)
    {
        android.support.v4.app.NotificationCompat.Builder builder=new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Gtu Papers")
                .setContentText(name);
        Intent i=new Intent(this,IT_AI.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(alarmSound);
        NotificationManager notificationManager= (NotificationManager)this.getSystemService(this.NOTIFICATION_SERVICE);
        notificationManager.notify(0,builder.build());
    }
    public void viewPDF(View v,String name)
    {
        File pdfFile = new File(Environment.getExternalStorageDirectory() + "/Gtu Papers/" + name);
        // -> filename = maven.pdf
        Uri path = Uri.fromFile(pdfFile);
        Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
        pdfIntent.setDataAndType(path, "application/pdf");
        pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        try{
            startActivity(pdfIntent);
        }catch(ActivityNotFoundException e){
            Toast.makeText(IT_AI.this, "No Application available to view PDF", Toast.LENGTH_SHORT).show();
        }
    }
    private void load()
    {
        mProgressDialog = new ProgressDialog(IT_AI.this);
        mProgressDialog.setMessage("Please Wait....");
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.show();
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URLs.files_url, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                mProgressDialog.hide();
                try
                {
                    JSONObject object = new JSONObject(response);
                    for (int i = 0; i < object.length(); i++)
                    {
                        JSONObject jsonObject=object.getJSONObject("data");
                        Store.add(jsonObject.getString("2"));
                        Store.add(jsonObject.getString("3"));
                        Store.add(jsonObject.getString("4"));
                        Store.add(jsonObject.getString("5"));
                        Store.add(jsonObject.getString("6"));
                        Store.add(jsonObject.getString("7"));
                        Store.add(jsonObject.getString("8"));
                        Store.add(jsonObject.getString("9"));
                        Store.add(jsonObject.getString("10"));
                        Store.add(jsonObject.getString("11"));
                        Store.add(jsonObject.getString("12"));
                        Store.add(jsonObject.getString("13"));
                    }
                    stringArrayAdapter=new ArrayAdapter<>(IT_AI.this,android.R.layout.simple_list_item_1,Store);
                    it_ai.setAdapter(stringArrayAdapter);
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {

            }
        });
        Volley.newRequestQueue(this).add(stringRequest);
    }

}
