package com.dscexpen.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class InputStreamAndOutPutStrem {

	//输入流
	public static StringBuffer testInputStream(){
		File file=new File("C:\\Users\\cheng\\Desktop\\bb.txt");  
		StringBuffer sb=null;
		BufferedReader br = null;
		try {
			sb=new StringBuffer();
			FileInputStream fis=new FileInputStream(file);  //节点流
			InputStreamReader isr=new InputStreamReader(fis,"utf-8");  //转换流
			br = new BufferedReader(isr);
			String line="";
			while ((line=br.readLine())!=null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		System.out.println("读取成功");
		return sb;
	}
	//输出流                                    
	public static void testOutputStream(){
		StringBuffer sb=testInputStream();
		File file=new File("C:\\Users\\cheng\\Desktop\\bbb.txt");  
		BufferedWriter bw = null;
		try {
			FileOutputStream fos=new FileOutputStream(file);
			OutputStreamWriter  osw=new OutputStreamWriter(fos, "utf-8");
			bw = new BufferedWriter(osw);
			bw.write(sb.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(bw!=null){
				try {
					bw.flush();
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("写入成功");

	}


	public static void main(String[]args) throws IOException{
	//	System.out.println("testOutputStream".equalsIgnoreCase("testOutputStrem"));
	//	testOutputStream2();
		// testOutputStream();
	}
}
