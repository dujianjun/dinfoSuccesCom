package com.dscexpen.conllection;

import com.dscexpen.model.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;


public class collections {
	
	public static void test1(){
		List<String> list=new ArrayList<>();
		list.add("fja");
		list.add("fa");
		list.add("rio");
		list.add("uiotu");
		list.add("aaf");
		list.add("vljf");
		
	//	Collections.sort(list);//对list进行升序排列
	//	Collections.replaceAll(list, "fa", "aaa");//替换集合中元素
		
		/*Collections.sort(list,new Comparator<String>() {  //进行按字符长度排序，字符长度相等册按字母顺序排序
			@Override
			public int compare(String o1, String o2) {
				int h=o1.length()-o2.length();
				return h==0?o1.compareTo(o2):h;
			}
		});*/
		
//		Collections.reverse(list);//把list中元素逆序
//		Collections.shuffle(list);//随机置换集合钟元素位置
		Collections.fill(list, "aa");//用aa替换集合中所有元素
		System.out.println(list);
	}
	
	public static void test2(){
		/*TreeSet<String> ts = new TreeSet<>(Collections.reverseOrder());//对treeset逆序排列
		TreeSet<String> ts = new TreeSet<>(Collections.reverseOrder());
		ts.add("aaaaa");
		ts.add("rbc");
		ts.add("rer");
		ts.add("ra");
		ts.add("poue");*/
		//把已有的比较器强制逆序
		TreeSet<Person> ts=new TreeSet<Person>(Collections.reverseOrder(new sortByAge()));
		ts.add(new Person("ab", 28));
		ts.add(new Person("neb", 19));
		ts.add(new Person("fgb", 19));
		ts.add(new Person("zab", 21));
		
		Iterator<Person> it = ts.iterator();
		while (it.hasNext()) {
			Person p = it.next();
			System.out.println(p.getName()+"-->"+p.getAge());
		}
	}
	public static void test3(){
		List<String> list = new ArrayList<>();
	      list=Collections.synchronizedList(list);//返回一个线程安全的list
		
	}


	/**
	 * 测试集合合并后原有顺序不会改变
	 */
	public static void test4(){
		  /*测试合并两个类型相同的list*/
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		//给list1赋值
		list1.add("测");
		list1.add("试");
		list1.add("一");
		list1.add("下");
		//给list2赋值
		list2.add("合");
		list2.add("并");
		list2.add("列");
		list2.add("表");
		//将list1.list2合并
		list2.addAll(list1);
		//循环输出list1 看看结果
		for (String s : list2) {
			System.out.print(s);
		}
	}
	

	public static void main(String[] args) {
		test4();

	}

}
