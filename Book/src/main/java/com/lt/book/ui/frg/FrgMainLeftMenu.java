package com.lt.book.ui.frg;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.lt.book.R;
import com.lt.book.bean.User;
import com.lt.book.global.GlobalContext;
import com.lt.book.ui.adapter.AdapterFriends;
import com.lt.book.ui.aty.AtyChat;
import com.lt.book.ui.aty.AtyShareBook;
import com.lt.book.utils.T;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tao.lai on 2016/2/23 0023.
 */
public class FrgMainLeftMenu extends Fragment implements View.OnClickListener{

    private View view;
    private ListView listView;
    private AdapterFriends adapter;
    private ImageView ivMine;
    private TextView tvShare;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frg_main_left, container, false);
        listView = (ListView) view.findViewById(R.id.lv_friends);
        adapter = new AdapterFriends(GlobalContext.getInstance(),getList(),R.layout.lv_firends);
        listView.setAdapter(adapter);

        ivMine = (ImageView) view.findViewById(R.id.iv_mine);
        tvShare = (TextView) view.findViewById(R.id.tv_share);
        ivMine.setOnClickListener(this);
        tvShare.setOnClickListener(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User u = getList().get(position);
                T.showShort(GlobalContext.getInstance(),u.getUsername());
                startActivity(new Intent(GlobalContext.getInstance(), AtyChat.class));
            }
        });
        return view;
    }

    private List<User> getList() {
        List<User> list = new ArrayList<>();
        User user;
        for (int i = 0; i < 30; i++) {
            user = new User();
            user.setUsername("帅哥" + i);
            list.add(user);
        }
        return list;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.iv_mine:
                T.showShort(GlobalContext.getInstance(),"进入个人主页");
                break;
            case R.id.tv_share:
                startActivity(new Intent(GlobalContext.getInstance(), AtyShareBook.class));
                break;
            default:break;
        }
    }
}
