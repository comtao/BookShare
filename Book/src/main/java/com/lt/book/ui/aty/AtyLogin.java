package com.lt.book.ui.aty;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lt.book.R;
import com.lt.book.bean.User;
import com.lt.book.presenter.UserPresenter;
import com.lt.book.ui.Iaty.ILogin;
import com.lt.book.utils.StrUtils;
import com.lt.book.utils.T;

/**
 * Created by tao.lai on 2016/2/23 0023.
 */
public class AtyLogin extends AtyBase implements ILogin,View.OnClickListener {
    private ProgressDialog pd;
    private UserPresenter userPresenter;
    private EditText etName,etPwd;
    private Button btnRegister,btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_login);
        userPresenter = new UserPresenter(this);
        pd = new ProgressDialog(this);
        pd.setMessage("登录...");

        etName = (EditText) findViewById(R.id.et_name);
        etPwd = (EditText) findViewById(R.id.et_pwd);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnRegister = (Button) findViewById(R.id.btn_register);
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_register:
                startActivity(new Intent(this,AtyRegister.class));
                break;
            case R.id.btn_login:
                doLogin();
                break;
            default:break;
        }
    }

    private void doLogin(){
        String name = etName.getText().toString();
        String pwd  = etPwd.getText().toString();
        if(StrUtils.isEmpty(name) || StrUtils.isEmpty(pwd)){
            T.showShort(this, "账号或密码不能为空");
            return;
        }
        User user = new User();
        user.setName(name);
        user.setPassWord(pwd);
        userPresenter.doLogin(user);
    }

    @Override
    public void loginSuccess() {
        T.showShort(this,"登录成功");
        startActivity(new Intent(this,AtyMain.class));
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
        T.showShort(this,"登录失败， please try again...");
    }
}
