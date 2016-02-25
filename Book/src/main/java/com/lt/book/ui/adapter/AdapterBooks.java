package com.lt.book.ui.adapter;

import android.content.Context;

import com.lt.book.R;
import com.lt.book.bean.Book;

import java.util.List;

/**
 * Created by tao.lai on 2016/2/25 0025.
 */
public class AdapterBooks extends CommonAdapter<Book>{

    public AdapterBooks(Context context, List<Book> mDatas, int itemLayoutId) {
        super(context, mDatas, itemLayoutId);
    }

    @Override
    public void convert(ViewHolder helper, Book item) {
        helper.setText(R.id.tv_title,item.getTitle());
        helper.setText(R.id.tv_author,item.getAuthor());
        helper.setText(R.id.tv_time,item.getPubdate());
        helper.setText(R.id.tv_publisher,item.getPublisher());
        helper.setText(R.id.tv_distance,"12m");
        helper.setNetImageByUrl(R.id.iv_book,item.getImagePath());
    }
}
