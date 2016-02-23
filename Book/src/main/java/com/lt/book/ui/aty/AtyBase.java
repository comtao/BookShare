package com.lt.book.ui.aty;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

/**
 * Created by tao.lai on 2016/1/30 0030.
 */
public class AtyBase extends FragmentActivity {
    private static final String TAG = "AtyBase";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Bmob.initialize(this, Configs.BOMB_APP_ID);
    }

    protected <T extends View> T generateFindViewById(int id) {
        return (T) findViewById(id);
    }
}
