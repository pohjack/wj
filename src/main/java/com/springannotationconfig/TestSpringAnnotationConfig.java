package com.springannotationconfig;
/** 
 * @author: wj
 * @version:  v1
 * @date:2017年12月21日 下午4:42:46
 * @description:spring容器启动类
 */

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springannotationconfig.conditionalAnnotation.IService;
import com.springannotationconfig.multipleThread.TestAsyncService;

public class TestSpringAnnotationConfig {
	public static void main(String[] args) throws InterruptedException, IOException {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		//设置容器使用哪个环境,需要先设置环境再注册bean配置类，不然会报错
		context.getEnvironment().setActiveProfiles("prod");  //开发环境
		context.register(JavaConfig.class);
		context.refresh();
		
//		TestBean bean=(TestBean) context.getBean("tbean");
//		System.out.println(bean.hello());
//		System.out.println("===profile====="+bean.desc);
//		System.out.println("===profile====="+context.getBean("noneBean"));
//		UseTestBean tbean=context.getBean(UseTestBean.class);
//		System.out.println(tbean.sayHello());
//		System.out.println(context.getBean("testSpringEL"));
		
		//spring application event
//		context.getBean(ApplicationEventPublisher.class).publish();
		
		//srping multipleThread
		TestAsyncService asyncService=(TestAsyncService) context.getBean("testAsyncService");
		long start=System.currentTimeMillis();
		for(int i=1;i<=10;i++){
			asyncService.asyncMethod1(i);
		}
		long end=System.currentTimeMillis();
		System.out.println("main线程执行完毕，耗时："+(end-start));
		
		//spring @Conditonal annotationS
		System.out.println(context.getEnvironment().getProperty("os.name"));
		((IService) context.getBean("iservice")).doExecute();
		
		System.in.read();
		context.close();
	}

}
