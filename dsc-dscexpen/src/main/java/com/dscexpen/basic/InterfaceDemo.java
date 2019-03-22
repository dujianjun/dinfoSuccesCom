package com.dscexpen.basic;

public class InterfaceDemo {
	/**
	 * 之所以不能多继承，是应为方法体的不确定性。
	 * 接口支撑多继承，因为接口方法没有方法体
	 * @author cheng
	 *
	 */
	
	interface AA{
		
	}
	interface BB{
		
	}
	interface cc extends AA,BB{
		
	}

	public static void main(String[] args) {

	}

}
