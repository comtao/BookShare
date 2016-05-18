package com.lt.book.support.msg;


import android.content.Context;

import com.lt.book.utils.L;

import cn.bmob.newim.event.MessageEvent;
import cn.bmob.newim.event.OfflineMessageEvent;
import cn.bmob.newim.listener.BmobIMMessageHandler;

/**
 * Created by lenovo on 2016/5/18.
 */
public class ImMsgHandler extends BmobIMMessageHandler {
    private static final String TAG = "ImMsgHandler";

    private Context context;

    public ImMsgHandler(Context context) {
        this.context = context;
    }

    @Override
    public void onMessageReceive(MessageEvent messageEvent) {
        L.i(TAG,"messageEvent:" + messageEvent.toString());
    }

    @Override
    public void onOfflineReceive(OfflineMessageEvent offlineMessageEvent) {

    }
}
