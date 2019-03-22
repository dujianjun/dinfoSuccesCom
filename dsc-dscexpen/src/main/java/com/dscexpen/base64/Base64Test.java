package com.dscexpen.base64;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.io.*;

/**
 * Description:
 * Program Name:
 * author :dujianjun
 * Date:2019-03-20  12:10  星期三
 * version 1.0
 */
public class Base64Test {

    private  static String path = null;
    private  static String path1 = null;
    private  static String path2 = null;
    static {
       /* path = Base64Test.getClass().getClassLoader().getResource("/template/销售收集线索导出模板.xls").getPath();
        path1 = Base64Test.class.getResource("/") + "file/aa.jpg";
        path2 = Base64Test.class.getResource("/").getPath()+"file/aa.jpg";*/
    }


   @Test
    public  void  test() {

       path = this.getClass().getClassLoader().getResource("file/aa.jpg").getFile();
       System.out.println(path);
       path1 = Base64Test.class.getResource("/").getPath() + "file/aa.jpg";
       System.out.println(path1);
       path2 = Base64Test.class.getResource("/").getPath()+"file/aa.jpg";
       System.out.println(path2);

       try {

           File file = new File(path);
           File file1 = new File(path1);
           File file2 = new File(path2);
           //编码
           byte[] bytes = Base64Utils.fileToByte(path);
           byte[] bytes1 = Base64Utils.fileToByte(path1);
           byte[] bytes2 = Base64Utils.fileToByte(path2);
           String encode = Base64Utils.encode(bytes);
        //   System.out.println(encode);
           //解码
           if(!StringUtils.isEmpty(encode)){
               String path = "C:/Users/geex/Desktop/aa/2.jpg";
               byte[] decode = Base64Utils.decode(encode);
               Base64Utils.byteArrayToFile(decode,path);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
}
