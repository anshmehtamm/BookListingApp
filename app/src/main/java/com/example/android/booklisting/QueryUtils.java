package com.example.android.booklisting;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static android.R.attr.author;

/**
 * Created by hp2 on 07-01-2018.
 */


public class QueryUtils  {
    private static final String LOG_TAG = QueryUtils.class.getSimpleName();



    public static List<Book> fetchBookData(String requestUrl) {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Create URL object
        Log.i(LOG_TAG,"Test: fetchEarthquakeData() called");

        URL url = createUrl(requestUrl);

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }

        // Extract relevant fields from the JSON response and create a list of {@link Earthquake}s
        List<Book> books = extractBookFromJson(jsonResponse);

        // Return the list of {@link Earthquake}s
        return books;
    }

    /**
     * Returns new URL object from the given string URL.
     */
    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Problem building the URL ", e);
        }
        return url;
    }

    /**
     * Make an HTTP request to the given URL and return a String as the response.
     */
    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        // If the URL is null, then return early.
        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the earthquake JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                // Closing the input stream could throw an IOException, which is why
                // the makeHttpRequest(URL url) method signature specifies than an IOException
                // could be thrown.
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    /**
     * Convert the {@link InputStream} into a String which contains the
     * whole JSON response from the server.
     */
    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }




    private static List<Book> extractBookFromJson(String booksJson){

        if (TextUtils.isEmpty(booksJson)) {
            return null;
        }

        List<Book> books = new ArrayList<>();

        try {

            JSONObject baseJsonResponse = new JSONObject(booksJson);
            JSONArray booksArray = baseJsonResponse.getJSONArray("items");

            for(int i=0;i<booksArray.length();i++) {

                JSONObject currentBook = booksArray.getJSONObject(i);
                JSONObject volumeInfo = currentBook.getJSONObject("volumeInfo");
                String title = volumeInfo.getString("title");

                JSONArray bookAuthors = null;
                try {
                    bookAuthors = volumeInfo.getJSONArray("authors");
                } catch (JSONException ignored) {
                }
                // Convert the authors to a string
                String bookAuthorsString ;
                // If the author is empty, set it as "Unknown"
                if (bookAuthors == null) {
                    bookAuthorsString = "Unknown";
                } else {
                    // Format the authors as "author1, author2, and author3"
                    int countAuthors = bookAuthors.length();
                    bookAuthorsString = "";
                    for (int e = 0; e < countAuthors; e++) {
                        String author = bookAuthors.getString(e);
                        if (bookAuthorsString.isEmpty()) {
                            bookAuthorsString = author;
                        } else if (e == countAuthors - 1) {
                            bookAuthorsString = bookAuthorsString + " and " + author;
                        } else {
                            bookAuthorsString = bookAuthorsString + ", " + author;
                        }
                    }


                    int pageCount = volumeInfo.getInt("pageCount");
                    String url = volumeInfo.getString("infoLink");

                    JSONObject imageLinks = volumeInfo.getJSONObject("imageLinks");
                    String thumbnailUrl = imageLinks.getString("smallThumbnail");

                    Bitmap bitmap = ImageDownloader.fetchImage(thumbnailUrl);



                    Book book = new Book(title, bookAuthorsString, url, pageCount,bitmap);

                    books.add(book);
                }


            }
        }catch (JSONException e){
            Log.e("QueryUtils","Problem parsing JSON",e);
        }



        return books;
    }





}
