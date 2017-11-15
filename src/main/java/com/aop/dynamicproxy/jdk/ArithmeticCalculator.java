package com.aop.dynamicproxy.jdk;

public class ArithmeticCalculator implements IArithmeticCalculator {

	public int add(int j, int i) {
		System.out.println(j+i);
		return j+i;
	}

	public int sub(int j, int i) {
		System.out.println(j-i);
		return j-i;
	}

	public int div(int j, int i) {
		System.out.println(j/i);
		return j/i;
	}

	public int dou(int j, int i) {
		System.out.println(j*i);
		return j*i;
	}

}
