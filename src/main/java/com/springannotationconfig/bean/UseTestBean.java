package com.springannotationconfig.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/** 
 * @author: wj
 * @version:  v1
 * @date:2017年12月21日 下午4:51:48
 * @description:
 */
public class UseTestBean {
	
	@Autowired
	@Qualifier("tbean")
	private TestBean bean;

	public void setBean(TestBean bean) {
		this.bean = bean;
	}
	
	public String sayHello(){
		return bean.hello();
	}
	
	@PostConstruct
	public void initMethod(){
		System.out.println(this.getClass().getName()+" initMethod");
	}
	@PreDestroy
	public void destroyMethod(){
		System.out.println(this.getClass().getName()+" destroyMethod");
	}
	
}
