package com.dscexpen.md5;

import org.junit.Test;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MD5 {

    public static String encoderMd5(String string) {
        byte[] source = string.getBytes();
        String s = null;
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            java.security.MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source);
            byte tmp[] = md.digest();
            char str[] = new char[16 * 2];
            int k = 0;
            for (int i = 0; i < 16; i++) {
                byte byte0 = tmp[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            s = new String(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public static String encoderMd5ByString(String str) {
        String md5String = encoderMd5(str);
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        String time = df.format(new Date());
        String tmp = md5String + time;
        tmp = encoderMd5(tmp);
        return tmp;
    }


    @Test
    public void test(){
        String str = "abcd852fvssgvhdhfgjgghjghkggjbffhf";
        String md5 = MD5.encoderMd5(str);
        System.out.println(md5);
        System.out.println("-----------------");
        String str2 = "abcd851";
        String str3 =MD5.encoderMd5(str2);
        System.out.println(str3);
        System.out.println(str3.length());


    }
}
