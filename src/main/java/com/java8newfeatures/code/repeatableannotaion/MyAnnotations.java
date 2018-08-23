package com.java8newfeatures.code.repeatableannotaion;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD,ElementType.PARAMETER,ElementType.CONSTRUCTOR,
        ElementType.TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotations {
    MyAnnotation[] value();
}
