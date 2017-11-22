package com.aop.staticproxy;

public class SubjectProxy implements Subject{

	private Subject realSubject;
	
	public SubjectProxy(Subject realSubject){
		this.realSubject=realSubject;
	}
	/*
	 * 增加相应的逻辑
	 * @see com.aop.staticproxy.Subject#request()
	 */
	public void request() {
		System.out.println("before");
		try{
			this.realSubject.request();
			System.out.println("after");
		}catch(Exception e){
			System.out.println("exception:"+e.getMessage());
		}
	}

}
