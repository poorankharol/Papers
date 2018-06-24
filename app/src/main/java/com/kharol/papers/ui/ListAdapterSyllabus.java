package com.kharol.papers.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kharol.papers.R;

public class ListAdapterSyllabus extends BaseAdapter
{
    String[] androidListViewStrings;
    Integer[] imagesId;
    Integer[] imagesDown;
    Context context;

    public ListAdapterSyllabus(String[] androidListViewStrings, Integer[] imagesId, Integer[] imagesDown, Context context) {
        this.androidListViewStrings = androidListViewStrings;
        this.imagesId = imagesId;
        this.imagesDown = imagesDown;
        this.context = context;
    }

    @Override
    public int getCount() {
        return androidListViewStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewRow = layoutInflater.inflate(R.layout.custom_list_syllabus, null,
                true);
        TextView mtextView = (TextView) viewRow.findViewById(R.id.text_view_s);
        ImageView mimageView = (ImageView) viewRow.findViewById(R.id.image_view_s);
        ImageView dimageView=viewRow.findViewById(R.id.image_view_d);
        mtextView.setText(androidListViewStrings[i]);
        mimageView.setImageResource(imagesId[i]);
        dimageView.setImageResource(imagesDown[i]);
        return viewRow;
    }
}
