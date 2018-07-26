package com.aop.dynamicproxy.jdk;

public class TestJdkProxy {
	/**
	 * jdk动态代理实现原理分析
	 *一、实现步骤
	 *	1、定义接口IArithmeticCalculator，接口定义需要被代理的方法
	 *	2、类ArithmeticCalculator实现接口
	 *	3.ArithmetircCalculatorProxy代理类，实现incocationHandler,在invoke方法中实现需要增加的逻辑
	 *	4.创建代理类示例proxy,调用代理类的getProxyInstance方法获取由jdk动态生成的真正的代理类（$proxy0.class）
	 *
	 *二、实现原理分析
	 *	1、使用Proxy.newInstance(ClassLoder loder,Class[] interfaces,InvocationHandler h);
	 *	  loder:加载当前类的类加载器
	 *	  interfaces:被代理类的实现的所有接口
	 *	  h:实现了InvocationHandler接口的对象
	 *	2、调用Proxy类的getProxyClass0()方法获取动态生成代理的Class对象，反射生成对象示例
	 *	3、调用proxyClassCashe.get()先从缓存中查找，没有这调用Proxy类的内部类ProxyClassFactory进行创建
	 *	4、ProxyFactory调用ProxyGenerator.generateProxyClass(proxyName, interfaces, accessFlags)生成代理类的字节数组，最终调用
	 *		本地方法产生$proxy0.class文件;
	 *	5、设置System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");可以将生成的字节码文件写入硬盘，
	 *		位于当前项目的根目录com.sun.proxy文件夹下
	 */
	public static void main(String[] args) {
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		ArithmeticCalculatorProxy proxy=new ArithmeticCalculatorProxy(new ArithmeticCalculator());
		IArithmeticCalculator proxyCalculator=(IArithmeticCalculator) proxy.getProxyInstance();
		proxyCalculator.add(1, 2);
		proxyCalculator.sub(2, 1);
		proxyCalculator.dou(7, 2);
		proxyCalculator.div(7, 2);
	}

}
