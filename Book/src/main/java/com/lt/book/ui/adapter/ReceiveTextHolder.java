package com.lt.book.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lt.book.R;
import com.lt.book.utils.ImageUtils;

import java.text.SimpleDateFormat;

import cn.bmob.newim.bean.BmobIMMessage;
import cn.bmob.newim.bean.BmobIMUserInfo;

/**
 * 收到的文本类型
 * Created by tao.lai on 2016/2/24 0024.
 */
public class ReceiveTextHolder extends BaseViewHolder{

    private ImageView ivAvatar;
    private TextView tvMsg,tvTime;

    public ReceiveTextHolder(Context context, ViewGroup root) {
        super(context, root, R.layout.item_chat_received_message);
    }


    @Override
    public void bindData(Object o) {
        BmobIMMessage message = (BmobIMMessage)o;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        String time = dateFormat.format(message.getCreateTime());
        String content =  message.getContent();
        tvMsg.setText(content);
        tvTime.setText(time);
        BmobIMUserInfo info = message.getBmobIMUserInfo();
        ImageUtils.setAvatar(info != null ? info.getAvatar() : null, R.mipmap.ic_launcher, ivAvatar);
    }

    public void showTime(boolean isShow) {
        tvTime.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }
}
