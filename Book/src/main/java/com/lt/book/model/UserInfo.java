package com.lt.book.model;

import com.lt.book.bean.User;
import com.lt.book.global.GlobalContext;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by tao.lai on 2016/2/22 0022.
 */
public class UserInfo implements IUserInfo {

    @Override
    public void register(User user, final IOnResultListener listener) {
        user.signUp(GlobalContext.getInstance(), new SaveListener() {
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
    public void login(final User user, final IOnResultListener listener) {
        user.login(GlobalContext.getInstance(), new SaveListener() {
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
    public void loginOut() {
        BmobUser.logOut(GlobalContext.getInstance());
    }

    @Override
    public User getCurrentUser() {
        return BmobUser.getCurrentUser(GlobalContext.getInstance(), User.class);
    }

    @Override
    public void getUsersByName(String userName, int limit, final IOnResultListener listener) {
        BmobQuery<User> query = new BmobQuery<>();
        //去掉当前用户
        try {
            BmobUser user = BmobUser.getCurrentUser(GlobalContext.getInstance());
            query.addWhereNotEqualTo("username", user.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }
        query.addWhereContains("username", userName);
        query.setLimit(limit);
        query.order("-createdAt");
        query.findObjects(GlobalContext.getInstance(), new FindListener<User>() {
            @Override
            public void onSuccess(List<User> list) {
                if (list != null && list.size() > 0) {
                    listener.onSuccess(null);
                } else {
                    listener.onFail();
                }
            }

            @Override
            public void onError(int i, String s) {
                listener.onFail();
            }
        });

    }

    @Override
    public void getUserInfo(String userId, final IOnResultListener listener) {
        BmobQuery<User> query = new BmobQuery<>();
        query.addWhereEqualTo("objectId", userId);
        query.findObjects(GlobalContext.getInstance(), new FindListener<User>() {
            @Override
            public void onSuccess(List<User> list) {
                if (list != null && list.size() > 0) {
                    listener.onSuccess(list.get(0));
                } else {
                    listener.onFail();
                }
            }
            @Override
            public void onError(int i, String s) {
                listener.onFail();
            }
        });
    }
}
