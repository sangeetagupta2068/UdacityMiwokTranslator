package com.example.android.miwok;

/**
 * Created by sangeetagupta1998 on 6/7/18.
 */

public class Word {

    private String miwok;
    private String english;
    private int imageResourceId;
    private int songResourceId;

    public Word(String miwok, String english, int imageResourceId, int songResourceId) {

        this.miwok = miwok;
        this.english = english;
        this.imageResourceId = imageResourceId;
        this.songResourceId = songResourceId;

    }

    public Word(String miwok, String english, int songResourceId) {

        this.miwok = miwok;
        this.english = english;
        this.songResourceId = songResourceId;

    }

    public String getMiwokTranslation() {

        return miwok;
    }

    public String getDefaultTranslation() {

        return english;

    }

    public int getImageResourceId() {

        return imageResourceId;
    }

    public int getSongResourceId() {

        return songResourceId;
    }

}
