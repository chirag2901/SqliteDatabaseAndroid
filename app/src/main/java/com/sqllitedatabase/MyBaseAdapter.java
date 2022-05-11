package com.sqllitedatabase;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyBaseAdapter extends BaseAdapter {
    Context context;
    ArrayList<DetailModel> detailModelsArrayList;
    public MyBaseAdapter(Context context,ArrayList<DetailModel> detailModelsArrayList){
        this.context = context;
        this.detailModelsArrayList = detailModelsArrayList;
    }

    @Override
    public int getCount() {
        return detailModelsArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return detailModelsArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.raw_list,null);
        final DetailModel detailModel = (DetailModel)getItem(position);

        TextView tv_data = (TextView) convertView.findViewById(R.id.tv_data);
        tv_data.setText(detailModelsArrayList.get(position).getId()+
                " "+ detailModelsArrayList.get(position).getFirstName()+" "+
                detailModelsArrayList.get(position).getLastName());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strfn = detailModelsArrayList.get(position).getFirstName();
                String strln = detailModelsArrayList.get(position).getLastName();
                String strid = detailModelsArrayList.get(position).getId();

                Intent i = new Intent(context,UpdateActivity.class);
                i.putExtra("FN_KEY",strfn);
                i.putExtra("LN_KEY",strln);
                i.putExtra("ID_KEY",strid);
                context.startActivity(i);

            }
        });
        return convertView;
    }
}
