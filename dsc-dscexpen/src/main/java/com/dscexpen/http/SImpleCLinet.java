package com.dscexpen.http;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;

/**
 * Description:
 * Program Name:
 * author :dujianjun
 * Date:2018-06-08  15:12  星期五
 * version 1.0
 */
public class SImpleCLinet {

    private static void RestTemplateVisit() {
        String returnXml = ""; // 核心返回结果报文字符串

        try {

            //复杂构造函数的使用
            SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
            requestFactory.setConnectTimeout(10000);// 设置超时
            requestFactory.setReadTimeout(10000);

            //利用复杂构造器可以实现超时设置，内部实际实现为 HttpClient
            RestTemplate restTemplate = new RestTemplate(requestFactory);

            //设置HTTP请求头信息，实现编码等
            HttpHeaders requestHeaders = new HttpHeaders();
            // requestHeaders.set("Accept", "text/");
            requestHeaders.set("Accept-Charset", "utf-8");
            requestHeaders.set("Content-type", "text/xml; charset=utf-8");// 设置编码

            //利用容器实现数据封装，发送
            HttpEntity<String> entity = new HttpEntity<String>("111111aaaaaaaaaaa", requestHeaders);
            returnXml = restTemplate.postForObject("http://localhost:8086/GxFundApi/yx/yncYxRepaymentStatus", entity, String.class);

            System.out.println("*****************************************");
            // 转码原因：RestTemplate默认是使用org.springframework.http.converter.StringHttpMessageConverter来解析
            // StringHttpMessageConverter 默认用的 ISO-8859-1来编码的
            returnXml = new String(returnXml.getBytes("ISO-8859-1"), "utf-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println("restTemplate客户端访问返回： \n" + returnXml);
    }
}
