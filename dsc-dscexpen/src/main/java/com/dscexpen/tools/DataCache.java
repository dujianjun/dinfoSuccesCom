package com.dscexpen.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class DataCache {

    public static Map<String,String> dataMap= null;
    private static DataCache instance = null;
    private final Object obj = new Object();

    /**
     * 构造方法
     * */
    private DataCache( ){
    	dataMap=new HashMap<String, String>();
    }
    
    /**
     * 创建单例
     * @return instance
     * */
    public static  DataCache getInstance( ){
        if(instance == null){
            instance = new DataCache();
        }
        return instance;
    }

	/**
	 * 添加数据缓存
	 * @param key
	 * @param value
	 * @return
	 */
	public  int putData(String key,String value){
    	synchronized (obj) {
	        int r = 0;
	        try{
	            dataMap.put(key, value);
	        }catch (Exception e) {
	            r = 1;
	            e.printStackTrace();
	        }
	        return r;
    	}
    }

	/**
	 * 添加数据缓存
	 * @param screenId
	 * @param childId
	 * @param value
	 * @return
	 */
    public  int putData(String screenId,String childId,String value){
    	synchronized (obj) {
	        int r = 0;
	        String key = screenId+"_"+childId;
	        try{
	            dataMap.put(key, value);
	        }catch (Exception e) {
	            r = 1;
	            e.printStackTrace();
	        }
	        return r;
    	}
    }
    
    /**
     * 移除数据缓存
     * @param key
     * @return r
     * */
    public  int removeData(String key){
    	synchronized (obj) {
	        int r = 0;
	        try{
	            dataMap.remove(key);
	        }catch (Exception e) {
	            r = 1;
	            e.printStackTrace();
	        }
	        return r;
    	}
    }

	/**
	 * 移除数据缓存
	 * @param screenId
	 * @param childId
	 * @return
	 */
	public  int removeData(String screenId,String childId){
    	synchronized (obj) {
	        int r = 0;
	        try{
	            String key = screenId+"_"+childId;
	            dataMap.remove(key);
	        }catch (Exception e) {
	            r = 1;
	            e.printStackTrace();
	        }
	        return r;
    	}
    }

	/**
	 * 清空所有数据缓存
	 * @return
	 */
	public  int removeData(){
    	synchronized (obj) {
	        int r = 0 ; 
	        try{
	            dataMap.clear();
	        }catch(Exception e){
	            r = 1;
	            e.printStackTrace();
	        }
	        return r;
    	}
    }

	/**
	 * 获取数据缓存
	 * @param key
	 * @return
	 */
	public String getDataByKey(String key){
    	synchronized (obj) {
	        String value = null;
	        Set<String> set = dataMap.keySet();
	        Iterator<String> iter = set.iterator();
	        while (iter.hasNext()) {
	        	String next =iter.next();
	            if(next.equalsIgnoreCase(key))
	            {
	            	value = dataMap.get(next);
	            }
	        }
	        return value;
    	}
    }
/**
 * 判断缓存文件里面是否有key
 * @param key
 * @return
 */
    public  boolean estimateKey(String key){
    	synchronized (obj) {
    	 Set<String> set = dataMap.keySet();
         if(set.contains(key)){
        	 return true;
         }else{
        	 return false;
         }
    	}
    }


	/**
	 * 获取数据缓存
	 * @param screenId
	 * @param childId
	 * @return
	 */
	public  String getDataByKey(String screenId,String childId){
    	synchronized (obj) {
	        String value = null;
	        String key = screenId+"_"+childId;
	        Set<String> set = dataMap.keySet();
	        Iterator<String> iter = set.iterator();
	        while (iter.hasNext()) {
	        	String next =iter.next();
	            if(next.equalsIgnoreCase(key))
	            {
	            	value = dataMap.get(next);
	            }
	        }
	        return value;
    	}
    }
    
    /**
     * 获取所有数据缓存
     * @return wsList
     * */
    public  List<String> getDataAll(){
    	synchronized (obj) {
	        List<String> dataList = new ArrayList<String>();
	        Set<String> set = dataMap.keySet();
	        Iterator<String> iter = set.iterator();
	        while (iter.hasNext()) {
	            String key = iter.next();
	            dataList.add(dataMap.get(key));
	        }
	        return dataList;
    	}
    }
    
    /**
     * 获取所有数据缓存的key
     * */
    public  Set<String> getDataKeySet(){
    	synchronized (obj) {
        return dataMap.keySet();
    	}
    }
    
}
