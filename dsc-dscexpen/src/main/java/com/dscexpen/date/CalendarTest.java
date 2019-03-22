package com.dscexpen.date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Description:
 * Program Name:
 * author :dujianjun
 * Date:2018-01-18  14:28  星期四
 * version 1.0
 */
public class CalendarTest {

    /**
     * 将当前时间向前推一个月
     * @throws ParseException
     */
    public static void test1() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        String format = simpleDateFormat.format(calendar.getTime());
        System.out.println(format);


    }

    /**
     * 将当前时间向后推移2分钟
     */
    public static void test2() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        System.out.println("当前时间：" + sdf.format(now));

        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, 2);
        System.out.println("操作后时间：" +sdf.format(nowTime.getTime()));

    }
    public static void test3(){
        Calendar c1 = new GregorianCalendar();
        c1.set(Calendar.HOUR_OF_DAY, 0);
        c1.set(Calendar.MINUTE, 0);
        c1.set(Calendar.SECOND, 0);
        System.out.println(c1.getTime());
        Calendar c2 = new GregorianCalendar();
        c2.set(Calendar.HOUR_OF_DAY, 23);
        c2.set(Calendar.MINUTE, 59);
        c2.set(Calendar.SECOND, 59);
        System.out.println(c2.getTime());
    }

    public static void test4(){
        Calendar c1 = new GregorianCalendar();
        c1.set(Calendar.DATE, 9);
        c1.set(Calendar.HOUR_OF_DAY, 0);
        c1.set(Calendar.MINUTE, 0);
        c1.set(Calendar.SECOND, 0);
        System.out.println(c1.getTime());

    }


    public static void test5(String oneDare) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1= Calendar.getInstance();
        c1.setTime(simpleDateFormat.parse(oneDare));

        Calendar c2= Calendar.getInstance();
        c2.setTime(simpleDateFormat.parse(oneDare));
        c2.add(Calendar.DAY_OF_MONTH, 1);

    }
    public static void test5() throws ParseException {
        String geexPayDate = "2018-04-19 00:00:00";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //  Date date = simpleDateFormat.parse(geexPayDate);

        Calendar c1= Calendar.getInstance();
        c1.setTime(simpleDateFormat.parse(geexPayDate));

        Calendar c2= Calendar.getInstance();
        c2.setTime(simpleDateFormat.parse(geexPayDate));
        c2.set(Calendar.HOUR_OF_DAY, 23);
        c2.set(Calendar.MINUTE, 59);
        c2.set(Calendar.SECOND, 59);

        System.out.println(c1.getTime()+"-----------"+ c2.getTime());
        System.out.println(simpleDate.format(c1.getTime())+"-----------"+ simpleDate.format(c2.getTime()));

    }

    @Test
    public  void test6() throws ParseException {

        Calendar c1 = new GregorianCalendar();
        c1.add(Calendar.DAY_OF_MONTH, -1);
        c1.set(Calendar.HOUR_OF_DAY, 0);
        c1.set(Calendar.MINUTE, 0);
        c1.set(Calendar.SECOND, 0);

        Date date = new Date();
        System.out.println(c1.getTime());
        System.out.println(c1.getTime().before(date));


    }

}
