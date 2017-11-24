package com.aop.springaop.bean;

import org.springframework.stereotype.Component;

@Component()
public class BaseBean {
	
	private String Name ="BaseBean";

	@Override
	public String toString() {
		return "BaseBean [Name=" + Name + "]";
	}
	
}
