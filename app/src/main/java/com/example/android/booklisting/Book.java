package com.example.android.booklisting;

import android.graphics.Bitmap;

/**
 * Created by hp2 on 07-01-2018.
 */

public class Book {

    private String mTitle;

    private String mAuthor;

    private String mUrl;

    private int mPageCount;

    private Bitmap mBitmap;




    public Book(String Title, String Author, String Url, int pageCount, Bitmap bitmap){
        mTitle = Title;
        mAuthor= Author;
        mUrl = Url;
        mPageCount = pageCount;
        mBitmap = bitmap;


    }


    public String getTitle(){return mTitle;}

    public String getAuthor(){return mAuthor;}

    public String getUrl(){return mUrl;}

    public int getPageCount(){return mPageCount;}

    public Bitmap getBitmap(){return mBitmap;}



}
