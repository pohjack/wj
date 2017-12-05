package com.thread;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.Callable;

import org.junit.Test;

public class TestThread {
	
	class ThreadA implements Runnable{
		public void run() {
			System.out.println("ThreadA run");
		}
	}
	class ThreadB extends Thread{
		public void run() {
			System.out.println("ThreadB run");
		}
	}
	class ThreadC implements Callable<String>{
		public String call() throws Exception {
			System.out.println("ThreadC call");
			return "call";
		}
	}
	
	@Test
	public  void testThread(String[] args) {
		ThreadA a=new ThreadA();
		Thread ar=new Thread(a);
		ar.start();
	}
	public static void main(String[] args) throws Exception {
		Thread a=new Thread(new Runnable() {
			public void run() {
				System.out.println("runnable");
				int k=5/0;
			}
		});
		a.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("eee");
				System.out.println(e.getMessage());
				
			}
		});
		a.start();
		Thread b=new Thread(){
			public void run(){
				System.out.println("thread run");
			}
		};
		b.start();
		Callable<String> c=new Callable<String>() {

			public String call() throws Exception {
				System.out.println("callable");
				return "call";
			}
		};
		String re=(String) c.call();
		System.out.println(re);
	}
}
