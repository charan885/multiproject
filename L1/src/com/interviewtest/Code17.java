package com.interviewtest;

public class Code17 {

	public static void main(String[] args) {
		try {
			int a[]= {100,10};
			System.out.println(a[2]/0);
		}catch (ArithmeticException e) {
			System.out.println("Catch2");
		}
		catch (Exception e) {
			System.out.println("Catch3");
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Catch1");
		}

	}

}
