package com.bitcalculate;
/** 
 * @author: wj
 * @version:  v1
 * @date:2018年4月12日 上午10:24:42
 * @description:java位运算符针对二进制进行操作，&(与)  |(或)  ^(异或)  ~(非)  >>(右移位)  <<(左移位) 
 */
public class TestBitCalculate {
	
	public static void main(String[] args) {
		Integer i=new Integer(10);
		Integer k=new Integer(8);
		String oxi=Integer.toBinaryString(i);
		String oxk=Integer.toBinaryString(k);
		System.out.println(oxi);
		System.out.println(oxk);
		System.out.println("&-------"+Integer.toBinaryString(i&k));
		System.out.println("|-------"+Integer.toBinaryString(i|k));
		System.out.println("^-------"+Integer.toBinaryString(i^k));
		System.out.println("~-------"+Integer.toBinaryString(~k));
		System.out.println("~-------"+Integer.toBinaryString((~k)>>1));
		System.out.println(">>-------"+Integer.toBinaryString(k>>1));
		System.out.println("<<-------"+Integer.toBinaryString(k>>2));
		System.out.println("<<-------"+Integer.parseInt("110111", 2));
		
	}

}
