package com.dinfosuccescom.controller;

import com.dinfoSuccesCom.service.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 * Program Name:
 * author :dujianjun
 * Date:2019-03-07  20:14  星期四
 * version 1.0
 */
public class Consumer {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"consumer.xml"});
        context.start();
        DemoService demoService = (DemoService)context.getBean("demoService"); // 获取远程服务代理
        String hello = demoService.sayHello("world"); // 执行远程方法
        System.out.println( hello ); // 显示调用结果
    }
}