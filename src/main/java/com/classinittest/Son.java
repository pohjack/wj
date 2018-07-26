package com.classinittest;
/** 
 * @author: wj
 * @version:  v1
 * @date:2018年7月26日 下午1:52:12
 * @description:
 */
public class Son extends Father {
	private String sonName="son";
	private String sonDesc="son's desc";
	
	/*
	 * 子类普通代码块
	 */
	{
		System.out.println("son's common code block init......");
	}
	
	/*
	 * 子类静态代码块
	 */
	static{
		System.out.println("son's static code block init.....");
	}
	
	/*
	 * 子类构造器
	 */
	public Son(){
		System.out.println("son's constructor run....");
	}
}
