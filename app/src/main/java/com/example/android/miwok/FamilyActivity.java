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

public class FamilyActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_family);
        initialize();
        displayWords();
    }

    public void initialize() {

        words = new ArrayList<Word>();
        words.add(new Word("әpә", "father", R.drawable.family_father, R.raw.family_father));
        words.add(new Word("әṭa", "mother", R.drawable.family_mother, R.raw.family_mother));
        words.add(new Word("angsi", "son", R.drawable.family_son, R.raw.family_son));
        words.add(new Word("tune", "daughter", R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Word("taachi", "older brother", R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new Word("chalitti", "younger brother", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new Word("tete", "older sister", R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new Word("kolliti", "younger sister", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new Word("ama", "grandmother", R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new Word("papa", "grandfather", R.drawable.family_grandfather, R.raw.family_grandfather));

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

        WordAdapter wordAdapter = new WordAdapter(this, words, R.color.category_family);
        ListView listView = findViewById(R.id.familyView);
        listView.setAdapter(wordAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaMemory();
                Word word = (Word) words.get(position);
                int resultAudio = audioManager.requestAudioFocus(audioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (resultAudio == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    mediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getSongResourceId());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(completionListener);

                }

            }
        });

    }

}

