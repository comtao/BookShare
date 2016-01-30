package com.lt.book.global;

import android.app.Application;

/**
 * Created by tao.lai on 2016/1/30 0030.
 */
public class GlobalContext extends Application {
    private static final String TAG = "GlobalContext";

    private static GlobalContext gCtx;

    public static GlobalContext getInstance(){
        return gCtx;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        gCtx = this;
    }
}
