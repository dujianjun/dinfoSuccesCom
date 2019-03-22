package com.dscexpen.string;


import java.util.Arrays;

public class TestString {

    public static void test1() {
        String str = "hello Jvaa,i like you veramuch!";
        String s = "Hello java ,I like you.  ";
        //	System.out.println(str.endsWith("much!"));
        //	System.out.println(str.contains("much"));
        //	System.out.println(str.indexOf("aa"));
        int id = str.indexOf("aa");
        System.out.println(id + "----" + str.substring(id));
        //	System.out.println(s.trim());
        //	System.out.println(str.replaceAll("\\s", "--"));
        //	System.out.println(s.replace(" ", "<>"));
        //	System.out.println(s.replace(" ", ""));
        //	System.out.println(s.valueOf("2"));
        //	System.out.println(s.startsWith("H"));
        //	System.out.println(s.substring(1, 3));
        //	System.out.println(s.lastIndexOf("you"));
        //	System.out.println(s.lastIndexOf(25));
    }

    public static void test2() throws Exception {
        String str = "你好";
        byte[] buf = str.getBytes("utf-8");
        for (byte b : buf) {
            System.out.println(b);
        }
        String s1 = new String(buf, "utf-8");
        System.out.println(s1);

    }

    /**
     * 字符串本身带正则匹配方法
     */
    public static void test3() {
        String str = "ddsa";
        System.out.println(str.matches("^[a-z|A-Z]{3,5}$"));

    }

    public static void test4() throws Exception {
        String str = "阿拉上海";
        byte[] bytes = str.getBytes("GBK");
        String gbk = new String(bytes, "GBK");
        System.out.println(gbk);


        String str1 = "阿拉上海";
        System.out.println(Arrays.toString(str.getBytes("GBK")));
        System.out.println(Arrays.toString(str1.getBytes("utf-8")));
    }


    public static void main(String[] args) throws Exception {
        test4();
        //	test3();
//		List<Integer> list=new ArrayList<>();
//		for(int i=0;i<70;i++){
//			list.add(i);
//		}
//		System.out.println(Count(list));
    }
}
