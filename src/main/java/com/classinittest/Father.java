package com.classinittest;
/** 
 * @author: wj
 * @version:  v1
 * @date:2018年7月26日 下午1:47:16
 * @description:父类
 */
public class Father {
	private String name="father";
	private String desc="father test class";
	private static String str="static member";
	
	/*
	 * 父类普通代码块
	 */
	{
		System.out.println("father's common code block init.....");
		System.out.println("father's name="+name);
	}
	
	/*
	 * 父类静态代码块
	 */
	static{
		System.out.println("father's static code block init.....");
		System.out.println("father's static member str="+str);
	}
	
	/*
	 * 父类无参数构造器
	 */
	public Father(){
		System.out.println("father's constructor run.....");
	}
}
