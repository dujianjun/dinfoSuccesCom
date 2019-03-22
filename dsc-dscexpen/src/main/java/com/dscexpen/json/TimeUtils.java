package com.dscexpen.json;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Description:
 * Program Name:
 * author :dujianjun
 * Date:2018-07-12  17:37  星期四
 * version 1.0
 */
public class TimeUtils {

    public static final SimpleDateFormat YYYYMMDD_HHMMSS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat YYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");

    public static String getDayLastTime(String lastTime) throws ParseException {
        Calendar cals = Calendar.getInstance();
        cals.setTime(YYYYMMDD.parse(lastTime));
        cals.set(Calendar.HOUR_OF_DAY, 23);
        cals.set(Calendar.MINUTE, 59);
        cals.set(Calendar.SECOND, 59);
        return YYYYMMDD_HHMMSS.format(cals.getTime());
    }


    public static String getDayFirstTime(String FirstTime) throws ParseException {
        Calendar cals = Calendar.getInstance();
        cals.setTime(YYYYMMDD.parse(FirstTime));
        cals.set(Calendar.HOUR_OF_DAY, 0);
        cals.set(Calendar.MINUTE, 0);
        cals.set(Calendar.SECOND, 0);
        return YYYYMMDD_HHMMSS.format(cals.getTime());
    }

    public static String format(Date date , SimpleDateFormat formatter){
        return formatter.format(date);
    }

    public static Date parse(String date , SimpleDateFormat formatter) throws ParseException {
        return formatter.parse(date);
    }

   /* public static void main(String[] args) throws ParseException {
        String strs = "2018-07-12";
        System.out.println(getDayLastTime(strs));
        System.out.println(getDayFirstTime(strs));


    }*/
   //日期转字符串
   public static String dateToStr(Date date){
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       String parse ="";
       if (null!=date){
           try {
               parse = sdf.format(date);
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
       return parse;
   }

    //日期转字符串
    public static String dateToStrFor(Date date, String formatStr){
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        String parse ="";
        if (null!=date){
            try {
                parse = sdf.format(date);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return parse;
    }

}
