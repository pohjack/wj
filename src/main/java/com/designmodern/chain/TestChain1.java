package com.designmodern.chain;

import java.util.Arrays;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * 责任链模式的基本实现方式
 * @author wj
 *
 */
public class TestChain1 {
	static class HandlerA extends Handler{
		@Override
		protected void handlerProcess() {
			System.out.println("HandlerA process ");
		}
	}
	static class HandlerB extends Handler{
		@Override
		protected void handlerProcess() {
			System.out.println("HandlerB process ");
		}
	}
	static class HandlerC extends Handler{
		@Override
		protected void handlerProcess() {
			System.out.println("HandlerC process ");
		}
	}
	
	public static void main(String[] args) {
		HandlerA a=new HandlerA();
		HandlerB b=new HandlerB();
		HandlerC c=new HandlerC();
		
		//设置执行顺序
		a.setNext(b);
		b.setNext(c);
		
		//执行第一个handler的execute()
		a.execute();
		System.out.println("--------------------------------");
		
//		责任链模式的第二种实现：使用list存放handler
		List<Handler> handlers=Arrays.asList(a,b,c);
		Chain chain=new Chain(handlers);
		chain.proceed();
	}

}
