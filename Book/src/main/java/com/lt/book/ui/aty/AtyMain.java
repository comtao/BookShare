package com.lt.book.ui.aty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lt.book.R;

/**
 * Created by tao.lai on 2016/1/30 0030.
 */
public class AtyMain extends AtyBase implements View.OnClickListener {
    private static final String TAG = "AtyMain";

    private Button btnShare,btnGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_main);
        btnShare = (Button) findViewById(R.id.btn_share);
        btnGet   = (Button) findViewById(R.id.btn_get);
        btnShare.setOnClickListener(this);
        btnGet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_share:
                startActivity(new Intent(this,AtyShareBook.class));
                break;
            case R.id.btn_get:
                startActivity(new Intent(this,AtyShowUserInfo.class));
                break;
            default:
                break;
        }
    }
}
