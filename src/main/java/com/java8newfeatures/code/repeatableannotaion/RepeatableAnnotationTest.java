package com.java8newfeatures.code.repeatableannotaion;

public class RepeatableAnnotationTest {

    @MyAnnotation("chehis")
    @MyAnnotation("chehis")
    public void getName(@MyAnnotation("wj") String name){

    }
}
