package com.woow.appwoowsouq.data.model;

public class ScreenItem {

    String Title,Description;
    int ScreenImg;

    public ScreenItem( String description, int screenImg) {
        Description = description;
        ScreenImg = screenImg;
    }


    public void setDescription(String description) {
        Description = description;
    }

    public void setScreenImg(int screenImg) {
        ScreenImg = screenImg;
    }


    public String getDescription() {
        return Description;
    }

    public int getScreenImg() {
        return ScreenImg;
    }
}
