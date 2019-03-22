package com.dscexpen.basic;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
	@Test
	public  void test1() {
		Pattern p = Pattern.compile("^\\\\$");
		Matcher m = p.matcher("\\\\");
		while (m.find()){
			//System.out.println(m.matches());
			System.out.println(m.group());
		}


	}

	public static void test2() {
		boolean b = Pattern.matches("a*b", "aaaaaab");
		System.out.println(b);

		Pattern p = Pattern.compile("a*b");
		Matcher m = p.matcher("aabxxx");
		boolean b1 = m.lookingAt();
		System.out.println(b1);
	}

	public void test3() {
		String str = "我想求购一本《疯狂Java讲义》，尽快联系我13500006666"
				+ "交朋友，电话号码是13611125565"
				+ "出售二手电脑，联系方式15899903312";
		Matcher m = Pattern.compile("((13\\d)|(15\\d))\\d{8}")
				.matcher(str);
		while (m.find()) {
			System.out.println(m.group() + "   起始位置：" + m.start() + "     结束位置：" + m.end());
		}

	}
	/*public static void test4(){
		String[] mails =
			{
					"kongyeeku@163.com" ,
					"kongyeeku@gmail.com",
					"ligang@crazyit.org",
					"wawa@abc.xx"
			};
		String mailRegEx = "\\w{3,20}@\\w+\\.(com|org|cn|net|gov)";
		Pattern mailPattern = Pattern.compile(mailRegEx);
		Matcher matcher = null;
		for (String mail : mails)
		{
			if (matcher == null)
			{
				matcher = mailPattern.matcher(mail);
			}
			else
			{
				matcher.reset(mail);
			}
			String result = mail + (matcher.matches() ? "是" : "不是")
					+ "一个有效的邮件地址！";
			System.out.println(result);
		}

	}
	public static void test5(){
		String[] msgs =
			{
					"Java has regular expressions in 1.4",
					"regular expressions now expressing in Java",
					"Java represses oracular expressions"
			};
		Pattern p = Pattern.compile(" re\\w*");
		Matcher matcher = null;
		for (int i = 0 ; i < msgs.length ; i++)
		{
			if (matcher == null)
			{
				matcher = p.matcher(msgs[i]);
			}
			else
			{
				matcher.reset(msgs[i]);
			}
			System.out.println(matcher.replaceAll("哈哈:)"));
		}

	}

	public static void test6(){
		Pattern p = Pattern.compile("\\d{3,5}");
        String s = "123-34345-234-00";
        Matcher m = p.matcher(s);
        System.out.println(m.find()+"  start at:"+m.start()+" end at:"+m.end());
        System.out.println(m.find()+"  start at:"+m.start()+" end at:"+m.end());
    //  System.out.println(m.find()+"start at:"+m.start()+" end at:"+m.end());
    //  System.out.println(m.find()+"start at:"+m.start()+" end at:"+m.end());
        m.reset();
        System.out.println(m.find()+"start at:"+m.start()+" end at:"+m.end());
        System.out.println(m.find()+"start at:"+m.start()+" end at:"+m.end());

	}

	public static void test7(String str){
		Pattern p=Pattern.compile("a++",Pattern.CASE_INSENSITIVE);
		Matcher m=p.matcher(str);
		while (m.find()) {
			System.out.println(m.group());
		}
	}
	//匹配

	//分割
	public static void test8(){
		String str="actttttbweeeeecx";
		String[] s=str.split("(.)\\1+");  //\\s+?\\w==\\s+
		for (String ss : s) {
			System.out.println(ss.trim());
		}
	}
	//替换
	public static void test9(){
		String str1="actttttbweeeeecx";
		str1=str1.replaceAll("(.)\\1+", " $1 ");
		System.out.println(str1);

		String str="15801234768";
		str=str.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");//每个（） 是一组，$1表示第一组，$2表示第二组
		System.out.println(str);

	}

	//获取
	public static void test10(){
		String str="da jia hao,ming tian bu fang jia";
		Pattern p=Pattern.compile("\\b[a-z]{3}\\b");
		Matcher m=p.matcher(str);
		while (m.find()) {
			System.out.println(m.group());
		}
	}

	//IP排序
	public static void test11(){
		String str="192.168.10.34  127.0.0.1   3.3.3.3   105.170.11.55";
		str=str.replaceAll("(\\d+)", "00$1");   //把ip字段前都加两个0
		str=str.replaceAll("0*(\\d{3})", "$1");  //所有IP字段均保留三位
		String[]str1=str.split("\\s+");   //根据控制拆分字符串
		TreeSet<String> ts=new TreeSet<>();//；利用空格TreeSet排序
		for (String s : str1) {
			ts.add(s);
		}
		for (String s: ts) {
			System.out.println(s);
		}
	}
*/

	/**
	 * 爬取网页符合格式的邮箱
	 * @return
	 * @throws Exception
	 */

	public List<String> getMail() throws Exception{
		List<String> list=new ArrayList<>();
		//	FileInputStream fis=new FileInputStream("");
		URL url=new URL("https://zhidao.baidu.com/question/398668279.html");
		InputStreamReader isr=new InputStreamReader(url.openStream(),"utf-8");
		BufferedReader br=new BufferedReader(isr);
		String regex_mail="\\w+@\\w+(\\.\\w)+";
		Pattern p=Pattern.compile(regex_mail);
		String line="";
		while ((line=br.readLine())!=null) {
			Matcher m=p.matcher(line);
			while (m.find()) {
				list.add(m.group());
			}
		}
		return list;
	}
}
