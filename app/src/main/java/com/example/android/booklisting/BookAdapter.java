package com.example.android.booklisting;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static android.R.attr.bitmap;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * Created by hp2 on 07-01-2018.
 */

public class BookAdapter extends ArrayAdapter<Book>    {



    public BookAdapter(Context context, List<Book> earthquakes) {
        super(context, 0, earthquakes);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.card_layout, parent, false);
        }

        Book currentBook = getItem(position);

        TextView titleView = (TextView) listItemView.findViewById(R.id.item_title);
        TextView authorView = (TextView) listItemView.findViewById(R.id.item_detail);
        TextView pageCountView = (TextView) listItemView.findViewById(R.id.cost_book);

       String ti = currentBook.getTitle();
        int c = currentBook.getPageCount();
        String a = currentBook.getAuthor();

        titleView.setText(ti);
        authorView.setText(a);
          pageCountView.setText(""+c);

        Bitmap bit = currentBook.getBitmap();

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.item_image);

        imageView.setImageBitmap(bit);







        return listItemView;
    }


}