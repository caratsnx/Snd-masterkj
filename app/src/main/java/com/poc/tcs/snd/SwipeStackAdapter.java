package com.poc.tcs.snd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.poc.tcs.snd.R;

import java.util.List;

/**
 * Created by 122913 on 12/4/2017.
 */

public class SwipeStackAdapter extends BaseAdapter {

    private List<String> mData;
    private Context mCtx;
    public SwipeStackAdapter(List<String> data,Context ctx) {
        this.mData = data;
        mCtx = ctx;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public String getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mCtx.getSystemService( Context.LAYOUT_INFLATER_SERVICE );

        convertView = inflater.inflate(R.layout.stack_layout, parent, false);

        return convertView;
    }
}