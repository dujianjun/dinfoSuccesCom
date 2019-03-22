package com.dscexpen.conllection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestList {
	public static void test1(){
		List<String> list=new  ArrayList<String>(); 
		list.add("aa");
		list.add("ab");
		list.add("ac");
		list.add("ad");
		System.out.println(list.size());
		System.out.println(list);
		System.out.println(list.toString());
		System.out.println(list.contains("ac"));
		//list.forEach(obj->System.out.println("lambda遍历集合："+obj));
	}
	public static void test2(){
		List<String> list=new  ArrayList<String>(); 
		list.add("aa");
		list.add("ab");
		list.add("ac");
		list.add("ad");
		List<String> list1=new ArrayList<String>();
		list1.add("aa");
		list1.add("ab");
	//	System.out.println(list.removeAll(list1)); //去掉重复项
		System.out.println(list.retainAll(list1));  //保留重复项
		System.out.println(list);
	}
	public static void test3(){
		LinkedList<String>  ll=new LinkedList<>();
		ll.add("ab");
		ll.add("ac");
		ll.add("ad");
		ll.add("ae");
		for (int i = 0; i < ll.size(); i++) {
			System.out.println(ll.get(i));

		}
	}

	public static void main(String[] args) {

		LinkedList<String>  aa=new LinkedList<>();
		aa.add("a");
		aa.add("b");

		LinkedList<String>  bb=new LinkedList<>();
		bb.add("c");
		bb.add("d");

		aa.addAll(bb);
		for (int i = 0; i < aa.size(); i++) {
			System.out.println(aa.get(i));

		}

	}

}
