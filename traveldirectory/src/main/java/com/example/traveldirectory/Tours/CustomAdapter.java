package com.example.traveldirectory.Tours;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.traveldirectory.R;

public class CustomAdapter extends BaseAdapter {


    int [] maps;
    String [] tours;
    Context context;
    private LayoutInflater inflater;

    CustomAdapter (Context cont,String[] data, int[] pic){
        context = cont;
        tours = data;
        maps = pic;
    }

    @Override
    public int getCount() {
        return tours.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null)
        {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_adapter_view,parent,false);
        }


        TextView tv =convertView.findViewById(R.id.textViewTourNumber);
        ImageView iv = convertView.findViewById(R.id.imageView);

        tv.setText(tours[position]);
        iv.setImageResource(maps[position]);

        return convertView;
    }
}
