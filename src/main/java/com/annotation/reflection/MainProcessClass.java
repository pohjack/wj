package com.annotation.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class MainProcessClass {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> a=Class.forName("com.annotation.reflection.ClassA");
		System.out.println("className"+a.getName());
		if(a.isAnnotationPresent(MyAnnotation.class)){
			System.out.println("prase annotation==============start=========");
			Annotation[] as=a.getDeclaredAnnotations();
			System.out.println(as.length);
			for(Annotation ann:as){
				System.out.println(ann.toString());
				System.out.println(ann.getClass().getName());
				MyAnnotation myann=(MyAnnotation)ann;
				System.out.println(myann.toString());
				System.out.println(myann.todo());
			}
			System.out.println("----annotation end----");
		}
		Class<?>[] classes=a.getDeclaredClasses();
		System.out.println("prase classes==========start=========");
		for(Class cl:classes){
			System.out.println("className:"+cl.getName());
		}
		Class<?>[] cl2=a.getInterfaces();
		for(Class<?> cl:cl2){
			System.out.println("getInterfaces className:"+cl.getName());
		}
		AnnotatedType[] cl3=a.getAnnotatedInterfaces();
		for(AnnotatedType cl:cl3){
			System.out.println("getAnnotatedInterfaces className:"+cl.getClass() );
		}
		Type[] cl4=a.getGenericInterfaces();
		for(Type cl:cl4){
			System.out.println("getGenericInterfacesInterfaces className:"+cl.getTypeName() );
		}
		System.out.println("prase classes==========end=========");
		Method[] methods=a.getDeclaredMethods();
		Object aInstance=a.newInstance();
		for(Method me:methods){
			System.out.println("method"+me.toString());
			me.setAccessible(true);
			me.invoke(aInstance);
		}
		
	}
}
