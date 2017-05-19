package com.example.emaar.customloader;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Post>> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLoader(0, null, this, getSupportLoaderManager());
    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        return new MyLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<List<Post>> loader, List<Post> data) {
        Log.i("onLoadFinished:::::::", "");
        if (data!=null)
        Log.i("On khallas:::::::", data.size()+"");
    }

    @Override
    public void onLoaderReset(Loader loader) {

    }

    public static <T> void initLoader(final int loaderId, final Bundle args, final LoaderManager.LoaderCallbacks<List<Post>> callbacks,
                                      final LoaderManager loaderManager) {
        final Loader<T> loader = loaderManager.getLoader(loaderId);
        if (loader != null && loader.isReset()) {
            loaderManager.restartLoader(loaderId, args, callbacks).forceLoad();
        } else {
            loaderManager.initLoader(loaderId, args, callbacks).forceLoad();
        }
    }
}
