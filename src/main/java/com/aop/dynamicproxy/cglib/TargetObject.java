package com.aop.dynamicproxy.cglib;

/**
 * 被代理类，不实现任何接口
 * @author wj
 *
 */
public class TargetObject {
	public void method1(String param){
		System.out.println("method1 running..."+param);
	}
	public void method2(String param){
		System.out.println("method2 running..."+param);
	}

}
