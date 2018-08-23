package com.java8newfeatures.code.repeatableannotaion;

import java.lang.annotation.*;

/**
 * java8新增可重复注解和类型注解（应用在方法入参）
 */

@Repeatable(MyAnnotations.class)  //指定重复注解容器类
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD,ElementType.PARAMETER,ElementType.CONSTRUCTOR,
ElementType.TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() ;
}
