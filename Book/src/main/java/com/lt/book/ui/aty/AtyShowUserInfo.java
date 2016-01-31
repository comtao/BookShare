package com.lt.book.ui.aty;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lt.book.R;
import com.lt.book.bean.User;
import com.lt.book.presenter.GetUserInfoPresenter;
import com.lt.book.ui.Iaty.IShowUserInfoView;
import com.lt.book.utils.T;

/**
 * Created by tao.lai on 2016/1/31 0031.
 */
public class AtyShowUserInfo extends AtyBase implements IShowUserInfoView {
    private GetUserInfoPresenter getUserInfoPresenter;

    private TextView tvName;
    private Button btnGet;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_show_userinfo);
        getUserInfoPresenter = new GetUserInfoPresenter(this);
        pd = new ProgressDialog(this);
        pd.setMessage("loading...");

        tvName = (TextView) findViewById(R.id.tv_name);
        btnGet = (Button) findViewById(R.id.btn_get);

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUserInfoPresenter.getUserInfo2Show(1);
            }
        });
    }

    @Override
    public void showUser(User user) {
        tvName.setText(user.getName());
    }

    @Override
    public void showLoading() {
        pd.show();
    }

    @Override
    public void hideLoading() {
        pd.dismiss();
    }

    @Override
    public void showFailError() {
        T.showShort(this,"信息获取有错");
    }
}
