package com.dscexpen.basic;

import java.io.File;

public class testDigui {

	//求n！
	public static int digui(int number){
		if(number==1){
			return 1;
		}else{
			return number*digui(number-1);
		}
	}

	
	// 遍历文件夹
	public static void print(File f) {
		if (f != null) {
			if (f.isDirectory()) {
				File[] fileArray = f.listFiles();
				if (fileArray != null) {
					for (int i = 0; i < fileArray.length; i++) {
						// 递归调用
						print(fileArray[i]);
					}
				}
			} else {
				System.out.println(f);
			}
		}
	}
}
