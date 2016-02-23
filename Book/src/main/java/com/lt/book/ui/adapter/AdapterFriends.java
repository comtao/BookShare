package com.lt.book.ui.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.lt.book.R;
import com.lt.book.bean.User;

import java.util.List;

/**
 * Created by tao.lai on 2016/2/23 0023.
 */
public class AdapterFriends extends CommonAdapter<User> {

    public AdapterFriends(Context context, List<User> mDatas, int itemLayoutId) {
        super(context, mDatas, itemLayoutId);
    }

    @Override
    public void convert(ViewHolder helper, User item) {
        ImageView ivAvatar = helper.getView(R.id.iv_avatar);
        TextView textView = helper.getView(R.id.tv_name);
        ivAvatar.setImageResource(R.mipmap.ic_launcher);
        textView.setText(item.getName());
    }
}
