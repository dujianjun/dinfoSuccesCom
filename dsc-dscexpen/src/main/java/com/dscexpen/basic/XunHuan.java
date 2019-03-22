package com.dscexpen.basic;

public class XunHuan {
	private static void test1() {
		
		for (int i = 0; i < 20; i++) {
			if(i==10||i==15){
		//		break;
				continue;
			}
			
			System.out.println(i);
		}
		
	}
	

	public static void main(String[] args) {
		 test1();
	}

}
