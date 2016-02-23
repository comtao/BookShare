package com.lt.book.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by tao.lai on 2016/1/31 0031.
 */
public class User extends BmobObject{
    private int id;
    private String name;
    private String passWord;
    private byte sex;
    private String avatar;  //头像
    private String des;

    public static final byte SEX_MAN   = 0x1;
    public static final byte SEX_WOMAN = 0x0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
