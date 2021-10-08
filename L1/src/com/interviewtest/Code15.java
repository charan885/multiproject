package com.interviewtest;

public class Code15 {
	
	static {
		System.out.println("B");
	}
	{
		System.out.println("A");
	}

	public static void main(String[] args) {
		System.out.println("C");

	}

}
