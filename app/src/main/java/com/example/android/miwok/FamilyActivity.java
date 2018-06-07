package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    ArrayList<Word> words;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        initialize();
        displayWords();
    }

    public void initialize(){

        words = new ArrayList<Word>();
        words.add(new Word("әpә","father"));
        words.add(new Word("әṭa","mother"));
        words.add(new Word("angsi","son"));
        words.add(new Word("tune","daughter"));
        words.add(new Word("taachi","older brother"));
        words.add(new Word("chalitti","younger sister"));
        words.add(new Word("tete","older sister"));
        words.add(new Word("kolliti","younger sister"));
        words.add(new Word("ama","grandmother"));
        words.add(new Word("papa","grandfather"));

    }

    public void displayWords(){

        WordAdapter wordAdapter = new WordAdapter(this,words);
        ListView listView = findViewById(R.id.familyView);
        listView.setAdapter(wordAdapter);

    }

}

