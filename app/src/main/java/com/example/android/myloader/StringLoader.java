package com.example.android.myloader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Suleman Shakil on 22.07.2015.
 */
public class StringLoader extends AsyncTaskLoader<List<String>> {

    private List<String> cached;

    public StringLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        if(cached==null){
            forceLoad();
        }else {
            deliverResult(cached);
        }
    }

    @Override
    public List<String> loadInBackground() {
       List<String> data = (Arrays.asList(getContext().getResources().getStringArray(R.array.items)));
        return data;
    }

    @Override
    public void deliverResult(List<String> data) {
        cached = data;
        super.deliverResult(data);
    }
}
