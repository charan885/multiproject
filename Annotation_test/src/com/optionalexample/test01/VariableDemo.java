package com.optionalexample.test01;

class VariableDemo1{
	
	public static void main(String[] args) {
		
		VariableDemo variableDemo=new VariableDemo();
		System.out.println(variableDemo.getA());
	}
	
	
}
public class VariableDemo {
	
	public int a=3;
	
	

	public int getA() {
		return a;
	}



	public void setA(int a) {
		this.a = a;
	}



	public static void main(String[] args) {

		
	}

}
