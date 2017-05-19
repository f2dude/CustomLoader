package com.example.emaar.customloader;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * Created by emaar on 5/8/17.
 */

public class MyLoader extends android.support.v4.content.AsyncTaskLoader<List<Post>> {

    private List<Post> posts;

    public MyLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        if (takeContentChanged())
            forceLoad();
    }

    @Override
    protected void onStopLoading() {
        cancelLoad();
    }

    @Override
    public List<Post> loadInBackground() {

        Log.e("loadInBackground:::::::", "Testing.....");
        MyInterface taskService = ServiceGenerator.createService(MyInterface.class);
        Call<List<Post>> call = taskService.getPosts();

//        List<Post> tasks;
        try {
            posts = call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return posts;
    }

    @Override
    public void deliverResult(List<Post> data) {
        super.deliverResult(data);
    }
}
