package com.springannotationconfig.srpingapplicationevent;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/** 
 * @author: wj
 * @version:  v1
 * @date:2017年12月23日 下午2:20:37
 * @description:自定义事件监听类，实现ApplicationListener接口
 */
@Component
public class ApplicationDemoListener implements ApplicationListener<ApplicationDemoEvent>{

	public void onApplicationEvent(ApplicationDemoEvent event) {
		System.err.println("接受ApplicationDemoEvent发布的事件："+event.getMsg());
	}

}
