package com.dscexpen.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class PatyUtil {
	
	private static PatyUtil patyUtil;  
	private PatyUtil (){}  
	public static synchronized PatyUtil getInstance() {  
		if (patyUtil == null) {  
			patyUtil = new PatyUtil();  
		}  
		return patyUtil;  
	}  

      /*
       * 获取省级字典
       */
	public  HashMap<String, Set<String>> getPaty() throws IOException{
		HashMap<String, Set<String>> patyMap=new HashMap<>();
		InputStream fis=PatyUtil.class.getClassLoader().getResourceAsStream("paty1.txt");
		InputStreamReader isr=new InputStreamReader(fis,"utf-8");
		BufferedReader br=new BufferedReader(isr);
		String line=null;
		while((line=br.readLine())!=null){
			String[]str=line.split("[：\\|、]");
			if(str.length>0){
				Set<String> set=new HashSet<String>();
				for (int i=1;i<str.length;i++) {
					set.add(str[i]);
				}
				patyMap.put(str[0],set);
			}
		}
		return patyMap;
	}
    /*
     * 获取市级字典
     */
	public  HashMap<String, Set<String>> getPaty2() throws IOException{
		int j=1;
		HashMap<String, Set<String>> patyMap=new HashMap<>();
		InputStream fis=PatyUtil.class.getClassLoader().getResourceAsStream("paty2.txt");
		InputStreamReader isr=new InputStreamReader(fis,"utf-8");
		BufferedReader br=new BufferedReader(isr);
		String line=null;
		while((line=br.readLine())!=null/*&&!"".equals(br.readLine())*/){
		//	System.out.println(line+"--"+j++);
			String[]str=line.split("[：\\|、]");
			if(str.length>0){
				Set<String> set=new HashSet<String>();
				for (int i=1;i<str.length;i++) {
					set.add(str[i]);
				}
				patyMap.put(str[0],set);
			}
		}
		return patyMap;
	}
  /*
   * 
   * paty 包含省时。
   * 
   *    思路：遍历省字典时，拿传过来的字符串 判断其中是否包含一个省，如果不包含则返回null；如果包含，则根据省拿到市，判断是否包含一个市，
   *如果包含，则根据市拿到区县，判断是否包含区县，如果有则返回该区县，没有返回该市。
   * 
   */
  public  String getpatyByDictionary(String paty) throws IOException{
	  HashMap<String, Set<String>> map=getPaty();
	  for(String str:map.keySet()){
		  if(paty.contains(str)||paty.contains(str.replace("省", ""))){
			 Set<String> set=map.get(str);
			 for(String st: set){
				 if(paty.contains(st)||paty.contains(st.replace("市", ""))){
					 HashMap<String, Set<String>> map2=getPaty2();
					 for(String s: map2.get(st)){
						 if(paty.contains(s)){
							 return s;
						 }
					 }
				 }
				 if(paty.contains(st)||paty.contains(st.replace("市", ""))){
					return st; 
				 }
			 }
			 if(paty.contains(str)||paty.contains(str.replace("省", ""))){
				 return str;
			 }
		  }
		  
	  }
	  return getpaty4(paty);
	  
  }

	/*
	 * 当paty不包含省但包含市时。
	 * 
	 *  思路：如果字符串中不包含省级单位，则调用改方法。
	 * 首先遍历市级字典，如果，不包含市级单位，返回null；如果包含市，则根据市拿到区县，判断其中是否包含区县，有则返回改区县。没有返回该市
	 * 
	 */
	
  public  String getpaty4(String paty) throws IOException{
	  HashMap<String, Set<String>> map=getPaty2();
	  for(String str:map.keySet()){
		//  System.out.println(str);
		  if(paty.contains(str)||paty.contains(str.replace("市", ""))){
			  for(String st: map.get(str)){
				  if(paty.contains(st)){
					  return st;
				  }
			  }
		  }
		  if(paty.contains(str)||paty.contains(str.replace("市", ""))){
			  return str;
		  }
	  }
	  
	 
	  return getpaty5(paty);
	  
  }
	/*
	 * 当paty即不包含省也不包含市时。
	 * 
	 * 思路：根据实际字典拿到地区。判断paty中是否包含地区，有返回改地区，没有返回null
	 */
  public  String getpaty5(String paty) throws IOException{
	  HashMap<String, Set<String>> map=getPaty2();
	  for(String str:map.keySet()){
		 Set<String> set=map.get(str);
		 for(String st:set){
			 if(paty.contains(st)){
				 return st;
			 }
		 }
		  
	  }
	  return null;
	  
  }	
	
 

	public static void main(String[] args) throws IOException {
		
		String str1="18.4:46.6:35.0。在地区经济的推动下，桂林市财政收入继续保持较 快增长，2012 年实现财政总收入 163.56 亿元，同比增长 15.2%。2012 年，桂林市经济及财政水平在广西壮族自治区中仍排名靠前，地区生 产总值、财政总收入及规模以上工业增加值在广西壮族自治区的 14 个 地级市中均位居第三。";
		
		String str="郑州市二七区";
		String str2="13.3增速2012 年";
		String str3=" 表1 2010～2012 年驻马店市国民经济和社会发展主要指标（单位：亿元、%） ";
		String str4 = "图表2.	2010-2012年余姚市主要经济指标情况余姚市，。余姚市实现地区生产总值711.77亿元2012年余姚市实现高新技术产业产值316.01亿元";
		String res = PatyUtil.getInstance().getpatyByDictionary(str);
		System.out.println(res+"------");



	}

}
