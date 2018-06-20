package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    ArrayList<Word> words;
    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    AudioManager.OnAudioFocusChangeListener audioFocusChangeListener;
    MediaPlayer.OnCompletionListener completionListener;

    private void releaseMediaMemory() {

        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            audioManager.abandonAudioFocus(audioFocusChangeListener);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaMemory();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        initialize();
        displayWords();
    }

    public void initialize() {

        words = new ArrayList<>();
        words.add(new Word("weṭeṭṭi", "red", R.drawable.color_red, R.raw.color_red));
        words.add(new Word("chokokki", "green", R.drawable.color_green, R.raw.color_green));
        words.add(new Word("ṭakaakki", "brown", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word("ṭopoppi", "gray", R.drawable.color_gray, R.raw.color_gray));
        words.add(new Word("kululli", "black", R.drawable.color_black, R.raw.color_black));
        words.add(new Word("kelelli", "white", R.drawable.color_white, R.raw.color_white));
        words.add(new Word("ṭopiisә", "dusty yellow", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word("chiwiiṭә", "mustard yellow", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
            @Override
            public void onAudioFocusChange(int focusChange) {

                switch (focusChange) {

                    case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                        mediaPlayer.pause();
                    case AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK:
                        mediaPlayer.pause();
                    case AudioManager.AUDIOFOCUS_LOSS:
                        releaseMediaMemory();
                    case AudioManager.AUDIOFOCUS_GAIN:
                        mediaPlayer.start();
                }
            }
        };
        completionListener = new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                releaseMediaMemory();
            }
        };

    }

    public void displayWords() {

        WordAdapter wordAdapter = new WordAdapter(this, words, R.color.category_colors);
        ListView listView = findViewById(R.id.colorsView);
        listView.setAdapter(wordAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = (Word) words.get(position);
                int resultAudio = audioManager.requestAudioFocus(audioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (resultAudio == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    mediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getSongResourceId());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(completionListener);

                }
            }
        });

    }
}
