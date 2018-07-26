package com.classinittest;

/**
 * @author: wj
 * @version: v1
 * @date:2018年7月26日 下午1:55:53
 * @description:测试父类子类初始化顺序
 */
public class TestClassInit {
	public static void main(String[] args) {
		new Son();
		System.out.println("----------------------");
		new Son();
		System.out.println("----------------------");
		new Father();
	}
	/*
		运行结果如下：
 		father's static code block init.....
		son's static code block init.....
		father's common code block init.....
		father's constructor run.....
		son's common code block init......
		son's constructor run....
		----------------------
		father's common code block init.....
		father's constructor run.....
		son's common code block init......
		son's constructor run....
		
		结论父类子类初始化顺序为：
			1，在类加载的时候执行父类的static代码块，并且只执行一次（因为类只加载一次）；
			2，执行子类的static代码块，并且只执行一次（因为类只加载一次）；
			3，执行父类的类成员初始化，并且是从上往下按出现顺序执行（在debug时可以看出）。
			4、执行父类的一般代码块
			5，执行父类的构造函数；
			6，执行子类的类成员初始化，并且是从上往下按出现顺序执行。
			7、执行子类的一般代码块；
			8，执行子类的构造函数。
			9、类加载时首先初始化成员变量，执行静态代码块，再执行一般代码块，使用new调用构造器是调用类的构造方法；
	 */
}
