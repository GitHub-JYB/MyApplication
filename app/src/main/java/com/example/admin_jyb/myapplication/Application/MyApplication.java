package com.example.admin_jyb.myapplication.Application;

import android.app.Application;

/**
 * Created by Admin-JYB on 2017/4/11.
 */

public class MyApplication extends Application {

    protected static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static MyApplication getInstance(){
        return instance;
    }
}
