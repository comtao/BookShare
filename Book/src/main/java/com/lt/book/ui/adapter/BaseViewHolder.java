package com.lt.book.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by tao.lai on 2016/2/24 0024.
 */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    public BaseViewHolder(Context context, ViewGroup root, int layoutRes) {
        super(LayoutInflater.from(context).inflate(layoutRes, root, false));
    }

    public Context getContext() {
        return itemView.getContext();
    }

    public abstract void bindData(T t);
}
