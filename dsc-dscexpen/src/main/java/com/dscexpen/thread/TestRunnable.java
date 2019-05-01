package com.dscexpen.thread;


public class TestRunnable implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName());
		}
	}
	
	//除了本身创建的线程外，还有主线程在运行
	public static void test1(){
		for (int i = 0; i < 100;  i++)
		{
			System.out.println(Thread.currentThread().getName()
				+  " " + i);
			if (i == 20)
			{
				new Thread().start();
				new Thread().start();
			}
		}
	}
	
	public static void main(String[]args){
		
		
		TestRunnable tr=new TestRunnable();
		Thread t1=new Thread(tr,"a");
		Thread t2=new Thread(tr, "b");
			t1.start();
			t2.start();
		
		
	}

}
