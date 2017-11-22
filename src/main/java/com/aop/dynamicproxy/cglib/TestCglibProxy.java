package com.aop.dynamicproxy.cglib;

import net.sf.cglib.proxy.Enhancer;

public class TestCglibProxy {
	
	/**
	 * cglib实现动态代理过程：
	 * 	1.定一个拦截器实现MethodInterceptor接口，重写intercept方法，增加横切逻辑
	 * 	2.创建Enhancer对象，setSuperClass()设置被代理类，setCallback()设置定义的拦截器
	 * 	3.调用create()方法创建代理类对象
	 * 
	 * cglib实现动态代理原理：通过继承的方式，动态生成class文件，代理所有非final方法
	 * 
	 * cglib动态代理与jdk动态代理实现对比：
	 * 	1.jdk动态代理是基于实现接口的方式，代理接口中定义方法。
	 * 	2.cglib通过继承的方式实现，代理父类中的非final方法。
	 * 	3.两种方式都是动态生成class字节码文件，都不能代理final方法
	 * 
	 */
	public static void main(String[] args) {
		Enhancer enhancer=new Enhancer();
		enhancer.setSuperclass(TargetObject.class);
		enhancer.setCallback(new TargetMethodInterceptor());
		TargetObject proxy=(TargetObject) enhancer.create();
		proxy.method1("123");
		proxy.method2("456");
	}

}
