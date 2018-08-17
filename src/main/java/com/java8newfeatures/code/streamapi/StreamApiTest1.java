package com.java8newfeatures.code.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import com.java8newfeatures.bean.Employee;

/**
 * @author: wj
 * @version: v1
 * @date:2018年8月12日 上午11:15:33
 * @description:java8新特性-stream api
 */
public class StreamApiTest1 {

	/*
	 * 一、Stream API 的操作步骤：
	 * 
	 * 1. 创建 Stream
	 * 		1. Collection 提供了两个方法 stream() 与 parallelStream()
	 * 		2. 通过 Arrays 中的 stream() 获取一个数组流
	 * 		3. 通过 Stream 类中静态方法 of()
	 * 		4. 创建无限流Stream.iterate
	 * 		5.生成Stream.generate
	 * 
	 * 2. 中间操作
	 * 		1)筛选与切片
	 *  		filter——接收 Lambda ， 从流中排除某些元素。 
	 *  		limit——截断流，使其元素不超过给定数量。 
	 *  		skip(n) ——跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
	 *  		distinct——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
	 *  	2)排序与映射
	 *  		sorted()——自然排序
	 *  		sorted(Comparator com)——定制排序
	 *  		map——接收 Lambda ， 将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
	 * 			flatMap——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
	 * 
	 * 3. 终止操作(终端操作)
 * 			reduce(T identity, BinaryOperator) / reduce(BinaryOperator) 可以将流中元素反复结合起来，得到一个值。
 * 		 	collect——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
	 */

	// 1. 创建 Stream
	@Test
	public void test1() {
		// 1. Collection 提供了两个方法 stream() 与 parallelStream()
		List<String> list = new ArrayList<>();
		Stream<String> stream = list.stream(); // 获取一个顺序流
		Stream<String> parallelStream = list.parallelStream(); // 获取一个并行流

		// 2. 通过 Arrays 中的 stream() 获取一个数组流
		Integer[] nums = new Integer[10];
		Stream<Integer> stream1 = Arrays.stream(nums);

		// 3. 通过 Stream 类中静态方法 of()
		Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5, 6);

		// 4. 创建无限流
		// 迭代
		Stream<Integer> stream3 = Stream.iterate(0, (x) -> x + 2).limit(10);
		stream3.forEach(System.out::println);

		// 5.生成
		Stream<Double> stream4 = Stream.generate(Math::random).limit(2);
		stream4.forEach(System.out::println);

	}

	// 2. 中间操作
	List<Employee> emps = Arrays.asList(new Employee(102, "李四", 59, 6666.66), new Employee(101, "张三", 18, 9999.99),
			new Employee(103, "王五", 28, 3333.33), new Employee(104, "赵六", 8, 7777.77),
			new Employee(104, "赵六", 8, 7777.77), new Employee(104, "赵六", 8, 7777.77),
			new Employee(105, "田七", 38, 5555.55));

	/*
	 * 筛选与切片
	 *  filter——接收 Lambda ， 从流中排除某些元素。 
	 *  limit——截断流，使其元素不超过给定数量。 
	 *  skip(n) ——跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
	 *  distinct——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
	 */

	// 内部迭代：迭代操作 Stream API 内部完成
	@Test
	public void test2() {
		// 所有的中间操作不会做任何的处理
		Stream<Employee> stream = emps.stream().filter((e) -> {
			System.out.println("测试中间操作");
			return e.getAge() <= 35;
		});

		// 只有当做终止操作时，所有的中间操作会一次性的全部执行，称为“惰性求值”
		stream.forEach(System.out::println);
	}

	// 外部迭代
	@Test
	public void test3() {
		Iterator<Employee> it = emps.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	@Test
	public void test4() {
		emps.stream().filter((e) -> {
			System.out.println("短路！"); // && ||
			return e.getSalary() >= 5000;
		}).limit(3).forEach(System.out::println);
	}

	@Test
	public void test5() {
		emps.parallelStream().filter((e) -> e.getSalary() >= 5000).skip(2).forEach(System.out::println);
	}

	@Test
	public void test6() {
		emps.stream().distinct().forEach(System.out::println);
	}
	
	public static Stream<Character> filterCharacter(String str){
		List<Character> list = new ArrayList<>();
		
		for (Character ch : str.toCharArray()) {
			list.add(ch);
		}
		
		return list.stream();
	}
}
