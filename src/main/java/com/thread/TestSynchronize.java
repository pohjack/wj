package com.thread;

/**
 * 两个线程交替打印1-100
 * @author wj
 *
 */
public class TestSynchronize {
	
	public static void main(String[] args) {
		num n=new num(100);
		T1 t=new T1(n);
		T1 tq=new T1(n);
		t.setName("wwwww");
		tq.setName("ooooo");
		t.start();
		tq.start();
		
	}
}
class num{
	int num;
	public num(int n){
		this.num=n;
	}
}
class T1 extends Thread{
	num num;
	public T1(num n){
		this.num=n;
	}
	public void run(){
		while(true){
			synchronized(num){
				num.notify();
				if(num.num>0){
					System.out.println(Thread.currentThread().getName()+"--"+num.num);
					num.num--;
				}
				try {
					Thread.currentThread().sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					num.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}