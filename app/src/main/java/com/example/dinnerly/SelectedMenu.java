package com.example.dinnerly;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SelectedMenu extends Fragment {

    ExpandableListView expandableListView;


    public SelectedMenu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_selected_menu, container, false);
        expandableListView = (ExpandableListView) view.findViewById(R.id.expandableListView);

        /*Intent intent = getIntent();
        int index = intent.getIntExtra("index", 0);
        String count = intent.getStringExtra("count");
        Bundle bundle = getIntent().getExtras();
        String selectedItems[] = bundle.getStringArray("selectedItems");
        */
        /*final List<String> heading = new ArrayList<>();
        heading.add("heading1");
        heading.add("heading 2");
        heading.add("heading 3");
        heading.add("heading 4");

        List<String> childList = new ArrayList<>();
        childList.add(selectedItems[index]);
        childList.add("item 2");

        HashMap<String,List<String>> children = new HashMap<>();
        for(String title:heading) {
            children.put(title,childList);
        }

        MyAdapter myAdapter = new MyAdapter(this,heading, children);
        expandableListView.setAdapter(myAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        heading.get(groupPosition) + " List Expanded.",
                        Toast.LENGTH_SHORT).show();
            }
        });
*/
        return view;
    }
/*

    void setListener() {

        // This listener will show toast on group click
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView listview, View view,
                                        int group_pos, long id) {

                Toast.makeText(MainActivity.this,
                        "You clicked",
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // This listener will expand one group at one time
        // You can remove this listener for expanding all groups
        expandableListView
                .setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

                    // Default position
                    int previousGroup = -1;

                    @Override
                    public void onGroupExpand(int groupPosition) {
                        if (groupPosition != previousGroup)

                            // Collapse the expanded group
                            expandableListView.collapseGroup(previousGroup);
                        previousGroup = groupPosition;
                    }});
    }

    @Override
    public void onClick(View v) {
        if(v== next){
            startActivity(new Intent(this,Filter.class));
        }
    }

*/

}
