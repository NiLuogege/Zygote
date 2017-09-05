package com.tmholter.pediatrics.xhjdemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by ${LuoChen} on 2017/9/4 16:48.
 * email:luochen0519@foxmail.com
 */

public class MyApplication extends Application {

    private static Context mContext;


    @Override
    public void onCreate() {
        super.onCreate();
        this.mContext = this;

        //初始化 AndroidContext
        // Android context must be the first item initialized.
        AndroidContext.initialize(this);
    }

    public static Context getContext() {
        return mContext;
    }
}
