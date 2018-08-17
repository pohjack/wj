package com.java8newfeatures.code;

import com.java8newfeatures.bean.Person;
import com.java8newfeatures.code.interfaces.Add;
import com.java8newfeatures.code.interfaces.Run;
import com.java8newfeatures.code.interfaces.StringHandler;
import org.junit.Test;

import java.util.*;

/**
 * 一、Lambda 是一个 匿名函数，我们可以把 Lambda表达式理解为是 一段可以传递的代码（将代码
 * 像数据一样进行传递）。可以写出更简洁、更灵活的代码。作为一种更紧凑的代码风格，使Java 的语言表达能力得到了提升
 * <p>
 * 二、Lambda语法：（所需参数）->{具体执行的代码}
 * <p>
 * 三、类型推断 Lambda 表达式中的参数类型都是由编译器推断得出的。Lambda 表达式中无需指定类型，程序依然可 以编译，这是因为 javac
 * 根据程序的上下文，在后台推断出了参数的类型。Lambda 表达式的类型依赖于上 下文环境，是由编译器推断出来的。这就是所谓的类型推断
 * <p>
 * 四、Lambda表达式需要函数式接口的支持
 * 函数式接口：只用一个抽象方法的接口就叫做函数式接口，可以使用@FuncitonalInterface注解可以检查接口是否是只有一个 抽象方法的函数式接口
 */
@SuppressWarnings("all")
public class LambdaTest {

	// 语法格式一：无参数，无返回值
	Runnable run1 = () -> System.out.print("lambda");

	// 语法格式二：一个参数(可以省略括号)，无返回值
	Run<String> run2 = (arg) -> System.out.println(arg);
	// 只有一个参数可以省略括号,执行体只有一行代码可以省略｛｝，return关键字也能省略
	Run<String> run3 = arg -> System.out.println(arg);

	// 语法格式三：多个参数，有返回值
	Add<Integer> addResult = (i, j) -> {
		System.out.println("两个数相加。。。");
		return i + j;
	};

	// 语法格式四：Lambda表达式中的参数类型可不声明，编译可以推断出类型
	Add<Integer> addResult2 = (Integer i, Integer j) -> {
		System.out.println("两个数相加。。。");
		return i + j;
	};

	/**
	 * 匿名内部类,实现Comparetor接口
	 * <p>
	 * 注意：匿名内部类和Lambda表达式中应用的变量需要声明为final(1.7之前)，1.8之后不要声明为final,但实际还是final的，不可修改
	 */
	public void test1() {
		TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
	}

	/**
	 * Lambda表达式实现
	 */
	public void test2() {
		TreeSet<String> set = new TreeSet<String>((o1, o2) -> o1.length() - o2.length());
	}

	/**
	 * Lambda表达式使用练习
	 */
	List<Person> ps = Arrays.asList(new Person("李四", 18, "北京"), new Person("张三", 20, "广州"), new Person("王五", 18, "上海"));

	// 排序
	@Test
	public void TestSort() {
		Collections.sort(ps, (p1, p2) -> {
			if (p1.age == p2.age) {
				return p1.name.compareTo(p2.name);
			} else {
				return p1.age - p2.age;
			}
		});
		ps.forEach(p -> System.out.println(p));
	}

	// 字符串处理
	public String strHandler(String str, StringHandler handler) {
		return handler.handle(str);
	}

	public void testStrHandler() {
		String upper = strHandler("adf", str -> str.toUpperCase());
		System.out.println(upper);

		String trim = strHandler("   ddf   ", str -> str.trim());
		System.out.println(trim);
	}

	public static void main(String[] args) {
		System.out.println("99999");
		LambdaTest test=new LambdaTest();
		test.TestSort();
		test.testStrHandler();
	}
}
