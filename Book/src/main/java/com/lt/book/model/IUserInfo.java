package com.lt.book.model;

import com.lt.book.bean.User;

/**
 * Created by tao.lai on 2016/2/22 0022.
 */
public interface IUserInfo {
    void register(User user, IOnResultListener listener);
    void login(User user, IOnResultListener listener);
}
