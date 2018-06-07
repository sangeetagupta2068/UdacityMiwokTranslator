package com.example.android.miwok;

/**
 * Created by sangeetagupta1998 on 6/7/18.
 */

public class Word {

    String miwok;
    String english;

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
}
