package com.sqlBuildUtil.annotation;

import java.lang.annotation.*;

/**
 * vo对象注解，对应数据库表名
 * table:表名
 * fieldNameConvert:是否开启字段名转换fieldName-->field_name
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface TableName {
    String table();

    boolean fieldNameConvert() default false;
}
