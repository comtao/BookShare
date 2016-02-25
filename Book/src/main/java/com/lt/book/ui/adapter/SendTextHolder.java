package com.lt.book.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lt.book.R;
import com.lt.book.utils.ImageUtils;
import com.lt.book.utils.StrUtils;

import cn.bmob.newim.bean.BmobIMMessage;
import cn.bmob.newim.bean.BmobIMSendStatus;
import cn.bmob.newim.bean.BmobIMUserInfo;

/**
 * Created by tao.lai on 2016/2/24 0024.
 */
public class SendTextHolder extends BaseViewHolder {
    private BmobIMMessage message;

    private ImageView ivAvatar, ivFailReSend;
    private TextView tvMsg, tvTime, tvSendStatus;
    private ProgressBar pbLoad;

    public SendTextHolder(Context context, ViewGroup root) {
        super(context, root, R.layout.item_chat_sent_message);
        ivAvatar = (ImageView) itemView.findViewById(R.id.iv_avatar);
        ivFailReSend = (ImageView) itemView.findViewById(R.id.iv_fail_resend);
        tvMsg = (TextView) itemView.findViewById(R.id.tv_message);
        tvTime = (TextView) itemView.findViewById(R.id.tv_time);
        tvSendStatus = (TextView) itemView.findViewById(R.id.tv_send_status);
        pbLoad = (ProgressBar) itemView.findViewById(R.id.progress_load);
    }

    @Override
    public void bindData(Object o) {
        message = (BmobIMMessage) o;
        BmobIMUserInfo info = message.getBmobIMUserInfo();
        ImageUtils.setAvatar(info != null ? info.getAvatar() : null, R.mipmap.ic_launcher, ivAvatar);
        String time = StrUtils.dateFormat(message.getCreateTime(), StrUtils.DATE_FORMAT_1);
        String content = message.getContent();
        tvMsg.setText(content);
        tvTime.setText(time);
        int status = message.getSendStatus();
        if (status == BmobIMSendStatus.SENDFAILED.getStatus()) {
            ivFailReSend.setVisibility(View.VISIBLE);
            pbLoad.setVisibility(View.GONE);
        } else if (status == BmobIMSendStatus.SENDING.getStatus()) {
            ivFailReSend.setVisibility(View.GONE);
            pbLoad.setVisibility(View.VISIBLE);
        } else {
            ivFailReSend.setVisibility(View.GONE);
            pbLoad.setVisibility(View.GONE);
        }
    }

    public void showTime(boolean isShow) {
        tvTime.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }
}
