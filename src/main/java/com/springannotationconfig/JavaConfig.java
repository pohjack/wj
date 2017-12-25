package com.springannotationconfig;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.springannotationconfig.bean.TestBean;
import com.springannotationconfig.bean.UseTestBean;
import com.springannotationconfig.conditionalAnnotation.IService;
import com.springannotationconfig.conditionalAnnotation.LinuxService;
import com.springannotationconfig.conditionalAnnotation.WindowsCondition;
import com.springannotationconfig.conditionalAnnotation.WindowsService;

/** 
 * @author: wj
 * @version:  v1
 * @date:2017年12月21日 下午4:43:29
 * @description:spring容器java配置
 */
@CombinedConfigAnnotation   //(value={"com","classpath:config/jdbcConfig.properties"})   //自定义组合注解，详细配置在此注解中声明
//@Configuration
//@ComponentScan(basePackages="com")   //配置包扫描路径，相当于xml中的<context:component-scan base-package="com" />
////@Import(**Config.class)  //相当于导入多个配置文件
//@EnableAspectJAutoProxy  //开启spring对AspectJ的代理支持
//@PropertySource("classpath:config/jdbcConfig.properties") //引入外部资源文件
//@EnableAsync    //开启spring对多线程的支持，基于线程池实现异步处理请求，实现AsyncConfigurer接口
//@EnableScheduling   //开启spring定时任务
public class JavaConfig implements AsyncConfigurer {
	
	@Bean(name="iservice")
	@Conditional(WindowsCondition.class)  //根据条件初始化不同的bean
	public IService windowsService(){
		return new WindowsService();
	}
	
	@Bean(name="iservice")
	@Conditional(WindowsCondition.class)
	public IService linuxService(){
		return new LinuxService();
	}
	
	@Bean(initMethod="init",destroyMethod="cleanUp",name="tbean")  //配置bean的生命周期方法
	@Scope("singleton")   //指定bean的作用范围
	@Profile("prod")      //指定bean在dev环境下才能使用，通过Environment.setActiveProfiles()方法设置使用哪个环境
	public TestBean getTestBean(){
		TestBean bean=new TestBean();
		bean.desc="this is 生产环境下的TestBean";
		return bean;
	}
	
	@Bean(name="devBean")
	@Profile("dev")
	public TestBean devTestBean(){
		TestBean bean=new TestBean();
		bean.desc="this is 开发环境下的TestBean";
		return bean;
	}
	
	@Bean(name="noneBean")
	public TestBean noneTestBean(){
		TestBean bean=new TestBean();
		bean.desc="this is 没有指定环境下的TestBean";
		return bean;
	}
	
	@Bean
	public UseTestBean useTestBean(){
		return new UseTestBean();
	}
	
	/**
	 * 多线程任务执行器
	 */
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(5);
		executor.setQueueCapacity(10);
		executor.initialize();
		return executor;
	}

	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return null;
	}
	

}
