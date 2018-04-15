package com.cdg.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ALSR
 * 时间转换工具类
 */
public class DateUtils {

    /**
     * 日期转换工具：long转成日期格式  年月日时分秒
     * @param dateLong
     * @return
     */
    public static String long2DateString(Long dateLong){
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date=new Date(dateLong);
        return sdf.format(date);
    }
    /**
     * 把时间转换成字符串，格式为2006.01.10 20:56:30.756
     *
     * @param date
     *            时间
     * @return 时间字符串
     */
    public static String dateTime2String(Date date) {
        return date2String(date, "yyyyMMddHHmmssSSS");
    }
    /**
     * 按照指定格式把时间转换成字符串，格式的写法类似yyyy.MM.dd HH:mm:ss.SSS
     *
     * @param date
     *            时间
     * @param pattern
     *            格式
     * @return 时间字符串
     */
    public static String date2String(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        return (new SimpleDateFormat(pattern)).format(date);
    }
    /**
     * 日期转换工具：long转成日期格式  年月日
     * @param dateLong
     * @return
     */
    public static String long2DateStringYMD(Long dateLong){
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy年MM月dd日");
        Date date=new Date(dateLong);
        return sdf.format(date);
    }

    /**
     * 转换成字符串
     * @param dateLong
     * @return
     */
    public static String longToDateString(Long dateLong){
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy/MM/dd");
        Date date=new Date(dateLong);
        return sdf.format(date);
    }
    /**
     * 获取两个时间点的年数差
     * @param date1
     * @param date2
     * @return
     */
    public static int getYearsDiff(long date1,long date2){
        return (int)((date1-date2)/(1000*24*30*12)/(60*60));
    }

    /**
     * 即获取两个时间点年数差之后，获取月数差
     * @param date1
     * @param date2
     * @return
     */
    public static int getMonthsAfterYears(long date1,long date2){
        int num=(int)((date1-date2)/(1000*24*30)/(60*60));
        return num%12;
    }

    /**
     * 获取两个时间点之间的月数差
     * @param date1
     * @param date2
     * @return
     */
    public static int getMonthsDiff(long date1,long date2){
        return (int)((date1-date2)/(1000*24*30)/(60*60));
    }

    /**
     * 获取两个时间点的天数差
     * @param date1
     * @param date2
     * @return
     */
    public static int getDaysDiff(long date1,long date2){
        return (int)((date1-date2)/(1000*60*60*24));
    }

    public static Date string2Date(String str){
        DateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(str);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args){
        long date1=System.currentTimeMillis();
        long date2=1488384000000L;
        System.out.println((date1-date2)/(1000*24)/(60*60));
        System.out.println(getYearsDiff(date1,date2));
    }
}
