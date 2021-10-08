package com.functioninterfaceexample.demo01;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 
 * @author user
 * 
 * @FunctionalInterface--consists one abstract method
 * --default methods with return type or without return type implement
 * --static methods with return type or without return type implement
 * --extends empty interface
 * --two functional interface cannot extends
 * --non static methods with return type or without return type cannot implement
 * 
 * same method in two functional interfaces  can extends
 * 
 * predefined functional interfaces:---consumer,predicate,supplier,function  etc..
 *
 */
@FunctionalInterface
public interface FunctionInterfaceTest01 extends FunctionalInterfaceTest02{
 void m1();
  default void m2() {
	  
  }
default  int  m7() {
	  return 3;
  }
  
  static int m3() {
	  return 2;
  }
	/*
	 * void m4() {
	 * 
	 * }
	 */
  static void m5() {
	 // return 2;
  }
  
}

@FunctionalInterface
 interface FunctionInterfaceTest03{
	void m10(int x);
}

@FunctionalInterface
interface FunctionInterfaceTest04<T>{
	T m10(int x);
}

@FunctionalInterface
interface FunctionInterfaceTest05{
	void m11(int x);
}
@FunctionalInterface
interface FunctionInterfaceTest06 extends FunctionInterfaceTest05{
	void m11(int x);
}


class FTest01 implements Consumer,Predicate,Supplier{

	@Override
	public boolean test(Object t) {
		return false;
	}

	@Override
	public void accept(Object t) {
		
	}

	@Override
	public Object get() {
		return null;
	}
	
	
	public static void main(String[] args) {
		
		Consumer<Integer> consumer1=x->System.out.println(x+100);
		consumer1.accept(5);
				
	//	Predicate predicate1=x->x%2==0;
	//	System.out.println(predicate1.test(10));
	//	System.out.println(predicate1.test(11));
		
		Supplier supplier1=()->2021;
		System.out.println( supplier1.get());
		
	}
	
}