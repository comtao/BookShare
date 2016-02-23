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
import com.lt.book.ui.Iaty.IRegister;
import com.lt.book.utils.L;
import com.lt.book.utils.StrUtils;
import com.lt.book.utils.T;

/**
 * Created by tao.lai on 2016/2/22 0022.
 */
public class AtyRegister extends AtyBase implements IRegister,View.OnClickListener{

    private UserPresenter userPresenter;
    private ProgressDialog pd;

    private EditText etName,etPwd;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_register);

        pd = new ProgressDialog(this);
        pd.setMessage("注册...");

        userPresenter = new UserPresenter(this);
        etName = generateFindViewById(R.id.et_name);
        etPwd = generateFindViewById(R.id.et_pwd);
        btnRegister = generateFindViewById(R.id.btn_register);

        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_register:
                doRegister();
                break;
            default:break;
        }
    }

    private void doRegister(){
        String name = etName.getText().toString();
        String pwd  = etPwd.getText().toString();
        L.i("AtyRegister","name="+name+"/ pwd="+pwd+"/  /n isEmpty="+StrUtils.isEmpty(name));
        if(StrUtils.isEmpty(name) || StrUtils.isEmpty(pwd)){
            T.showShort(this,"账号或密码不能为空");
            return;
        }
        User user = new User();
        user.setName(name);
        user.setPassWord(pwd);
        userPresenter.doRegister(user);
    }

    @Override
    public void registerSuccess() {
        T.showShort(this,"注册成功");
        startActivity(new Intent(this, AtyMain.class));
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
        T.showShort(this,"注册发生错误... please try again!");
    }
}
