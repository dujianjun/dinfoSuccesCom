package com.dscexpen.IO;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class TestFile {
	static	String path="C:\\Users\\cheng\\Desktop\\统计结果";
	static File  f=new File(path);

	public static void  test1(){

		//		System.out.println(f.isDirectory());
		//		System.out.println(f.exists());
		//		System.out.println(f.isFile());
		//		System.out.println(f.getAbsoluteFile());
		System.out.println(f.getAbsolutePath());
	}

	public static void test2(){
		String[]str=f.list(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {

				return name.endsWith(".docx");
			}
		});

		for (String s : str) {
			System.out.println(s);
		}

	}

	public static void test3(){
		if(!f.exists()){
			//	f.mkdirs();    // 创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
			f.mkdir();     //创建此抽象路径名指定的目录。
		}
	}

	public static void test4(){

		if(f.exists()){
			try {
				//f.createNewFile();
				File.createTempFile("abcd",".txt",f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void test5(){
		File [] file=f.listFiles();
		for (File f : file) {
			System.out.println(f);
			
		}
		
	}

	
	
	public static void main(String[]args){
		test1();

	}


}
