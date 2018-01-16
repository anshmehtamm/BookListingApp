package com.example.android.booklisting;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hp2 on 16-01-2018.
 */

public class SearchableActivity  extends ActionBarActivity {

        private static String BOOKS_REQUEST_URL =
            "https://www.googleapis.com/books/v1/volumes?maxResults=10&q=";
    private TextView mEmptyStateTextView;
    private static String searchQuery = "";
    private static BookAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            doMySearch(query);
        }

    }

    private void doMySearch(String query){


        GridView booksGridView = (GridView) findViewById(R.id.gv);

        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
        mEmptyStateTextView.setText(R.string.search_book);

        booksGridView.setEmptyView(mEmptyStateTextView);

        mAdapter = new BookAdapter(this, new ArrayList<Book>());

        booksGridView.setAdapter(mAdapter);
    }



}
