package com.interviewtest;

interface A1{
	abstract void m1();
	void m2();
	void m3() {
		System.out.println("m3");
	}
	static void m4() {
		System.out.println("m4");
	}
	default void m5() {
		System.out.println("m5");
	}
	
}

public class Code25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
