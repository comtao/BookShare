package com.lt.book.ui.aty;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.lt.book.R;
import com.lt.book.ui.adapter.AdapterChat;

import cn.bmob.newim.bean.BmobIMConversation;
import cn.bmob.newim.core.BmobIMClient;

/**
 * 聊天窗口
 * Created by tao.lai on 2016/2/24 0024.
 */
public class AtyChat extends AtyBase{

    private AdapterChat adapter;
    private LinearLayoutManager layoutManager;
    private BmobIMConversation c;  //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_chat);
        c = BmobIMConversation.obtain(BmobIMClient.getInstance(), (BmobIMConversation) getBundle().getSerializable("c"));
    }
}
