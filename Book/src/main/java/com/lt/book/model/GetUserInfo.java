package com.lt.book.model;

import com.lt.book.bean.User;

/**
 * Created by tao.lai on 2016/1/31 0031.
 */
public class GetUserInfo implements IGetUserInfo {

    @Override
    public void getUserInfo(final int id, final IOnResultListener listener) {
        // 模拟子线程耗时操作
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 模拟信息获取成功
                if (id == 1) {
                    User user = new User();
                    user.setName("非著名程序员");
                    user.setAvatar("ssssssssss");
                    listener.onSuccess(user);
                } else {
                    listener.onFail();
                }
            }
        }.start();
    }
}
