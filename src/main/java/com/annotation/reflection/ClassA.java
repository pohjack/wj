package com.annotation.reflection;

import com.annotation.reflection.MyAnnotation.TODO;

@MyAnnotation(todo=TODO.processA)
public class ClassA extends ParentClass implements InterfaceA{

	public void AMethod() {
		System.out.println("classA----method implyment from interface A");
	}
	
	public void MethodFOfClassA(){
		System.out.println("classA------public MethodFOfClassA");
	}
	
	private void MethodC(){
		System.out.println("classA-----private MethodC");
	}
	
	void MethodD(){
		System.out.println("classA-----default method D");
	}
	
	protected void MethodW(){
		System.out.println("classA-----protected method w ");
	}
	
	class B {
		void MethodH(){
			System.out.println("ClassA's inner ClassB default MethodH");
		}
	}
}
