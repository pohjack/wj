package com.springannotationconfig.multipleThread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/** 
 * @author: wj
 * @version:  v1
 * @date:2017年12月25日 下午1:51:39
 * @description:spring多线程，异步执行任务测试demo
 */
@Service
public class TestAsyncService {
	
	@Async   //@Async注解在类级别，类所有方法的执行都是异步的，如果是在方法级别，只有该方法是异步的
	public void asyncMethod1(int i) throws InterruptedException{
		Thread.currentThread().sleep(1500);
		System.out.println("TestAsyncService.asyncMethod1 runing "+i+"currentThread "+Thread.currentThread().getName());
	}
}
