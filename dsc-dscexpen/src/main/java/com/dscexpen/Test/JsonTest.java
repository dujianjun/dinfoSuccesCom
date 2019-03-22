package com.dscexpen.Test;

import net.sf.json.JSONArray;

import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 * Program Name:
 * author :dujianjun
 * Date:2019-01-16  16:35  星期三
 * version 1.0
 */
public class JsonTest {

    /**
     *将List数据封装成json
     */
    public static JSONArray listToJson(List<String> items){
        JSONArray jsonArray = null;
        if(items != null){
            jsonArray = JSONArray.fromObject(items);
        }else {
            return  null;
        }
        return  jsonArray;
    }

    /**
     *将json数据封装成List
     */
    public static List<String> jsonToList(String jsonStr) {
        JSONArray jsonarray = JSONArray.fromObject(jsonStr);
        List<String> list = (List) JSONArray.toCollection(jsonarray, String.class);
        return list;

    }

    public static void main(String[] args) {
      /*  String str = "[ \"Google\", \"Runoob\", \"Taobao\" ]";
        List<String> strings = jsonToList(str);
        System.out.println(strings.toString());*/


        List<String> list = new LinkedList();
        for(int i=0;i<1;i++){
            list.add("111");
            list.add("222");
            list.add("333");
        }
        System.out.println(listToJson(list));
    }

}
