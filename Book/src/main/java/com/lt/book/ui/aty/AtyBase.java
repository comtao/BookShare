package com.lt.book.ui.aty;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.lt.book.global.Configs;

import cn.bmob.v3.Bmob;
import de.greenrobot.event.EventBus;

/**
 * Created by tao.lai on 2016/1/30 0030.
 */
public class AtyBase extends FragmentActivity {
    private static final String TAG = "AtyBase";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this, Configs.BOMB_APP_ID);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public Bundle getBundle() {
        if (getIntent() != null && getIntent().hasExtra(getPackageName()))
            return getIntent().getBundleExtra(getPackageName());
        else
            return null;
    }

    public void onEvent(Boolean empty){

    }


    protected <T extends View> T generateFindViewById(int id) {
        return (T) findViewById(id);
    }
}
