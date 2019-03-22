package com.dscexpen.number;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * Description:
 * Program Name:
 * author :dujianjun
 * Date:2018-02-02  14:12  星期五
 * version 1.0
 */
public class BigDecimaltest {


    /**
     * 1、参数类型为double的构造方法的结果有一定的不可预知性。
     * 有人可能认为在Java中写入newBigDecimal(0.1)所创建的BigDecimal正好等于 0.1（非标度值 1，其标度为 1），
     * 但是它实际上等于0.1000000000000000055511151231257827021181583404541015625。这是因为0.1无法准确地表示为 double
     *
     * 2、String 构造方法是完全可预知的：写入 newBigDecimal(“0.1”) 将创建一个 BigDecimal，它正好等于预期的 0.1。因此，比较而言， 通常建议优先使用String构造方法。
     *
     */

    @Test
    public void test1() {
        BigDecimal a = new BigDecimal(1.22);
        System.out.println("a values is:" + a);

        BigDecimal b = new BigDecimal("1.22");
        System.out.println("a values is:" + b);
        /**
         * 当double必须用作BigDecimal的源时，请注意，此构造方法提供了一个准确转换；它不提供与以下操作相同的结果：
         * 先使用Double.toString(double)方法，然后使用BigDecimal(String)构造方法，将double转换为String。要获取该结果，请使用static valueOf(double)方法。
         */
        double d = 0.22d;
        BigDecimal bigDecimal = new BigDecimal(Double.valueOf(d));
    }



    /**
     * 1、由于NumberFormat类的format()方法可以使用BigDecimal对象作为其参数，可以利用BigDecimal对超出16位有效数字的货币值，百分值，以及一般数值进行格式化控制。

     * 2、 以利用BigDecimal对货币和百分比格式化为例。首先，创建BigDecimal对象，进行BigDecimal的算术运算后，分别建立对货币和百分比格式化的引用，
     *   最后利用BigDecimal对象作为format()方法的参数，输出其格式化的货币值和百分比。
     */
    @Test
    public void test2() {
        NumberFormat currency = NumberFormat.getCurrencyInstance(); //建立货币格式化引用
        NumberFormat percent = NumberFormat.getPercentInstance();  //建立百分比格式化引用
        percent.setMaximumFractionDigits(3); //百分比小数点最多3位

        BigDecimal loanAmount = new BigDecimal("15000.48"); //贷款金额
        BigDecimal interestRate = new BigDecimal("0.008"); //利率
        BigDecimal interest = loanAmount.multiply(interestRate); //相乘

        System.out.println("贷款金额:\t" + currency.format(loanAmount));
        System.out.println("利率:\t" + percent.format(interestRate));
        System.out.println("利息:\t" + currency.format(interest));
    }

    /**
     * 对BigDecimal进行比较大小
     */
    public void test3() {
        BigDecimal a=new BigDecimal("1");
        BigDecimal b=new BigDecimal("2");
        BigDecimal c=new BigDecimal("1");
        System.out.println(a.compareTo(b));
        System.out.println(a.compareTo(c));
        System.out.println( b.compareTo(a));
    }

    /**
     * BigDecimal用String参数的构造方法，可以比较大小
     */
    @Test
    public  void test4(){
        BigDecimal b1 = new BigDecimal("1655587551463546889999999999999999999999999999999999999999999");
        BigDecimal b2 = new BigDecimal("165558755146354688999999");
        int i = b1.compareTo(b2);
        System.out.println(b1.compareTo(b2));

    }



    /**
     * add(BigDecimal)        BigDecimal对象中的值相加，然后返回这个对象。
     *subtract(BigDecimal)    BigDecimal对象中的值相减，然后返回这个对象。
     * multiply(BigDecimal)   BigDecimal对象中的值相乘，然后返回这个对象。
     *divide(BigDecimal)      BigDecimal对象中的值相除，然后返回这个对象。
     * toString()             将BigDecimal对象的数值转换成字符串。
     *doubleValue()           将BigDecimal对象中的值以双精度数返回。
     *floatValue()            将BigDecimal对象中的值以单精度数返回。
     *longValue()             将BigDecimal对象中的值以长整数返回。
     *intValue()              将BigDecimal对象中的值以整数返回。
     */


    // 除法运算默认精度
    private static final int DEF_DIV_SCALE = 10;

    /**
     * 精确加法
     */
    public static double add(double value1, double value2) {
        BigDecimal b1 = BigDecimal.valueOf(value1);
        BigDecimal b2 = BigDecimal.valueOf(value2);
        return b1.add(b2).doubleValue();
    }

    /**
     * 精确减法
     */
    public static double sub(double value1, double value2) {
        BigDecimal b1 = BigDecimal.valueOf(value1);
        BigDecimal b2 = BigDecimal.valueOf(value2);
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 精确乘法
     */
    public static double mul(double value1, double value2) {
        BigDecimal b1 = BigDecimal.valueOf(value1);
        BigDecimal b2 = BigDecimal.valueOf(value2);
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 精确除法 使用默认精度
     */
    public static double div(double value1, double value2) throws IllegalAccessException {
        return div(value1, value2, DEF_DIV_SCALE);
    }
    /**
     * 四舍五入
     * @param scale 小数点后保留几位
     */
    public static double round(double v, int scale) throws IllegalAccessException {
        return div(v, 1, scale);
    }

    /**
     * 精确除法
     * @param scale 精度
     */
    public static double div(double value1, double value2, int scale) throws IllegalAccessException {
        if(scale < 0) {
            throw new IllegalAccessException("精确度不能小于0");
        }
        BigDecimal b1 = BigDecimal.valueOf(value1);
        BigDecimal b2 = BigDecimal.valueOf(value2);
        // return b1.divide(b2, scale).doubleValue();
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    /**
     * 比较大小
     */
    public static boolean equalTo(BigDecimal b1, BigDecimal b2) {
        if(b1 == null || b2 == null) {
            return false;
        }
        return 0 == b1.compareTo(b2);
    }






}
