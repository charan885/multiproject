package com.interviewtest;

class test01{
	test01(){
		System.out.println("A");
	}
	{
		System.out.println("B");
	}
	static {
		System.out.println("C");
	}
}

public class Code24 {

	public static void main(String[] args) {
		new test01();

	}

}
