package com.springannotationconfig.srpingapplicationevent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/** 
 * @author: wj
 * @version:  v1
 * @date:2017年12月23日 下午2:26:20
 * @description:事件发不类
 */
@Component
public class ApplicationEventPublisher {
	@Autowired 
	ApplicationContext context;
	
	public void publish(){
		context.publishEvent(new ApplicationDemoEvent(this,"event msg"));
	}

}
