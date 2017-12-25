package com.springannotationconfig.bean;
/** 
 * @author: wj
 * @version:  v1
 * @date:2017年12月21日 下午4:48:17
 * @description:
 */
public class TestBean {
	public static String desc="TestBean.des";
	
	public String hello(){
		return "hello spring boot";
	}
	public void init(){
		System.out.println("TestBean init method");
	}
	public void cleanUp(){
		System.out.println("TestBean destroy method");
	}
}
