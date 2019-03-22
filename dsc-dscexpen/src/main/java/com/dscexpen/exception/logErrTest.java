package com.dscexpen.exception;


import org.apache.log4j.Logger;

/**
 * Description:
 * Program Name:
 * author :dujianjun
 * Date:2018-06-06  14:55  星期三
 * version 1.0
 */
public class logErrTest {


  private static   Logger logger = Logger.getLogger(logErrTest.class);


    public  static void test1(){
        try {
            throw new NullPointerException();

        }catch (Exception e){
            logger.error("sssss",e);
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        test1();
    }





}
