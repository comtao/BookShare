package com.lt.book.presenter;

import android.os.Handler;

import com.lt.book.bean.User;
import com.lt.book.global.GlobalContext;
import com.lt.book.model.IOnResultListener;
import com.lt.book.model.IUserInfo;
import com.lt.book.model.UserInfo;
import com.lt.book.ui.Iaty.IRegister;
import com.lt.book.ui.Iaty.ILogin;

import cn.bmob.v3.BmobUser;


/**
 * Created by tao.lai on 2016/2/22 0022.
 */
public class UserPresenter {
    private Handler handler;
    private ILogin iLogin;
    private IRegister iRegister;
    private IUserInfo iUserInfo;

    public UserPresenter(ILogin iLogin) {
        this.iLogin = iLogin;
        handler = new Handler();
        iUserInfo = new UserInfo();
    }

    public UserPresenter(IRegister iRegister) {
        this.iRegister = iRegister;
        handler = new Handler();
        iUserInfo = new UserInfo();
    }

    /**
     * 注册
     * @param user
     */
    public void doRegister(User user) {
        iRegister.showLoading();
        iUserInfo.register(user, new IOnResultListener() {
            @Override
            public void onSuccess(Object obj) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iRegister.hideLoading();
                        iRegister.registerSuccess();
                    }
                });
            }

            @Override
            public void onFail() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iRegister.hideLoading();
                        iRegister.showFailError();
                    }
                });
            }
        });
    }

    /**
     * 登录
     * @param
     */
    public void doLogin(User user){
        iLogin.showLoading();
        iUserInfo.login(user, new IOnResultListener() {
            @Override
            public void onSuccess(Object obj) {
                GlobalContext.getInstance().setUser(BmobUser.getCurrentUser(GlobalContext.getInstance(), User.class));
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iLogin.hideLoading();
                        iLogin.loginSuccess();
                    }
                });
            }

            @Override
            public void onFail() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iLogin.hideLoading();
                        iLogin.showFailError();
                    }
                });
            }
        });
    }
}
