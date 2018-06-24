package com.kharol.papers.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kharol.papers.R;

public class ListApdaterIT extends BaseAdapter
{
    String[] androidListViewStrings;
    Integer[] imagesId;
    Context context;

    public ListApdaterIT(String[] androidListViewStrings, Integer[] imagesId, Context context) {
        this.androidListViewStrings = androidListViewStrings;
        this.imagesId = imagesId;
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
        View viewRow = layoutInflater.inflate(R.layout.customlist_item_it, null,
                true);
        TextView mtextView = (TextView) viewRow.findViewById(R.id.text_view);
        ImageView mimageView = (ImageView) viewRow.findViewById(R.id.image_view);
        mtextView.setText(androidListViewStrings[i]);
        mimageView.setImageResource(imagesId[i]);
        return viewRow;
    }
}
