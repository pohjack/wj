package com.springannotationconfig.springmvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/** 
 * @author: wj
 * @version:  v1
 * @date:2017年12月26日 上午10:00:37
 * @description: springmvc 启动类
 */
public class WebMVCInitializer implements WebApplicationInitializer {
	
	/**
	 * 相当于web.xml中的配置
	 */
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext ctx=new AnnotationConfigWebApplicationContext();
		ctx.register(MVCConfig.class);
		ctx.setServletContext(servletContext);
		Dynamic servlet=servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
		System.out.println("=====================mvc initializer初始化完成====================");
	}

}
