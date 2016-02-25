package com.lt.book.ui.aty;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

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
public class AtyMain extends AtyBase implements ViewHead.ViewHeadListener{
    private static final String TAG = "AtyMain";

    private DrawerLayout mDrawerLayout;
    private ViewHead vhTitle;
    private ListView lvBooks;

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
        lvBooks = (ListView) generateFindViewById(R.id.lv_books);
        mDrawerLayout = generateFindViewById(R.id.id_drawerLayout);
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.RIGHT);
    }
    private void initEvents(){
        initTestBookData();
        vhTitle.setViewHeadListener(this);
        adapterBooks = new AdapterBooks(this, list ,R.layout.item_books);
        lvBooks.setAdapter(adapterBooks);
        lvBooks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                T.showShort(AtyMain.this,"书名："+list.get(position).getTitle());
            }
        });

        mDrawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
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

    private void initTestBookData(){
        list = new ArrayList<>();
        Book book;
        for(int i = 0; i < 20; i ++){
            book = new Book();
            book.setTitle("黑客与画家"+i);
            book.setAuthor("作者");
            book.setPublisher("热门出版社");
            book.setPubdate("2016年06月4日");
            book.setImagePath("data:image/jpeg;base64,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");
            list.add(book);
        }
    }
}
