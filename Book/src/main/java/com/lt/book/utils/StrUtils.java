package com.lt.book.utils;

/**
 * Created by tao.lai on 2016/2/23 0023.
 */
public class StrUtils {

    public static boolean isEmpty(String str){
        if(str == null || str.length() == 0){
            return true;
        }
        return false;
    }
}
