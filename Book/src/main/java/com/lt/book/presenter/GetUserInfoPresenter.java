package com.lt.book.presenter;

import android.os.Handler;

import com.lt.book.bean.User;
import com.lt.book.model.GetUserInfo;
import com.lt.book.model.IGetUserInfo;
import com.lt.book.model.IOnResultListener;
import com.lt.book.ui.Iaty.IShowUserInfoView;

/**
 * Created by tao.lai on 2016/1/31 0031.
 */
public class GetUserInfoPresenter {
    private IGetUserInfo iGetUserInfo;
    private IShowUserInfoView iShowUserInfoView;
    private Handler handler;

    public GetUserInfoPresenter(IShowUserInfoView iShowUserInfoView) {
        this.iShowUserInfoView = iShowUserInfoView;
        iGetUserInfo = new GetUserInfo();
        handler =  new Handler();
    }

    public void getUserInfo2Show(int id){
        iShowUserInfoView.showLoading();
        iGetUserInfo.getUserInfo(id, new IOnResultListener() {
            @Override
            public void onSuccess(Object obj) {
                final User user = (User)obj;
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iShowUserInfoView.showUser(user);
                        iShowUserInfoView.hideLoading();
                    }
                });
            }

            @Override
            public void onFail() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iShowUserInfoView.showFailError();
                        iShowUserInfoView.hideLoading();
                    }
                });
            }
        });
    }
}
