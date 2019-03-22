package com.dscexpen.date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {

    /**
     *当日期字符串无时间时，不能解析成有时的date
     * @throws ParseException
     */
    @Test
    public  void test1() throws ParseException {
       // SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   //     Date date = new Date();
        String format = simpleDateFormat.format(new Date());


        System.out.println(format);


      /*  String time = "2010-10-12";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date parse = simpleDateFormat.parse(time);
        System.out.println(parse);*/
    }


}
