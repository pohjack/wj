package com.aop.staticproxy;

public class TestStaticProxy {
	
	/**
	 * 静态代理
	 * @param args
	 */
	public static void main(String[] args) {
		SubjectProxy proxy=new SubjectProxy(new RealSubject());
		proxy.request();		
	}

}
