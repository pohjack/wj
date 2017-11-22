package com.aop.staticproxy;

public class RealSubject implements Subject{

	public void request() {
		System.out.println("realSubject.request()");
		
	}

}
