package com.example.android.miwok;

/**
 * Created by sangeetagupta1998 on 6/7/18.
 */

public class Word {

    private String miwok;
    private String english;
    private int imageResourceId;


    public Word(String miwok, String english, int imageResourceId){

        this.miwok = miwok;
        this.english = english;
        this.imageResourceId = imageResourceId;

    }

    public Word(String miwok, String english){

        this.miwok = miwok;
        this.english = english;

    }

    public String getMiwokTranslation(){

        return miwok;
    }

    public String getDefaultTranslation(){

        return english;

    }

    public int getImageResourceId() {
        return imageResourceId;
    }

}
