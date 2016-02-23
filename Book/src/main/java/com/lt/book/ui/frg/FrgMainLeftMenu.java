package com.lt.book.ui.frg;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lt.book.R;

/**
 * Created by tao.lai on 2016/2/23 0023.
 */
public class FrgMainLeftMenu extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frg_main_left, container,false);
    }
}
