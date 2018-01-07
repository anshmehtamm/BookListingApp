package com.example.android.booklisting;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.author;

/**
 * Created by hp2 on 07-01-2018.
 */

public class QueryUtils  {

    private static List<Book> extractBookFromJson(String booksJson){

        if (TextUtils.isEmpty(booksJson)) {
            return null;
        }

        List<Book> books = new ArrayList<>();

        try {

            JSONObject baseJsonResponse = new JSONObject(booksJson);
            JSONArray booksArray = baseJsonResponse.getJSONArray("items");

            for(int i=0;i<booksArray.length();i++){

                JSONObject currentBook = booksArray.getJSONObject(i);
                JSONObject volumeInfo = currentBook.getJSONObject("volumeInfo");
                JSONArray authorsArray = currentBook.getJSONArray("authors");
                String authora = "";

                for(int j=0;j<authorsArray.length();j++){
                    authora = authorsArray.getString(j);
                    // TODO: Parse for more Authors and append into one string
                }

                String title = volumeInfo.getString("title");
                int pageCount = volumeInfo.getInt("pageCount");
                String url = volumeInfo.getString("infoLink");

                Book book =  new Book(title,authora,url,pageCount);

                books.add(book);
            }



        }catch (JSONException e){
            Log.e("QueryUtils","Problem parsing JSON",e);
        }



        return books;
    }



}
