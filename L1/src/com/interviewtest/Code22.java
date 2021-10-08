package com.interviewtest;


class ClassA1{
	ClassA1(){
		System.out.println("A0");
	}
   ClassA1(String b){
		this();
		System.out.println("A1");
	}
	
}
class ClassB1 extends ClassA1{
	ClassB1(String b){
		super("super");
		System.out.println("B1");
		
	}
}
public class Code22 {

	public static void main(String[] args) {
		new ClassB1("test");

	}

}
