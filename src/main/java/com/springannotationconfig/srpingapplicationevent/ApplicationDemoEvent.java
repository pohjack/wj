package com.springannotationconfig.srpingapplicationevent;

import org.springframework.context.ApplicationEvent;

/**
 * @author: wj
 * @version: v1
 * @date:2017年12月23日 下午2:14:04
 * @description:spring application event 自定义事件类继承ApplicationEvent
 */
public class ApplicationDemoEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	private String msg;

	public ApplicationDemoEvent(Object source, String msg) {
		super(source);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
