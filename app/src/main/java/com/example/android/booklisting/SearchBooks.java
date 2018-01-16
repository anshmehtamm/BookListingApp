package com.example.android.booklisting;

import android.app.LoaderManager;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.app.LoaderManager.LoaderCallbacks;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SearchBooks extends AppCompatActivity {

    private static final String LOG_TAG = SearchBooks.class.getName();
//    private static String BOOKS_REQUEST_URL =
//            "https://www.googleapis.com/books/v1/volumes?maxResults=10&q=";
//    private TextView mEmptyStateTextView;
//    private static String searchQuery = "";
//    private static BookAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_books);






    }

    @Override
    public boolean onSearchRequested() {
        return super.onSearchRequested();
    }}
//        @Override
//        public Loader<List<Book>> onCreateLoader ( int id, Bundle args){
//            Log.i(LOG_TAG, "Test: OnCreateLoader() called");
//            return new BookLoader(this, searchQuery);
//
//        }
//
//        @Override
//        public void onLoadFinished (Loader < List < Book >> loader, List < Book > books){
//            // TODO: Update the UI with the result
//            View loadingIndicator = findViewById(R.id.loading_indicator);
//            loadingIndicator.setVisibility(View.GONE);
//
//            mEmptyStateTextView.setText(R.string.no_book);
//            mAdapter.clear();
//            Log.i(LOG_TAG, "Test: OnLoadFinished() called");
//            // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
//            // data set. This will trigger the ListView to update.
//            if (books != null && !books.isEmpty()) {
//                mAdapter.addAll(books);
//            }
//
//
//        }
//
//        @Override
//        public void onLoaderReset (Loader < List < Book >> loader) {
//            // TODO: Loader reset, so we can clear out our existing data.
//            mAdapter.clear();
//            Log.i(LOG_TAG, "Test: OnLoaderReset() called");
//        }
//
//    public void doMySearch(String query) {
//        setContentView(R.layout.activity_search_books);
//        searchQuery += query.replaceAll(" ", "+");
//        if (null != searchQuery && !searchQuery.equals("")) {
//
//            String searchString = BOOKS_REQUEST_URL + searchQuery;
//
//
//            ConnectivityManager cm = (ConnectivityManager)
//                    getSystemService(Context.CONNECTIVITY_SERVICE);
//            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
//            boolean isConnected = activeNetwork != null &&
//                    activeNetwork.isConnectedOrConnecting();
//            // Get details on the currently active default data networkNetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
//            LoaderManager loaderManager = getLoaderManager();
//            Log.i(LOG_TAG, "Test: Calling initLoader()");
//
//            if (isConnected) {
//                loaderManager.initLoader(1, null, this);
//            } else {
//                View loadingIndicator = findViewById(R.id.loading_indicator);
//                loadingIndicator.setVisibility(View.GONE);
//                mEmptyStateTextView.setText(R.string.no_internet_connection);
//            }
//        }
//
//
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        // Inflate menu to add items to action bar if it is present.
//        inflater.inflate(R.menu.menu_search, menu);
//        // Associate searchable configuration with the SearchView
//        SearchManager searchManager =
//                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        SearchView searchView =
//                (SearchView) menu.findItem(R.id.menuSearch).getActionView();
//        searchView.setSearchableInfo(
//                searchManager.getSearchableInfo(getComponentName()));
//
//        return true;
//    }
//
//    public void queryRec(String query) {
//        doMySearch(query);
//    }






