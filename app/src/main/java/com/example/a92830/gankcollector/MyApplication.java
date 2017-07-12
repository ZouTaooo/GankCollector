package com.example.a92830.gankcollector;

import android.app.Application;
import android.content.Context;

import org.litepal.LitePal;

/**
 * Created by 92830 on 2017/7/11.
 */

public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        LitePal.initialize(this);
    }

    public static Context getContext() {
        return context;
    }
}
