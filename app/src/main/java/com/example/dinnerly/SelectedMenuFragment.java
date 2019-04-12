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
public class SelectedMenuFragment extends Fragment {

    ExpandableListView expandableListView;
    String[] selectedItems;
    int[] ind;

    public SelectedMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_selected_menu, container, false);
        expandableListView = (ExpandableListView) view.findViewById(R.id.expandableListView);

        Bundle bundle = getArguments();
        if(bundle!=null) {
            selectedItems = bundle.getStringArray("selectedItems");
            ind = bundle.getIntArray("ind");
        }

        /*
        Intent intent = getIntent();
        int index = intent.getIntExtra("index", 0);
        String count = intent.getStringExtra("count");
        Bundle bundle = getIntent().getExtras();
        String selectedItems[] = bundle.getStringArray("selectedItems");
        */
        List<String> childList = new ArrayList<>();;
        final List<String> heading = new ArrayList<>();
        heading.add("AJ");
        /*heading.add("heading 2");
        heading.add("heading 3");
        heading.add("heading 4");*/

        if(ind != null) {
            for (int i = 0; i < ind.length; i++) {
                if (ind[i] > 0) {
                    childList.add(selectedItems[i]);
                }
            }
        }

        HashMap<String,List<String>> children = new HashMap<>();
        for(String title:heading) {
            children.put(title,childList);
        }

        MyAdapter myAdapter = new MyAdapter(getActivity(),heading, children);
        expandableListView.setAdapter(myAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getActivity(),
                        heading.get(groupPosition) + " List Expanded.",
                        Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }


    void setListener() {

        // This listener will show toast on group click
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView listview, View view,
                                        int group_pos, long id) {

                Toast.makeText(getActivity(),
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
}
