package com.lt.book.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tao.lai on 2016/2/23 0023.
 */
public class StrUtils {

    public static final String DATE_FORMAT_1 = "yyyy-MM-dd HH:mm";

    private static SimpleDateFormat getSimpleDateFormat(String formatStr){
        return new SimpleDateFormat(formatStr);
    }

    public static String dateFormat(Date date, String formatStr){
        return getSimpleDateFormat(formatStr).format(date);
    }

    public static String dateFormat(long date, String formatStr){
        return getSimpleDateFormat(formatStr).format(new Date(date));
    }


    public static boolean isEmpty(String str){
        if(str == null || str.length() == 0){
            return true;
        }
        return false;
    }
}
