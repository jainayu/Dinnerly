package com.example.dinnerly;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class MyAdapter extends BaseExpandableListAdapter {


    public List<String> header_list;
    private HashMap<String, List<String>> child_List;
    private Context ctx;

    MyAdapter(Context ctx, List<String> header_list, HashMap<String, List<String>> child_List){
        this.ctx=ctx;
        this.header_list=header_list;
        this.child_List=child_List;
    }
    @Override
    public int getGroupCount() {
        return header_list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        Log.i("adapter",child_List.get(header_list.get(groupPosition)).size()+"");
        return child_List.get(header_list.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return header_list.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return child_List.get(header_list.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String Title = (String)this.getGroup(groupPosition);
        if(convertView == null){
            LayoutInflater layoutInflater =(LayoutInflater) this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.parent_layout,null);
        }
        TextView textView =(TextView) convertView.findViewById(R.id.Menu);
        textView.setText(Title);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String Title = (String)this.getChild(groupPosition,childPosition);
        if(convertView == null){
            LayoutInflater layoutInflater =(LayoutInflater) this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.child_layout,null);
        }
        TextView textView =(TextView) convertView.findViewById(R.id.child_items);
        textView.setText(Title);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
