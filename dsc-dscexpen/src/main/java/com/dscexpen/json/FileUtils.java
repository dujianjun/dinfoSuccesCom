package com.dscexpen.json;

import net.sf.json.JSONArray;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FileUtils {
    public static void test1() {
        return;
    }

    private static String path = "city.txt";

    public static JSONArray readFile() {
        String path = FileUtils.class.getResource("/").getPath() + "com/geex/file/dd.txt";
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "utf-8"));
            String s = null;
            while ((s = br.readLine()) != null) {
                System.out.println(System.lineSeparator());
                result.append(s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String str = result.toString();
       // JSONObject jsonObject = JSONObject.fromObject(result.toString());
        JSONArray jsonObject = JSONArray.fromObject(result.toString());
        return jsonObject;

    }

    public static void main(String[] args) throws ParseException {

/*

        String dateToStrFor = TimeUtils.dateToStrFor(new Date(), "yyyy-MM-dd HH:ss:mm");
        System.out.println(dateToStrFor);
*/

        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     //   Date bt = sdf.parse("2018-09-12");
        System.out.println(format.format(new Date()));

      /*  if (bt.before(now) && StringUtils.isEmpty(coreRepayPlan.getFinishDate())) {
            yxsyncRepayPLANInfo.setChangeOverdue(true);
        }*/



       /* JSONArray jsonObject = readFile();
        for(int i=0;i<jsonObject.size();i++){
            JSONObject job = jsonObject.getJSONObject(i);
            if ("1".equals(job.get("status"))) {
                continue;
            }
            System.out.println("1111111111");
*/
        }
    }






