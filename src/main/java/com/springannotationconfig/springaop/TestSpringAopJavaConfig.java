package com.springannotationconfig.springaop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/** 
 * @author: wj
 * @version:  v1
 * @date:2017年12月22日 下午2:24:37
 * @description:注解方式配置spring aop
 */
@Aspect    //声明一个切面
@Component  //纳入spring 容器管理
public class TestSpringAopJavaConfig {
	
	//定义切点
	@Pointcut("execution( * com.springannotationconfig.bean.TestBean.*(..))")
	public void annotationPointCut(){};
	
	@Around("annotationPointCut()")
	public void around(ProceedingJoinPoint point){
		MethodSignature s=(MethodSignature) point.getSignature();
		Object result="";
		try{
			System.out.println("before "+s.getName()+" execution");
			result=point.proceed();
			System.out.println("return "+s.getName()+" execution");
		}catch (Throwable e) {
			System.out.println("exception "+s.getName());
		}finally {
			System.out.println("after "+result.toString()+" "+s.getName());
		}
	}
	
	/*切点定义示例：

	the execution of any public method:  
	execution(public * *(..))
	
	the execution of any method with a name beginning with "set":   
	execution(* set*(..))
	
	the execution of any method defined by the AccountService interface:
	execution(* com.xyz.service.AccountService.*(..))
	
	the execution of any method defined in the service package:
	execution(* com.xyz.service.*.*(..))
	
	the execution of any method defined in the service package or a sub-package:
	execution(* com.xyz.service..*.*(..))
	
	any join point (method execution only in Spring AOP) within the service package:
	within(com.xyz.service.*)
	
	any join point (method execution only in Spring AOP) within the service package or a sub-package:
	within(com.xyz.service..*)
	
	any join point (method execution only in Spring AOP) where the proxy implements the AccountService interface:
	this(com.xyz.service.AccountService)
	
	any join point (method execution only in Spring AOP) where the target object implements the AccountService interface:
	target(com.xyz.service.AccountService)
	
	any join point (method execution only in Spring AOP) which takes a single parameter, and where the argument passed at runtime is Serializable:
	args(java.io.Serializable)
	
	any join point (method execution only in Spring AOP) where the target object has an @Transactional annotation:
	@target(org.springframework.transaction.annotation.Transactional)
	
	any join point (method execution only in Spring AOP) where the declared type of the target object has an @Transactional annotation:
	@within(org.springframework.transaction.annotation.Transactional)
	
	any join point (method execution only in Spring AOP) where the executing method has an @Transactional annotation:
	@annotation(org.springframework.transaction.annotation.Transactional)
	
	any join point (method execution only in Spring AOP) which takes a single parameter, and where the runtime type of the argument passed has the @Classified annotation:
	@args(com.xyz.security.Classified)
	
	any join point (method execution only in Spring AOP) on a Spring bean named tradeService:
	bean(tradeService)
	
	any join point (method execution only in Spring AOP) on Spring beans having names that match the wildcard expression *Service:
	bean(*Service)
	*/
}
