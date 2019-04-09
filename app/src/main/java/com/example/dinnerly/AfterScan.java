package com.example.dinnerly;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AfterScan extends AppCompatActivity {
    List<DataModel> dataModels=new ArrayList<>();
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_scan);

        recyclerView=findViewById(R.id.recyclerView);
        EnterValuesInList();

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        //RecyclerViewAdapter recyclerViewAdapter=new RecyclerViewAdapter(dataModels);
        //recyclerView.setAdapter(recyclerViewAdapter);


    }

    private void EnterValuesInList() {
        DataModel dataModel = new DataModel();

        dataModel.setText("");
        dataModel.setViewType(DataModel.RESTRAUNT_DETAILS_VIEW_TYPE);
        dataModels.add(dataModel);
        dataModel = new DataModel();

        dataModel.setText("");
        dataModel.setViewType(DataModel.RESTRAUNT_MENU_VIEW_TYPE);
        dataModels.add(dataModel);
        dataModel = new DataModel();

        dataModel.setText("");
        dataModel.setViewType(DataModel.SELECTED_MENU_VIEW_TYPE);
        dataModels.add(dataModel);
    }
}
