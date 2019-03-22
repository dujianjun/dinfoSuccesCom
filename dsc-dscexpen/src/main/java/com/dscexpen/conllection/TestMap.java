package com.dscexpen.conllection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
public class TestMap {

	public static void test1(){
		Map<String, Integer> map=new HashMap<>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		map.put("d", 4);

		//第一种：普遍使用，二次取值
		for (String key : map.keySet()) {
			System.out.println(key+"----->"+map.get(key));
		}
		System.out.println("*****************************");
		//第二种
		Iterator<Entry<String, Integer>> it=map.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Integer> entry = it.next();
			System.out.println(entry.getKey()+"------>"+entry.getValue());
		}
		System.out.println("*****************************");
		//第三种：推荐，尤其是容量大时
		for (Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey()+"------>"+entry.getValue());
		}
		System.out.println("*****************************");
		//第四种  通过Map.values()遍历所有的value，但不能遍历key
		for (Integer v : map.values()) {
			System.out.println("value= " + v);
		}
	}
	public static void test2(){
		Map<String, Integer> map=new HashMap<>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		map.put("a", 4);
		Iterator<Entry<String, Integer>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Integer> en=it.next();
			System.out.println(en.getKey()+"---->"+en.getValue());
		}
	}
	//entrySet返回的是Set集合
	public static void test3(){
		Map<String, Integer> map=new HashMap<>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		map.put("a", 4);
		Set<Entry<String, Integer>>  set = map.entrySet();
		Iterator<Entry<String, Integer>> it=set.iterator();
		while (it.hasNext()) {
			Entry<String, Integer> en=it.next();
			System.out.println(en.getKey()+"---->"+en.getValue());
		}
	}
	
	/**
	 * "fejljleaaafjkkd";获取字符串中每个字符出现的次数
	 * 要求打印结果a-->1,b-->2.....
	 */
	public static void test4(){
		String str="fejljleaaafjkkd";
		char[]ch=str.toCharArray();    //字符串变字符数组
		TreeMap<Character, Integer> map=new TreeMap<>();
		/*for (Character s : ch) {
			if(map.containsKey(s)){
				map.put(s, map.get(s)+1);
			}else{
				map.put(s, 1);
			}
		}*/
		for (Character s : ch) {
			Integer value=map.get(s);
			int count=1;
			if(value!=null){
				count=value+1;
			}
			map.put(s, count);
		}
		for(Entry<Character, Integer>  m: map.entrySet()){
			System.out.println(m.getKey()+"--->"+m.getValue());

		}

	}
	
	
	
	
	
	
	
	public static void main(String[]args){
		
//		Set<Map.Entry<String, Integer>> set=map.entrySet();
//		Iterator<Entry<String, Integer>> it=set.iterator();
		test4();
	}
	
}
