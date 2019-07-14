package com.example.chapter3.homework;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {
    private String[] args = new String[]{"1","2","3","4","5","6","7","8","9","10","11","a","b","c","d","e","f"};
    private Context mContext;
    public ListViewAdapter(Context context) {
        mContext = context;
    }
    @Override
    public int getCount() {
        return args.length;
    }
    @Override
    public Object getItem(int position) {
        return null;
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            view = inflater.inflate(R.layout.list_item, null);
            Log.d("ListViewAdapter",
                    "getView() called with: position = [" + position + "], convertView = [" + convertView + "], parent = [" +
                            parent + "]");
        } else {
            //!=null
            view = convertView;
        }
        TextView textView= view.findViewById(R.id.name);
        textView.setText("朋友"+args[position]);
        return view;
    }
}