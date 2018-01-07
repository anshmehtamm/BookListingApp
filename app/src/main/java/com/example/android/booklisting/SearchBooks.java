package com.example.android.booklisting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SearchBooks extends AppCompatActivity {

    private static final String LOG_TAG = SearchBooks.class.getName();
    private static final String BOOKS_REQUEST_URL =
            "https://www.googleapis.com/books/v1/volumes?q=flowers&maxResults=10";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_books);
    }
}
