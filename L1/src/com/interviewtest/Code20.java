package com.interviewtest;

public class Code20 {
	int a=10;
	static int b=10;
	Code20(){
		a++;
		b++;
	}

	public static void main(String[] args) {
		Code20 obj1=new Code20();
		Code20 obj2=new Code20();
        System.out.println(obj2.a);
        System.out.println(obj2.b);

	}

}
