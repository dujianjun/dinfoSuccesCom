package com.dscexpen.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName: PropertyUtil
 * @Description: 读取配置文件工具类
 * @author 
 * @date 2016-1-13 上午11:39:20
 */
public class PropertyUtil {
	private static Properties p = new Properties();
	//static String path1=new PropertyUtil().getClass().getResource("/").getPath()+"config.properties";
	static String path=System.getProperty("user.dir")+File.separator+"config.properties";
	static{
		try {
		    File file = new File(path);
	        InputStream in = new FileInputStream(file);
			p.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getValue(String key){
		String value = p.getProperty(key);
		return value;
	}
    public static void setValue(String key, String value) {
        try {
            File file = new File(path);
            FileOutputStream out = new FileOutputStream(file);
            p.setProperty(key, value);
            p.store(out,"save");
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
		System.out.println(getValue("portal.oracle.user"));
	}
}
