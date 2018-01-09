package com.example.android.booklisting;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import java.util.List;

/**
 * Created by hp2 on 09-01-2018.
 */

public class ImageLoader extends AsyncTaskLoader<Bitmap> {

    private static String mThumbnailUrl;

    public ImageLoader(Context context, String thumbnailUrl){
        super(context);
        mThumbnailUrl = thumbnailUrl;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public Bitmap loadInBackground(){
        if (mThumbnailUrl == null) {
            return null;
        }
        Bitmap bitmap = ImageDownloader.fetchImage(mThumbnailUrl);
        return bitmap;

    }
}
