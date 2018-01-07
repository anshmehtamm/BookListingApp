package com.example.android.booklisting;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by hp2 on 07-01-2018.
 */

public class BookAdapter extends ArrayAdapter<Book> {

    public BookAdapter(Context context, List<Book> earthquakes) {
        super(context, 0, earthquakes);
    }







}
