package com.sqlBuildUtil.annotation;

import java.lang.annotation.*;

/**
 * 一般表字段注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface TableField {
    String TYPE_STRING = "0";
    String TYPE_DATE = "1";
    String DATE_FORMAT="yyyy-MM-dd HH24:mi:ss";
    String DATE_FORMAT_DD="yyyy-MM-dd";

    String type() default TYPE_STRING;
    String dateFormat() default DATE_FORMAT;
}
