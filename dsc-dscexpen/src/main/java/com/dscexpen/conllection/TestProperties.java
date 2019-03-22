package com.dscexpen.conllection;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	
	//读取和修改配置文件
	private static void test1() throws IOException{
		File file  = new File("C:\\Users\\cheng\\Desktop\\config.properties");
		if(!file.exists()){
			file.createNewFile();
		}
		FileReader fr = new FileReader(file);
		Properties p = new Properties();
		p.load(fr);
		
		FileWriter fw = new FileWriter(file);
		p.setProperty("age", "12");
		p.setProperty("like", "basketball");
		p.store(fw, "updteAge");
		System.out.println(p);
	    fw.close();
		fr.close();
	}
	//properties联系，计数要给程序运行规定次数，如果不注册或者购买，则程序不能运行
	private static void test2() throws Exception{
		String path = System.getProperty("user.dir") + File.separator+ "properties";
		File file  = new File(path);
		if(!file.exists()){
			file.createNewFile();
		}
	}
	
	
	
	
	public static void main(String[] args){
		try {
			test1();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
