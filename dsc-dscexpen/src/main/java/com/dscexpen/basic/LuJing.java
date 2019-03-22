package com.dscexpen.basic;

import com.dscexpen.conllection.TestProperties;

import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;

public class LuJing {
	//路径
	private static void test1() throws Exception{
		Properties properties=new Properties();
		String path1 = System.getProperty("user.dir");
		String path2 = System.getProperty("user.dir") + File.separator + "properties";
		File file=new File("");
		properties.load(new InputStreamReader(TestProperties.class.getClassLoader().getResourceAsStream("config.properties"), "UTF-8"));
		System.out.println(path1+"\r\n"+path2);
	}

	private void test2() throws Exception{
		//获取当前类的所在工程路径; 
		File f = new File(this.getClass().getResource("/").getPath());
		System.out.println("获取当前类的所在工程路径1: "+f);

		File file = new File("");//参数为空
		String courseFile = file.getCanonicalPath() ;
		System.out.println("获取当前类的所在工程路径2 :"+courseFile);

		//获取当前工程路径 
		System.out.println("获取当前工程路径3: "+ System.getProperty("java.class.path")); 
		System.out.println("获取当前工程路径4: "+System.getProperty("user.dir"));

		//获取当前类的绝对路径；
		File f1 = new File(this.getClass().getResource("").getPath());
		System.out.println("获取当前类的绝对路径5: "+f1); 

		//获取当前工程src目录下selected.txt文件的路径 
		URL xmlpath = this.getClass().getClassLoader().getResource("config.properties");
		System.out.println("获取当前工程src目录下文件的路径6: "+xmlpath); 
		String str=new LuJing().getClass().getResource("/").getPath()+"config.properties";
		System.out.println("str:  "+str);


	}

	public static void main(String[] args) throws Exception {
	//	test1();
		LuJing lj= new LuJing();
		lj.test2();
	}

}
