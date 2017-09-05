package com.tmholter.pediatrics.xhjdemo;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Initializable singleton for providing the application level context
 * object instead of initializing each singleton separately.
 *
 *可用于提供应用程序级别上下文的初始化单例
 *对象而不是单独初始化每个单例
 *
 *需要在Application中进行初始化
 */
public class AndroidContext {
    private static AndroidContext sInstance;

    /**
     * The android context object cannot be created until the android
     * has created the application object. The AndroidContext object
     * must be initialized before other singletons can use it.
     */
    public static void initialize(@NonNull Context context) {
        if (sInstance == null) {
            sInstance = new AndroidContext(context);
        }
    }

    /**
     * Return a previously initialized instance, throw if it has not been
     * initialized yet.
     */
    public static AndroidContext instance() {
        if (sInstance == null) {
            throw new IllegalStateException("Android context was not initialized.");
        }
        return sInstance;
    }

    private final Context mContext;
    private AndroidContext(Context context) {
        mContext = context;
    }

    public Context get() {
        return mContext;
    }
}