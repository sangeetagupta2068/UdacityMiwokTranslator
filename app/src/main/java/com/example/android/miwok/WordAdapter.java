package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sangeetagupta1998 on 6/7/18.
 */

public class WordAdapter extends ArrayAdapter<Word>{

    public WordAdapter(@NonNull Context context, ArrayList<Word> words) {
        super(context, 0,words);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null) {

            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

        }

        Word word = (Word) getItem(position);


        TextView nameTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        nameTextView.setText(word.getMiwokTranslation());


        TextView numberTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        numberTextView.setText(word.getDefaultTranslation());

        return listItemView;
    }
}
