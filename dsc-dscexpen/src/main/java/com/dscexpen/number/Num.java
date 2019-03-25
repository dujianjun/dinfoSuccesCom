package com.dscexpen.number;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;


public class Num {

    @Test
    public void test1() {
        double num = 2.122;
        //返回不大于num的整数
        System.out.println(Math.floor(num));
        //返回num的四舍五入后的值
        System.out.println(Math.round(num));
        //则是不小于他的最小整数
        System.out.println(Math.ceil(num));
    }

    /**
     * DecimalFormat的用法
     */
    @Test
    public  void  test2(){
        double pi=3.1415927;//圆周率
        //取一位整数
        System.out.println(new DecimalFormat("0").format(pi));//3
        //取一位整数和两位小数
        System.out.println(new DecimalFormat("0.00").format(pi));//3.14
        //取两位整数和三位小数，整数不足部分以0填补。
        System.out.println(new DecimalFormat("00.000").format(pi));//03.142
        //取所有整数部分
        System.out.println(new DecimalFormat("#").format(pi));//3
        //以百分比方式计数，并取两位小数
        System.out.println(new DecimalFormat("#.##%").format(pi));//314.16%

        long c=299792458;//光速
        //显示为科学计数法，并取五位小数
        System.out.println(new DecimalFormat("#.#####E0").format(c));//2.99792E8
        //显示为两位整数的科学计数法，并取四位小数
        System.out.println(new DecimalFormat("00.####E0").format(c));//29.9792E7
        //每三位以逗号进行分隔。
        System.out.println(new DecimalFormat(",###").format(c));//299,792,458
        //将格式嵌入文本
        System.out.println(new DecimalFormat("光速大小为每秒,###米").format(c)); //光速大小为每秒299,792,458米

    }


    @Test
    public void test3() {
        BigDecimal bigDecimal = new BigDecimal("2.122");
        System.out.println(bigDecimal.toString());

    }

}
