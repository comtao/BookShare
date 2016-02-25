package com.lt.book.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lt.book.R;
import com.lt.book.bean.Book;

import java.util.List;

/**
 * Created by tao.lai on 2016/2/25 0025.
 */
public class AdapterBooks extends RecyclerView.Adapter {

    public static interface OnRecyclerViewListener {
        void onItemClick(int position);
        boolean onItemLongClick(int position);
    }

    private OnRecyclerViewListener onRecyclerViewListener;

    public void setOnRecyclerViewListener(OnRecyclerViewListener onRecyclerViewListener) {
        this.onRecyclerViewListener = onRecyclerViewListener;
    }

    private List<Book> list;

    public AdapterBooks(List<Book> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_books, null);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        BookViewHolder bookViewHolder = (BookViewHolder) viewHolder;
        bookViewHolder.setPosition(position);
        Book book = list.get(position);
        BookViewHolder holder = ((BookViewHolder) viewHolder);
        holder.ivBook.setImageResource(R.mipmap.ic_launcher);
        holder.tvTitle.setText(book.getTitle());
        holder.tvAuthor.setText(book.getAuthor());
        holder.tvPubdate.setText(book.getPubdate());
        holder.tvPublisher.setText(book.getPublisher());
        holder.tvDistance.setText("200m");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class BookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        private int position;
        public ImageView ivBook;
        public TextView tvTitle,tvAuthor,tvPubdate,tvPublisher,tvDistance;

        private View viewRoot;

        public void setPosition(int position) {
            this.position = position;
        }

        public BookViewHolder(View itemView) {
            super(itemView);
            ivBook = (ImageView) itemView.findViewById(R.id.iv_book);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvAuthor = (TextView) itemView.findViewById(R.id.tv_author);
            tvPubdate = (TextView) itemView.findViewById(R.id.tv_time);
            tvPublisher = (TextView) itemView.findViewById(R.id.tv_publisher);
            tvDistance = (TextView) itemView.findViewById(R.id.tv_distance);

            viewRoot = itemView.findViewById(R.id.rl_books);
            viewRoot.setOnClickListener(this);
            viewRoot.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (onRecyclerViewListener != null) {
                onRecyclerViewListener.onItemClick(position);
            }
        }

        @Override
        public boolean onLongClick(View v) {
            if(onRecyclerViewListener != null){
             return onRecyclerViewListener.onItemLongClick(position);
            }
            return false;
        }
    }

    /*@Override
    public void convert(ViewHolder helper, Book item) {
        helper.setText(R.id.tv_title,item.getTitle());
        helper.setText(R.id.tv_author,item.getAuthor());
        helper.setText(R.id.tv_time,item.getPubdate());
        helper.setText(R.id.tv_publisher,item.getPublisher());
        helper.setText(R.id.tv_distance,"12m");
        helper.setNetImageByUrl(R.id.iv_book,item.getImagePath());
    }*/
}
