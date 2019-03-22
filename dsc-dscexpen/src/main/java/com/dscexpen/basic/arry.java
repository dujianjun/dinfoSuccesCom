package com.dscexpen.basic;

public class arry {
	
	public static void test1(){
		String[][]a={{"1","2","3"},{"4","5","6"}};
		
		for(int i=0;i<a.length;i++){
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(i+"--"+j+":"+a[i][j]+"   ");
			}
			System.out.println();
			
		}
	}

	public static void main(String[] args) {
		test1();
	
	}

}
