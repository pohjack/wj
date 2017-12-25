package com.springannotationconfig;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfiguration;

/** 
 * @author: wj
 * @version:  v1
 * @date:2017年12月25日 下午4:08:45
 * @description:spring组合注解，元注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(SchedulingConfiguration.class)
@Documented
@Configuration
@ComponentScan(basePackages="com")   //配置包扫描路径，相当于xml中的<context:component-scan base-package="com" />
//@Import(**Config.class)  //相当于导入多个配置文件
@EnableAspectJAutoProxy  //开启spring对AspectJ的代理支持
@PropertySource("classpath:config/jdbcConfig.properties") //引入外部资源文件
@EnableAsync    //开启spring对多线程的支持，基于线程池实现异步处理请求，实现AsyncConfigurer接口
@EnableScheduling   //开启spring定时任务
public @interface CombinedConfigAnnotation {
//	String[] value() default {};
}
