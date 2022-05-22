package com.qjj.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期操作工具类
 */
public class DateUtils {

 //获取当前时间
    public static String getCurrentDatetime() throws ParseException{

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

//设置过期时间
    public static String setDueDatetime(String DateTime,int year) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(DateTime);
       date.setYear(date.getYear() + year);
        return sdf.format(date);
    }

    //设置过期时间,月
    public static String setTrialDueDatetime(String DateTime,int month) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(DateTime);
        date.setMonth(date.getMonth() + month);
        return sdf.format(date);
    }

}
