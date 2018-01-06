package com.mybatis.mybatis.sqlutil.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
 * @author: wj
 * @version:  v1
 * @date:2018年1月5日 上午9:40:03
 * @description:自定义注解，用于bean属性与数据库表和字段映射
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD})
public @interface DataMapping {
	String value();
}
