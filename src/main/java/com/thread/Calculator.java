package com.thread;

public class Calculator {
	
	public static void main(String[] args) {
		long start=System.currentTimeMillis();
		for(int i=0;i<10;i++){
			Thread t=new Thread(){
				long j=0;
				public void run(){
					for(int k=0;k<Integer.MAX_VALUE;k++){
						j+=k*Math.PI+k/Math.PI+Math.PI*Math.E/3.698587447894747;
						
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
		long end=System.currentTimeMillis();
		System.out.println("耗时："+(end-start)/1000);
	}
	
}
