package com.example.dinnerly;

public class DataModel {
    public static final String RESTAURANT_DETAILS_VIEW_TYPE ="RESTAURANT_DETAILS";
    public static final String RESTAURANT_MENU_VIEW_TYPE ="RESTAURANT_MENU";
    public static final String SELECTED_MENU_VIEW_TYPE="SELECTED_MENU";

    String text;
    String viewType;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getViewType() {
        return viewType;
    }

    public void setViewType(String viewType) {
        this.viewType = viewType;
    }
}
