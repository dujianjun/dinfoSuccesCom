package com.dscexpen.conllection;

import java.util.Properties;
import java.util.Random;
import java.util.Set;

public class TestOtherTools {
	/**
	 * system 对象
	 * @throws Exception 
	 */
	public static void test1() throws Exception{
		long first=System.currentTimeMillis();
		Thread.sleep(1000);
		long second=System.currentTimeMillis();
		System.out.println(second-first);
		
	}
	public static void test2(){
		Properties prop=System.getProperties();
		Set<String> set=prop.stringPropertyNames();
		for (String s: set) {
			String value=prop.getProperty(s);
			System.out.println(s+"--->"+value);
		}
	}
	
	/**
	 * runtime  对象
	 * 其没有构造方法，说明该类不可创建对象，又有非静态方法，说明该类有静态的返回该类对象的方法。应用了单例模式获得对象
	 * @param args
	 * @throws Exception 
	 * @throws Exception
	 */
	public static void test3() throws Exception{
		Runtime r=Runtime.getRuntime();//获得runtime对象
		Process p=r.exec("notepad.exe");//打开记事本程序
		Thread.sleep(3000);
		p.destroy();//杀掉该子进程
	}
	/**
	 * math类用法
	 * @param args
	 * @throws Exception
	 */
	
	public static void test4(){
		double d1=Math.ceil(12.56);//返回大于参数的最小整数
		double d2=Math.floor(12.56);//返回小于参数的最大整数
		double d3=Math.round(12.56);//返回四舍五入的整数
		System.out.println(d1+"__"+d2+"__"+d3);

		int i=Math.max(4, 3);//返回参数中较大一个
		System.out.println(i);

		double y=Math.pow(2, 3);//返回2的3次方的值
		System.out.println(y);

		for (int j = 0; j < 10; j++) {
			double t=Math.random();//返回0和1之间的随机数
			System.out.println(t);
		}

	}
	
	public static void test5(){
		Random random=new Random();
		for (int i = 0; i < 10; i++) {
			int t=random.nextInt(5);
			System.out.println(t);
		}
	}
	
	
	
	

	public static void main(String[] args) throws Exception {
		test2();

	}

}
