package com.dscexpen.basic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @Before：初始化方法   对于每一个测试方法都要执行一次（注意与BeforeClass区别，后者是对于所有方法执行一次）
 @After：释放资源  对于每一个测试方法都要执行一次（注意与AfterClass区别，后者是对于所有方法执行一次）
 @Test：测试方法，在这里可以测试期望异常和超时时间
 @Test(expected=ArithmeticException.class)检查被测方法是否抛出ArithmeticException异常
 @Ignore：忽略的测试方法
 @BeforeClass：针对所有测试，只执行一次，且必须为static void
 @AfterClass：针对所有测试，只执行一次，且必须为static void
 一个JUnit4的单元测试用例执行顺序为：
 @BeforeClass -> @Before -> @Test -> @After -> @AfterClass;
 每一个测试方法的调用顺序为：

 @Before -> @Test -> @After;
 *
 *
 */
public class Junitt {
	

	class Mypath{
		
		public int add(int x, int y){
			return x+y;
		}
		
		public int cheng(int x, int y){
			return x*y;
		}
		
	}
	
	Mypath my;
	/**
	 * BeforeClass注解方法必须是静态方法，其只运行一次
	 */
	@BeforeClass
	public static void initClass(){
		System.out.println("beforcalss----->initclass");
	}
	@AfterClass
	public static void afterClass(){
		System.out.println("afterclass-------->afterclass");
	}
	/**
	 * 前期参数初始化
	 */
	@Before
	public void init(){
		my=new Mypath();
		System.out.println("before----->init");
	}
	@After
	public void destory(){
		my=null;
		System.out.println("destory---->destory");
	}
	
	/**
	 * timeout 测试运行时间，超过10即为超时
	 * Assert.assertEquals(expect，result)	即断言expect为预期值，result为实际值 
	 */
	@Test(timeout = 10)
	public void test1(){
		int result=my.add(10, 20);
		System.out.println(result);
		//断言
		Assert.assertEquals(30, result);
	}
	/**
	 * 希望出现expected表示的异常，单不会报错
	 */
	@Test()
	public void test2(){
	int result=	my.cheng(10, 2);
	System.out.println(result);
	Assert.assertEquals(20, result);
	}
	

}
