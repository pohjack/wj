package com.thread;

public class TestMultiThread {
	public static void main(String[] args) {
		Clerk c = new Clerk();
		Producer p = new Producer(c);
		Producer p2 = new Producer(c);
		p2.setName("producer-co");
		p.setName("producer");
		c.setName("clerk");
		Consumer con = new Consumer(c);
		con.setName("consumer");
		p.start();
		c.start();
		con.start();
		p2.start();
	}
}

class Clerk extends Thread {

	int stock = 0;

	public synchronized void addProduct() {
		if (stock < 20) {
			stock++;
			System.out.println("produce product  stock " + stock);
			notifyAll();
		} else {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void consumProduct() {
		if (stock > 0) {
			stock--;
			System.out.println("consumer product  stock " + stock);
			notifyAll();
		} else {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class Producer extends Thread {
	Clerk c;

	public Producer(Clerk c) {
		this.c = c;
	}

	public void run() {
		while (true) {
			c.addProduct();
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Consumer extends Thread {
	Clerk c;

	public Consumer(Clerk c) {
		this.c = c;
	}

	public void run() {
		while (true) {
			c.consumProduct();
			try {
				Thread.currentThread().sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}