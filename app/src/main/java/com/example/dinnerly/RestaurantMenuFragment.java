package com.example.dinnerly;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantMenuFragment extends Fragment {

    int n=1;
    int i=1;
    String[] selectedItems= new String[70];
    int catpsn=0;
    String cat[] = new String[70];
    int ind[] = new int[70];
    int sh[] = new int[70];
    ListView listView1, listView2;
    OnMessageSendListener onMessageSendListener;


    public interface OnMessageSendListener{
        public void onMessageSend(int[] ind, String[] selectedItems);

    }

    public RestaurantMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_restaurant_menu, container, false);
        listView1 = (ListView) view.findViewById(R.id.list1);
        listView2 = (ListView) view.findViewById(R.id.list2);

        String[] categories = {"Drinks","Starters","Chinese","Indian","Breads","Deserts"};
        ListAdapter adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,categories);
        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String category= String.valueOf(parent.getItemAtPosition(position));

                if(position==0){
                    String[] Dishes = {"1Dish1   Rs.100","1Dish2   Rs.100","1Dish3   Rs.100","1Dish4   Rs.100",
                            "1Dish5   Rs.100","1Dish6   Rs.100"};
                    catpsn=position;
                    ListAdapter adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,Dishes);
                    listView2.setAdapter(adapter);

                }

                if(position==1){
                    String[] Dishes = {"2Dish1   Rs.200","2Dish2   Rs.200","2Dish3   Rs.200","2Dish4   Rs.200",
                            "2Dish5   Rs.200","2Dish6   Rs.200"};
                    catpsn=position;
                    ListAdapter adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,Dishes);
                    listView2.setAdapter(adapter);


                }
                if(position==3){
                    String[] Dishes = {"4Dish1   Rs.100","4Dish2   Rs.100","4Dish3   Rs.100","4Dish4   Rs.100",
                            "4Dish5   Rs.100","4Dish6   Rs.100"};
                    catpsn=position;
                    ListAdapter adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,Dishes);
                    listView2.setAdapter(adapter);

                }
                if(position==4){
                    String[] Dishes = {"5Dish1   Rs.100","5Dish2   Rs.100","5Dish3   Rs.100","5Dish4   Rs.100",
                            "5Dish5   Rs.100","5Dish6   Rs.100","5Dish7   Rs.100","5Dish8   Rs.100","5Dish9   Rs.100","5Dish10   Rs.100"};
                    catpsn=position;
                    ListAdapter adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,Dishes);
                    listView2.setAdapter(adapter);

                }
                if(position==5){
                    String[] Dishes = {"6Dish1   Rs.300","6Dish2   Rs.300","6Dish3   Rs.300","6Dish4   Rs.300",
                            "6Dish5   Rs.300","6Dish6   Rs.300","6Dish7   Rs.300","6Dish8   Rs.300","6Dish9   Rs.300","6Dish10   Rs.300"};
                    catpsn=position;
                    ListAdapter adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,Dishes);
                    listView2.setAdapter(adapter);

                }
                if(position==2){
                    String[] Dishes = {"3Dish1   Rs.100","3Dish2   Rs.100","3Dish3   Rs.100","3Dish4   Rs.100",
                            "3Dish5   Rs.100","3Dish6   Rs.100","3Dish7   Rs.100","3Dish8   Rs.100","3Dish9   Rs.100","3Dish10   Rs.100"};
                    catpsn=position;
                    ListAdapter adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,Dishes);
                    listView2.setAdapter(adapter);

                }

            }
        });
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int result= (catpsn*10) + position;
               // Log.i(TAG,"hello"+result);
                Toast toast=Toast.makeText(getContext(),listView2.getItemAtPosition(position)+" added",Toast.LENGTH_SHORT);
                toast.show();
                String s=(String)listView2.getItemAtPosition(position);
                setItems(s,result);
            }
        });

        return  view;
    }

    public void setItems(String s, int r)
    {


        if (!(Arrays.asList(selectedItems).contains(s))) {

            //Log.i(TAG,"okay");
            selectedItems[r]= s;
            //Log.i(TAG, "arr: " + Arrays.deepToString(selectedItems));
            ind[r]= 1;
            //Log.i(TAG, "arrInd: " +Arrays.toString(ind));
            onMessageSendListener.onMessageSend(ind, selectedItems);

            /*intent.putExtras(bundle);
            intent.putExtra("index",r);
            startActivity(intent);*/
        }
        else
        {
            ind[r]=ind[r]+1;
            //Log.i(TAG, "arrInd: " +Arrays.toString(ind));
            onMessageSendListener.onMessageSend(ind, selectedItems);
/*
            Intent intent= new Intent(getActivity(), SelectedMenuFragment.class);
            intent.putExtra("count",ind);
            startActivity(intent);*/
        }


    }

    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;

        try {
            onMessageSendListener = (OnMessageSendListener) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+" must implement onMessaageSend");
        }
    }



}
