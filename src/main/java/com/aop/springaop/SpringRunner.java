package com.aop.springaop;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aop.springaop.bean.BaseBean;

public class SpringRunner {

	public static void main(String[] args) throws IOException, SQLException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringApplication.xml");
		context.start();
		BaseBean bean = (BaseBean) context.getBean("baseBean");
		BasicDataSource dataSource = (BasicDataSource) context.getBean("dataSource");
		System.out.println(dataSource.getPassword());
		System.out.println(dataSource.getUrl());
		System.out.println(dataSource.getUsername());
		System.out.println(dataSource.getDriverClassName());
		System.out.println(bean.toString());
		Connection con = dataSource.getConnection();
		
		System.in.read();// 阻塞，控制台输入任意值停止
	}
}
