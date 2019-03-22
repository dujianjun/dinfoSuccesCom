package com.dscexpen.conllection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestArrays {
	/**
	 * 数组转集合
	 */
	public static void test1(){
		String[]arr={"heihei","xixi","haha","hehe"};
	//	System.out.println(Arrays.toString(arr));
		List<String> list = Arrays.asList(arr);
	//	list.add("aa");   //转化过来的集合不能做增、删remove、清空clear\操作，即改变数组长度的方法均不可用
		System.out.println(list);
	}
	/**
	 * 集合转数组
	 */
	public static void test2(){
		List<String> list=new ArrayList<>();
		list.add("ab");
		list.add("ac");
		list.add("ad");
		String []str=list.toArray(new String[2]);
		System.out.println(Arrays.toString(str));
	}
	/**
	 * 可变参数的用法
	 * 实际是一个数组，接受的是数组元素，自动将这些元素封装成数组
	 * 可变参数类型必须定义在参数列表的结尾处；
	 * @param arr
	 * @return
	 */
	public static int test3(int a,int...arr){  //参数相当于整型数组
		int sum=0;
		for (int i : arr) {
			sum+=i;
		}
		System.out.println(a+"---"+sum);
		return sum;
	}
	
	
	
	
	//Arrays toString 的 经典用法
	public static String toString(int[] a) {
		if (a == null)
			return "null";
		int iMax = a.length - 1;
		if (iMax == -1)
			return "[]";

		StringBuilder b = new StringBuilder();
		b.append('[');
		for (int i = 0; ; i++) {
			b.append(a[i]);
			if (i == iMax)
				return b.append(']').toString();
			b.append(", ");
		}
	}

	public static void main(String[] args) {
               test3(5,6,3,2);
               // test1();
	}

}
