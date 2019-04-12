package com.example.dinnerly;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
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
public class RestaurantMenu extends Fragment {
    int n=1;
    int i=1;
    String[] selectedItems= new String[70];
    int catpsn=0;
    String cat[] = new String[70];
    int ind[] = new int[70];
    int sh[] = new int[70];
    ListView listView1, listView2;

    public RestaurantMenu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_restaurant_menu, container, false);
        listView1 = (ListView) view.findViewById(R.id.list1);
        listView2 = (ListView) view.findViewById(R.id.list2);

        String[] categories = {"Category1","Category2","Category3","Category4","Category5","Category6"};
        ListAdapter adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,categories);
        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String category= String.valueOf(parent.getItemAtPosition(position));

                if(position==0){
                    String[] Dishes = {"1.Dish1","1.Dish2","1.Dish3","1.Dish4",
                            "1.Dish5","1.Dish6"};
                    catpsn=position;
                    ListAdapter adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,Dishes);
                    listView2.setAdapter(adapter);

                }

                if(position==1){
                    String[] Dishes = {"2.Dish1","2.Dish2","2.Dish3","2.Dish4",
                            "2.Dish5","2.Dish6","2.Dish7"};
                    catpsn=position;
                    ListAdapter adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,Dishes);
                    listView2.setAdapter(adapter);


                }
                if(position==3){
                    String[] Dishes = {"4.Dish1","4.Dish2","4.Dish3","4.Dish4",
                            "4.Dish5","4.Dish6"};
                    catpsn=position;
                    ListAdapter adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,Dishes);
                    listView2.setAdapter(adapter);

                }
                if(position==4){
                    String[] Dishes = {"5.Dish1","5.Dish2","5.Dish3","5.Dish4",
                            "5.Dish5","5.Dish6","5.Dish7","5.Dish8","5.Dish9","5.Dish10"};
                    catpsn=position;
                    ListAdapter adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,Dishes);
                    listView2.setAdapter(adapter);

                }
                if(position==5){
                    String[] Dishes = {"6.Dish1","6.Dish2","6.Dish3","6.Dish4",
                            "6.Dish5"};
                    catpsn=position;
                    ListAdapter adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,Dishes);
                    listView2.setAdapter(adapter);

                }
                if(position==2){
                    String[] Dishes = {"3.Dish1","3.Dish2","3.Dish3","3.Dish4",
                            "3.Dish5","3.Dish6","3.Dish7","3.Dish8"};
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
            Intent intent= new Intent(getActivity(),SelectedMenu.class);
            Bundle bundle = new Bundle();
            bundle.putStringArray("selectedItems", selectedItems);
            intent.putExtras(bundle);
            intent.putExtra("index",r);
            startActivity(intent);
        }
        else
        {
            ind[r]=ind[r]+1;
            //Log.i(TAG, "arrInd: " +Arrays.toString(ind));
            Intent intent= new Intent(getActivity(),SelectedMenu.class);
            intent.putExtra("count",ind);
            startActivity(intent);
        }


    }


}
