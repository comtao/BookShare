package com.lt.book.bean;

import cn.bmob.v3.BmobUser;

/**
 * Created by tao.lai on 2016/1/31 0031.
 */
public class User extends BmobUser{
    private byte sex;
    private String avatar;  //头像

    public static final byte SEX_MAN   = 0x1;
    public static final byte SEX_WOMAN = 0x0;

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
