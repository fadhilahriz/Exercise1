package com.example.exer1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class AdapterList extends BaseAdapter {
    Context mContext;
    LayoutInflater inflater;
    private ArrayList<ClassNama> arrayList;

    public AdapterList(Context context){
        mContext = context;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<ClassNama>();
        this.arrayList.addAll(ActivityKontak.classNamaArrayList);
    }

    public class  ViewHolder{
        TextView nama;
    }

    @Override
    public int getCount() {
        return ActivityKontak.classNamaArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return ActivityKontak.classNamaArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.item_listview, null);
            holder.nama = (TextView) view.findViewById(R.id.tvnama_item);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.nama.setText(ActivityKontak.classNamaArrayList.get(i).getNama());
        return view;
    }

    public void filterSearch(String Text) {
        ActivityKontak.classNamaArrayList.clear();
        if (Text.isEmpty()) {
            ActivityKontak.classNamaArrayList.addAll(arrayList);
        } else {
            Text = Text.toLowerCase();
            for (ClassNama cn : arrayList){
                if (cn.getNama().toLowerCase().contains(Text)){
                    ActivityKontak.classNamaArrayList.add(cn);
                }
            }
        }
        notifyDataSetChanged();
    }
}
