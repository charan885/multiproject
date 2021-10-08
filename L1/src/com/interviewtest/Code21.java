package com.interviewtest;

class classA{
	classA(){
		System.out.println("A0");
	}
	classA(String b){
		System.out.println("A1");
	}
}
class classB extends classA{
	classB(String b){
		System.out.println("B1");
	}
}

public class Code21 {
	

	public static void main(String[] args) {
		new classB("TEST");

	}

}
