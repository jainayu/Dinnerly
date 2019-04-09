package com.example.dinnerly;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class AfterScanRVAdaptor extends RecyclerView {
    List<DataModel> dataModels;
    static final int RESTAURANT_DETAILS_VIEW_TYPE = 0;
    static final int RESTAURANT_MENU_VIEW_TYPE = 1;
    static final int SELECTED_MENU_VIEW_TYPE = 2;

    public AfterScanRVAdaptor(@NonNull Context context,
                              List<DataModel> dataModels) {
        super(context);
        this.dataModels=dataModels;

    }
    class RestaurantDetailsViewHolder extends RecyclerView.ViewHolder{
        public RestaurantDetailsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    class RestaurantMenuViewHolder extends RecyclerView.ViewHolder{
        public RestaurantMenuViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    class SelectedMenuViewHolder extends RecyclerView.ViewHolder{
        public SelectedMenuViewHolder (@NonNull View itemView) {
            super(itemView);
        }
    }

    @NonNull
   //@Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view;
        switch (viewType){
            case RESTAURANT_DETAILS_VIEW_TYPE:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_home, viewGroup, false);
                return new RestaurantDetailsViewHolder(view);
            case RESTAURANT_MENU_VIEW_TYPE:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_home, viewGroup, false);
                return new RestaurantMenuViewHolder(view) ;
            case SELECTED_MENU_VIEW_TYPE:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_home, viewGroup, false);
                return new SelectedMenuViewHolder(view) ;
            default:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_home, viewGroup, false);
                return new SelectedMenuViewHolder(view) ;
        }
    }

    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        switch (dataModels.get(position).getViewType()) {
            case DataModel.RESTAURANT_DETAILS_VIEW_TYPE:
                RestaurantDetailsViewHolder restaurantDetailsViewHolder =(RestaurantDetailsViewHolder) viewHolder;
                //headerViewHolder.textView.setText(dataModels.get(position).getText());
                break;
            case DataModel.RESTAURANT_MENU_VIEW_TYPE:
                RestaurantMenuViewHolder restaurantMenuViewHolder =(RestaurantMenuViewHolder) viewHolder;
                //subHeaderViewHolder.textView.setText(dataModels.get(position).getText());
                break;
            case DataModel.SELECTED_MENU_VIEW_TYPE:
                SelectedMenuViewHolder selectedMenuViewHolder =(SelectedMenuViewHolder) viewHolder;
                //subHeaderViewHolder.textView.setText(dataModels.get(position).getText());
                break;
        }

    }

    public int getItemCount() {
        return dataModels.size();
    }


    public int getItemViewType(int position) {
        if(dataModels.get(position).getViewType().equals(DataModel.RESTAURANT_DETAILS_VIEW_TYPE)){
            return RESTAURANT_DETAILS_VIEW_TYPE;
        }
        if(dataModels.get(position).getViewType().equals(DataModel.RESTAURANT_MENU_VIEW_TYPE)){
            return RESTAURANT_MENU_VIEW_TYPE;
        }
        if(dataModels.get(position).getViewType().equals(DataModel.SELECTED_MENU_VIEW_TYPE)){
            return SELECTED_MENU_VIEW_TYPE;
        }
        else {
            return SELECTED_MENU_VIEW_TYPE;
        }
    }
}
