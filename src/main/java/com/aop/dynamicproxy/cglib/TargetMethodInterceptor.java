package com.aop.dynamicproxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 拦截器，在cglib调用被代理对象的方法时会回调MethodInterceptor接口的方法，来实现代理逻辑，类是jdk中的invocationHandler接口
 * @author wj
 *
 */
public class TargetMethodInterceptor implements MethodInterceptor{
	
	/**
	 * 重写intercept方法，实现相应的横切逻辑
	 * Object obj为目标对象
	 * Method method为目标方法
	 * Object[] params 为参数，
	 * MethodProxy proxy CGlib方法代理对象
	 */
	public Object intercept(Object obj, Method method, Object[] params, MethodProxy proxy) throws Throwable {
		System.out.println("调用前");
		Object result=proxy.invokeSuper(obj, params);
		System.out.println("调用后");
		System.out.println("--------------interceptor参数信息----------------");
		System.out.println("目标对象"+obj.getClass().getName());
		System.out.println("目标对象方法"+method.getName());
		System.out.println("参数："+params);
		System.out.println("cglib代理对象MethodProxy："+proxy.toString());
		return result;
	}

}
