package com.dscexpen.conllection;

public class TestFanXing<QQ> {
	
	private QQ q;

	public QQ getQ() {
		return q;
	}

	public void setQ(QQ q) {
		this.q = q;
	}
   public  <W>void show(W w){
	   System.out.println("show::"+w);
    }
    public void print(QQ q){
    	System.out.println("print::"+q);
    }
    /**
     * 如果方法为静态时，不能访问类上定义的泛型，如果静态方法使用泛型，只能
     * 将泛型定义在方法上
     * @param y
     */
    public static <Y>void test1(Y y){
    	System.out.println("test1:::"+y);
    }


	public static void main(String[] args) {
		TestFanXing<String> tf=new TestFanXing<>();
		tf.show("adb");
		tf.show(new Integer(11));
		tf.print("adb");
	//	tf.print(new Integer(11));   //其方法里没有定义泛型
		TestFanXing.test1("aaa");
		

	}

}
