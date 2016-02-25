package com.lt.book.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.bmob.newim.bean.BmobIMMessage;
import cn.bmob.v3.BmobUser;

/**
 * Created by tao.lai on 2016/2/24 0024.
 */
public class AdapterChat extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private final int TYPE_RECEIVER_TXT = 0;
    private final int TYPE_SEND_TXT = 1;

    /**
     * 显示时间间隔
     */
    private final long TIME_INTERVAL = 10 * 60 * 1000;

    private List<BmobIMMessage> msgs = new ArrayList<>();

    private String currentUid="";

    public AdapterChat(Context context) {
        try {
            currentUid = BmobUser.getCurrentUser(context).getObjectId();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDatas(List<BmobIMMessage> messages) {
        msgs.clear();
        if (null != messages) {
            msgs.addAll(messages);
        }
    }

    public void addMessages(List<BmobIMMessage> messages) {
        msgs.addAll(0, messages);
    }

    public void addMessage(BmobIMMessage message) {
        msgs.addAll(Arrays.asList(message));
    }

    public BmobIMMessage getFirstMessage() {
        if (null != msgs && msgs.size() > 0) {
            return msgs.get(0);
        } else {
            return null;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_RECEIVER_TXT) {
            parent.getContext();
            return new ReceiveTextHolder(parent.getContext(), parent);
        } else if (viewType == TYPE_SEND_TXT) {
            return new SendTextHolder(parent.getContext(), parent);
        } else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((BaseViewHolder)holder).bindData(msgs.get(position));
        if (holder instanceof ReceiveTextHolder) {
            ((ReceiveTextHolder)holder).showTime(shouldShowTime(position));
        } else if (holder instanceof SendTextHolder) {
            ((SendTextHolder)holder).showTime(shouldShowTime(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
        BmobIMMessage message = msgs.get(position);
        if (message.getFromId().equals(currentUid)) {
            return TYPE_SEND_TXT;
        } else {
            return TYPE_RECEIVER_TXT;
        }
    }

    @Override
    public int getItemCount() {
        return msgs.size();
    }

    private boolean shouldShowTime(int position) {
        if (position == 0) {
            return true;
        }
        long lastTime = msgs.get(position - 1).getCreateTime();
        long curTime = msgs.get(position).getCreateTime();
        return curTime - lastTime > TIME_INTERVAL;
    }
}