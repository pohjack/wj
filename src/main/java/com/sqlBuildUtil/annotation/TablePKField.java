package com.sqlBuildUtil.annotation;


import java.lang.annotation.*;

/**
 * 表主键注解标识
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface TablePKField {
}
