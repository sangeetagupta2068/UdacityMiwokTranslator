package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    ArrayList<Word> words;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        initialize();
        displayWords();
    }

    public void initialize(){

        words = new ArrayList<Word>();
        words.add(new Word("weṭeṭṭi","red"));
        words.add(new Word("chokokki","green"));
        words.add(new Word("ṭakaakki","brown"));
        words.add(new Word("ṭopoppi","gray"));
        words.add(new Word("kululli","black"));
        words.add(new Word("kelelli","white"));
        words.add(new Word("ṭopiisә","dusty yellow"));
        words.add(new Word("chiwiiṭә","mustard yellow"));

    }

    public void displayWords(){

        WordAdapter wordAdapter = new WordAdapter(this, words);
        ListView listView = findViewById(R.id.colorsView);
        listView.setAdapter(wordAdapter);
    }
}
