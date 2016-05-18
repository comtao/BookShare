package com.lt.book.ui.aty;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;

import com.lt.book.R;
import com.lt.book.bean.Book;
import com.lt.book.ui.adapter.AdapterBooks;
import com.lt.book.ui.view.ViewHead;
import com.lt.book.utils.T;
import com.nineoldandroids.view.ViewHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tao.lai on 2016/1/30 0030.
 */
public class AtyMain extends AtyBase implements ViewHead.ViewHeadListener,AdapterBooks.OnRecyclerViewListener {
    private static final String TAG = "AtyMain";

    private DrawerLayout mDrawerLayout;
    private ViewHead vhTitle;
    private RecyclerView rvBooks;

    private AdapterBooks adapterBooks;
    private List<Book> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_main);
        initViews();
        initEvents();
    }

    private void initViews(){
        vhTitle = (ViewHead) generateFindViewById(R.id.view_head);
        rvBooks = (RecyclerView) generateFindViewById(R.id.rv_books);
        mDrawerLayout = generateFindViewById(R.id.id_drawerLayout);
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.RIGHT);
    }
    private void initEvents(){
        initTestBookData();
        vhTitle.setViewHeadListener(this);

        rvBooks.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvBooks.setLayoutManager(layoutManager);
        adapterBooks = new AdapterBooks(list);
        adapterBooks.setOnRecyclerViewListener(this);
        rvBooks.setAdapter(adapterBooks);

        mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                View mContent = mDrawerLayout.getChildAt(0);
                View mMenu = drawerView;
                float scale = 1 - slideOffset;
                float rightScale = 0.8f + scale * 0.2f;

                if (drawerView.getTag().equals("LEFT")) {
                    float leftScale = 1 - 0.3f * scale;
                    ViewHelper.setScaleX(mMenu, leftScale);
                    ViewHelper.setScaleY(mMenu, leftScale);
                    ViewHelper.setAlpha(mMenu, 0.6f + 0.4f * (1 - scale));
                    ViewHelper.setTranslationX(mContent, mMenu.getMeasuredWidth() * (1 - scale));
                    ViewHelper.setPivotX(mContent, 0);
                    ViewHelper.setPivotY(mContent, mContent.getMeasuredHeight() / 2);
                    mContent.invalidate();
                    ViewHelper.setScaleX(mContent, rightScale);
                    ViewHelper.setScaleY(mContent, rightScale);
                }
            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                mDrawerLayout.setDrawerLockMode(
                        DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.RIGHT);
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    @Override
    public void leftListener() {
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN,Gravity.RIGHT);
        T.showShort(this, "左侧菜单显示");
        /*View mContent = mDrawerLayout.getChildAt(0);
        View mMenu = mDrawerLayout.getChildAt(1);
        float slideOffset = (float) 0.8;
        float scale = 1 - slideOffset;
        float rightScale = 0.8f + scale * 0.2f;
        float leftScale = 1 - 0.3f * scale;

        ViewHelper.setScaleX(mMenu, leftScale);
        ViewHelper.setScaleY(mMenu, leftScale);
        ViewHelper.setAlpha(mMenu, 0.6f + 0.4f * (1 - scale));
        ViewHelper.setTranslationX(mContent, mMenu.getMeasuredWidth() * (1 - scale));
        ViewHelper.setPivotX(mContent, 0);
        ViewHelper.setPivotY(mContent, mContent.getMeasuredHeight() / 2);
        mContent.invalidate();
        ViewHelper.setScaleX(mContent, rightScale);
        ViewHelper.setScaleY(mContent, rightScale);*/
    }

    @Override
    public void rightListener() {

    }

    @Override
    public void onItemClick(int position) {
        T.showShort(this,""+list.get(position).getTitle());

    }

    @Override
    public boolean onItemLongClick(int position) {
        return false;
    }

    private void initTestBookData(){
        list = new ArrayList<>();
        Book book;
        for(int i = 0; i < 20; i ++){
            book = new Book();
            book.setTitle("黑客与画家"+i);
            book.setAuthor("作者");
            book.setPublisher("热门出版社");
            book.setPubdate("2016年06月4日");
            book.setImagePath("");
            list.add(book);
        }
    }
}
