package com.example.mirimiter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class OtherMSGAdapter extends BaseAdapter {
    Context context;
    ArrayList<OtherMSG> other_item = new ArrayList<OtherMSG>();

    @Override
    public int getCount() {
        return other_item.size();
    }

    @Override
    public Object getItem(int position) {
        return other_item.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        context = parent.getContext();
        OtherMSG other_msg = other_item.get(position);

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.other_msgbox, parent, false);
        }

        TextView otherMSG = convertView.findViewById(R.id.otherMSG);

        otherMSG.setText(other_msg.getOthermsg());

        return convertView;
    }

    public void addOtherMSG(OtherMSG msg){
        other_item.add(msg);
    }
}
