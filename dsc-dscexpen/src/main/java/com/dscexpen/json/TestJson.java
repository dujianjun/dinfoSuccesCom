package com.dscexpen.json;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TestJson<MyBeanWithPerson> {
	  /*
     *  普通类型、List、Collection等都是用JSONArray解析
     *  
     *  Map、自定义类型是用JSONObject解析
     *  可以将Map理解成一个对象，里面的key/value对可以理解成对象的属性/属性值
     *  即{key1:value1,key2,value2......}
     * 
     * 1.JSONObject是一个name:values集合，通过它的get(key)方法取得的是key后对应的value部分(字符串)
     *         通过它的getJSONObject(key)可以取到一个JSONObject，--> 转换成map,
     *         通过它的getJSONArray(key) 可以取到一个JSONArray ，
     * 
     * 
     */
	 //一般数组转换成JSON
    public void testArrayToJSON(){
        boolean[] boolArray = new boolean[]{true,false,true};  
        JSONArray jsonArray = JSONArray.fromObject( boolArray );  
        System.out.println( jsonArray );  
    }
    
    //Collection对象转换成JSON
    public void testListToJSON(){
        List<String> list = new ArrayList<>();  
        list.add( "first" );  
        list.add( "second" );  
        JSONArray jsonArray = JSONArray.fromObject( list );  
        System.out.println( jsonArray );  
    }
    
    //字符串json转换成json， 根据情况是用JSONArray或JSONObject
    public void testJsonStrToJSON(){
        JSONArray jsonArray = JSONArray.fromObject( "['json','is','easy']" );  
        System.out.println( jsonArray );  
    }
     
    //Map转换成json， 是用jsonObject
    public void testMapToJSON(){
        Map map = new HashMap();  
        map.put( "name", "json" );  
        map.put( "bool", Boolean.TRUE );  
        map.put( "int", new Integer(1) );  
        map.put( "arr", new String[]{"a","b"} );  
        map.put( "func", "function(i){ return this.arr[i]; }" );  
           
        JSONObject jsonObject = JSONObject.fromObject( map );  
        System.out.println( jsonObject );  
    }
   
    //普通类型的json转换成对象
    @Test
    public void testJSONToObject() throws Exception{
        String json = "{name=\"json\",bool:true,int:1,double:2.2,func:function(a){ return a; },array:[1,2]}";  
        JSONObject jsonObject = JSONObject.fromObject( json ); 
        System.out.println(jsonObject);
        Object bean = JSONObject.toBean( jsonObject ); 
        assertEquals( jsonObject.get( "name" ), PropertyUtils.getProperty( bean, "name" ) );  
        assertEquals( jsonObject.get( "bool" ), PropertyUtils.getProperty( bean, "bool" ) );  
        assertEquals( jsonObject.get( "int" ), PropertyUtils.getProperty( bean, "int" ) );  
        assertEquals( jsonObject.get( "double" ), PropertyUtils.getProperty( bean, "double" ) );  
        assertEquals( jsonObject.get( "func" ), PropertyUtils.getProperty( bean, "func" ) );  
//        System.out.println(PropertyUtils.getProperty(bean, "name"));
//        System.out.println(PropertyUtils.getProperty(bean, "bool"));
//        System.out.println(PropertyUtils.getProperty(bean, "int"));
//        System.out.println(PropertyUtils.getProperty(bean, "double"));
//        System.out.println(PropertyUtils.getProperty(bean, "func"));
//        System.out.println(PropertyUtils.getProperty(bean, "array"));
         
        List arrayList = (List)JSONArray.toCollection(jsonObject.getJSONArray("array"));
        for(Object object : arrayList){
            System.out.println(object);
        }
    }
  
    
	public static void main(String[] args) throws Exception {
		TestJson tj=new TestJson();
//		tj.testArrayToJSON();
//		tj.testListToJSON();
		tj.testJsonStrToJSON();
	//	tj.testJSONToObject();
		

	}

}
