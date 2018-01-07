package com.example.android.booklisting;

/**
 * Created by hp2 on 07-01-2018.
 */

public class Book {

    private String mTitle;

    private String mAuthor;

    private String mUrl;

    private int mPageCount;


    public Book(String Title, String Author, String Url, int pageCount){
        mTitle = Title;
        mAuthor= Author;
        mUrl = Url;
        mPageCount = pageCount;

    }


    public String getTitle(){return mTitle;}

    public String getAuthor(){return mAuthor;}

    public String getUrl(){return mUrl;}

    public int getPageCount(){return mPageCount;}

}
