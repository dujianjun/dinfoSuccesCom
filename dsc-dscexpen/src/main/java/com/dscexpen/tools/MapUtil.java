package com.dscexpen.tools;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class MapUtil {
	public static Map<String,Integer> has(Map<String,Integer> map,String key){
		if(key!=null && !"".equals(key)){
			if(map!=null && map.size()>0){
				if(map.containsKey(key)){
					map.put(key, map.get(key)+1);
				}else{
					map.put(key, 1);
				}
			}else{
				map.put(key, 1);
			}
		}
		return map;
	}
	
	public static Map<String,Integer> has(Map<String,Integer> map,String key,int value){
		if(key!=null && !"".equals(key)){
			if(map!=null && map.size()>0){
				if(map.containsKey(key)){
					map.put(key, map.get(key)+value);
				}else{
					map.put(key, value);
				}
			}else{
				map.put(key, value);
			}
		}
		return map;
	}
	
	/**
	 * HashMap按值进行排序
	 * @author dujj
	 *
	 */
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue( Map<K, V> map )  
{  
    List<Entry<K, V>> list =
        new LinkedList<Entry<K, V>>( map.entrySet() );
    Collections.sort( list, new Comparator<Entry<K, V>>()
    {  
        public int compare( Entry<K, V> o1, Entry<K, V> o2 )
        {  
            return (o1.getValue()).compareTo( o2.getValue() );  
        }  
    } );  

    Map<K, V> result = new LinkedHashMap<K, V>();  
    for (Entry<K, V> entry : list)
    {  
        result.put( entry.getKey(), entry.getValue() );  
    }  
    return result;  
}  

	
	/**
     * 获取map中第一个数据值
     *
     * @param <K> Key的类型
     * @param <V> Value的类型
     * @param map 数据源
     * @return 返回的值
     */
    public static <K, V> V getFirstOrNull(Map<K, V> map) {
        V obj = null;
        for (Entry<K, V> entry : map.entrySet()) {
            obj = entry.getValue();
            if (obj != null) {
                break;
            }
        }
        return obj;
    }
    
    /**
     * 获取map中第一个key值
     *
     * @param <K> Key的类型
     * @param <V> Value的类型
     * @param map 数据源
     * @return 返回的值
     */
    public static <K, V> K getFirstOrNullkey(Map<K, V> map) {
        K obj = null;
        for (Entry<K, V> entry : map.entrySet()) {
            obj = entry.getKey();
            if (obj != null) {
                break;
            }
        }
        return obj;
    }
    
    public static <K, V> String getBigValueKey(Map<K, V> map) {
    	String value=null;
    	StringBuffer sb = new StringBuffer();
    	V firstOrNull = getFirstOrNull(map);
    	Iterator<K> it = map.keySet().iterator();
    	int i=0;
		while(it.hasNext()){
			i++;
			String mapkey = (String) it.next();
			if(map.get(mapkey)==firstOrNull){
				if(i==map.size()){
					sb.append(mapkey);
				}else{
					sb.append(mapkey+",");
				}
			}
		}
		String returnString = sb.toString();
		if(returnString.endsWith(",")){
			value = returnString.substring(0, returnString.lastIndexOf(","));
		}else{
			value = returnString;
		}
		
        return value;
    }
    
    public static <K, V> void printMap(Map<K, V> map){
    	Iterator<K> it = map.keySet().iterator();
		while(it.hasNext()){
			String mapkey = (String) it.next();
			System.out.println(mapkey+":::"+map.get(mapkey));
		}
    }
    public static <K, V> String printMap2(Map<K, V> map,String k){
    	Iterator<K> it = map.keySet().iterator();
    	StringBuffer returnStr = new StringBuffer();
		while(it.hasNext()){
			String mapkey = (String) it.next();
			returnStr.append(k+"@"+mapkey+";");
		}
		return returnStr.toString();
    }
    
}
