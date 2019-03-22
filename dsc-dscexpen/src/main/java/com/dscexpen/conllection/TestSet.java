package com.dscexpen.conllection;

import com.dscexpen.model.Person;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;


public class TestSet {

	public static void test1(){
		HashSet<String> hs=new HashSet<>();
		hs.add("ab");
		hs.add("ac");
		hs.add("ad");
		hs.add("ae");
		/*Iterator<String> it=hs.iterator();
		while (it.hasNext()) {
			String s = (String) it.next();
			System.out.println(s);

		}*/
		for (String s : hs) {
			System.out.println(s);
		}
	}

	//TreeSet存储类实现comparable接口
	private static void test2() {
		TreeSet<Person> ts=new TreeSet<>();
		ts.add(new Person("ab", 28));
		ts.add(new Person("neb", 19));
		ts.add(new Person("fgb", 19));
		ts.add(new Person("zab", 21));

		for (Person p : ts) {
			System.out.println(p.getName()+"---->"+p.getAge());

		}
	}
	//TreeSet使用comparator排序器
	private static void test3() {
		TreeSet<Person> ts=new TreeSet<Person>(new sortByAge());
		ts.add(new Person("ab", 28));
		ts.add(new Person("neb", 19));
		ts.add(new Person("fgb", 19));
		ts.add(new Person("zab", 21));

		for (Person p : ts) {
			System.out.println(p.getName()+"---->"+p.getAge());

		}
	}
	//用comparator实现字符串按长度从小到大的排序。
	private static void test4() {
		TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int h=o1.length()-o2.length();
				return h==0?o1.compareTo(o2):h;
			}
		});
		ts.add("aaaaa");
		ts.add("rbc");
		ts.add("rer");
		ts.add("ra");
		ts.add("poue");
		Iterator<String> it = ts.iterator();
		while (it.hasNext()) {
			String s = (String) it.next();
			System.out.println(s);
		}
	}
	
	private static void test5(){
		LinkedHashSet<Person> lh = new  LinkedHashSet<>();
		lh.add(new Person("ab", 28));
		lh.add(new Person("neb", 19));
		lh.add(new Person("fgb", 19));
		lh.add(new Person("zab", 21));
		Iterator<Person> it = lh.iterator();
		while (it.hasNext()) {
			Person p = (Person) it.next();
			System.out.println(p.getName()+"---->"+p.getAge());
		}
		
	}
			

	public static void main(String[] args) {
                    test5();
	}


}
