package com.example.android.booklisting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchBooks extends AppCompatActivity {

    private static final String LOG_TAG = SearchBooks.class.getName();
    private static final String BOOKS_REQUEST_URL =
            "https://www.googleapis.com/books/v1/volumes?q=flowers&maxResults=10";
    private TextView mEmptyStateTextView;

    private static BookAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_books);

        GridView booksGridView = (GridView) findViewById(R.id.card_view);
        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);

        booksGridView.setEmptyView(mEmptyStateTextView);

        mAdapter = new BookAdapter(this, new ArrayList<Book>());

        booksGridView.setAdapter(mAdapter);







    }
}
