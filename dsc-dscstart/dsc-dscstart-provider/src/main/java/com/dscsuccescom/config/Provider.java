package com.dscsuccescom.config;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 * Program Name:
 * author :dujianjun
 * Date:2019-03-07  20:09  星期四
 * version 1.0
 */
public class Provider {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"provider.xml"});
        context.start();
        System.in.read(); // 按任意键退出
    }
}