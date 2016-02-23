package com.lt.book.model;

import com.lt.book.bean.User;
import com.lt.book.global.GlobalContext;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by tao.lai on 2016/2/22 0022.
 */
public class UserInfo implements IUserInfo {

    @Override
    public void register(User user, final IOnResultListener listener) {
        user.save(GlobalContext.getInstance(), new SaveListener() {
            @Override
            public void onSuccess() {
                listener.onSuccess(null);
            }

            @Override
            public void onFailure(int i, String s) {
                listener.onFail();
            }
        });

    }

    @Override
    public void login(User user, final IOnResultListener listener) {
        BmobQuery<User> query = new BmobQuery<User>();
        query.addWhereEqualTo("name",user.getName())
                 .addWhereEqualTo("passWord",user.getPassWord());
        query.setLimit(1);
        query.findObjects(GlobalContext.getInstance(), new FindListener<User>() {
            @Override
            public void onSuccess(List<User> list) {
                listener.onSuccess(null);
            }

            @Override
            public void onError(int i, String s) {
                listener.onFail();
            }
        });
    }
}
