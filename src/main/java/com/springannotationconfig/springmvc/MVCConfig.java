package com.springannotationconfig.springmvc;
/** 
 * @author: wj
 * @version:  v1
 * @date:2017年12月26日 上午9:45:00
 * @description: spring mvc java配置类
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.springannotationconfig.springmvc")
public class MVCConfig {

	/**
	 * @author: wj
	 * @version:  v1
	 * @date:2017年12月26日 上午9:50:02
	 * @description:定义视图解析器
	 * @return
	 */
	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/");
		viewResolver.setSuffix(".jsp");
		System.out.println("===================viewResolver initialized===================");
		return viewResolver;
	}
/*	@Bean
	public UrlBasedViewResolver urlViewResolver(){
		UrlBasedViewResolver viewResolver=new UrlBasedViewResolver();
		viewResolver.setPrefix("/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		System.out.println("===================viewResolver initialized===================");
		return viewResolver;
	}*/
}
