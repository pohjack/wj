package com.aop.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
 * 动态代理类，实现invocationHandler接口
 */
public class ArithmeticCalculatorProxy implements InvocationHandler{
	
	private ArithmeticCalculator realSubject;
	
	public ArithmeticCalculatorProxy(ArithmeticCalculator realSubject){
		this.realSubject=realSubject;
	}
	
	public Object getProxyInstance(){
		ClassLoader loader=this.getClass().getClassLoader();
		Class[] interfaces=realSubject.getClass().getInterfaces();
		return Proxy.newProxyInstance(loader, interfaces, this);
	}
	
	/*
	 * 实现invoke方法
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before running");
		Object result;
		try{
			result=method.invoke(realSubject, args);
			System.out.println("after running");
		}catch(Exception e){
			System.out.println("exception:"+e.getMessage());
			throw e;
		}finally{
			System.out.println("after");
		}
		return result;
	}
	
	
}
