package com.thread;

public class Calculator {
	
	public static void main(String[] args) {
		for(int i=0;i<100;i++){
			Thread t=new Thread(){
				long j=0;
				public void run(){
					for(int k=0;k<Integer.MAX_VALUE;k++){
						j+=k;
					}
					System.out.println(Thread.currentThread().getName()+"---"+j);
				}
			};
			t.setName("thread"+i);
			t.start();
//			long j=0;
//			for(int k=0;k<Integer.MAX_VALUE;k++){
//				j+=k;
//			}
//			System.out.println(Thread.currentThread().getName()+"--"+i+"---"+j);
		}
	}
	
}
