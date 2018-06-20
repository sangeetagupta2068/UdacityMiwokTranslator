package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sangeetagupta1998 on 6/7/18.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    int colorId;
    //int songId;

    public WordAdapter(@NonNull Context context, ArrayList<Word> words, int colorId) {
        super(context, 0, words);
        this.colorId = colorId;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        int color = ContextCompat.getColor(getContext(), colorId);


        if (listItemView == null) {

            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

        }

        Word word = (Word) getItem(position);

        LinearLayout linearLayout = (LinearLayout) listItemView.findViewById(R.id.background_view);
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        nameTextView.setText(word.getMiwokTranslation());


        TextView numberTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        numberTextView.setText(word.getDefaultTranslation());

        ImageView imageView = listItemView.findViewById(R.id.imageView);

        if (word.getImageResourceId() == 0) {

            imageView.setVisibility(View.GONE);

        } else {
            imageView.setImageResource(word.getImageResourceId());

        }

        nameTextView.setBackgroundColor(color);
        linearLayout.setBackgroundColor(color);
        numberTextView.setBackgroundColor(color);

        return listItemView;
    }
}
