package com.example.bichuynitint;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class QuocGiaAdapter extends BaseAdapter {

    Context context;
    int mylayout;
    List<QuocGia> quocGiaList;

    public QuocGiaAdapter(Context context, int mylayout, List<QuocGia> quocGiaList) {
        this.context = context;
        this.mylayout = mylayout;
        this.quocGiaList = quocGiaList;
    }

    @Override
    public int getCount() {
        return quocGiaList.size();
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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(mylayout,null);

        ImageView hinh = (ImageView) convertView.findViewById(R.id.imghinh);
        TextView ten = (TextView) convertView.findViewById(R.id.tvten);

        QuocGia qg =  quocGiaList.get(position);
        ten.setText(qg.getTen());
        hinh.setImageResource(qg.getHinh());

        return convertView;
    }
}
