package com.annotationexample.demo01;

import java.lang.annotation.Annotation;

public class Annotation_Test02 {

	public static void main(String[] args) {
       Product product=new Product();
       Class classProduct=  product.getClass();
       Annotation annotation= classProduct.getAnnotation(Mobile.class);
       Mobile mobile=(Mobile)annotation;
       System.out.println(mobile.version());
       System.out.println(mobile.ram());
       System.out.println(mobile.rom());
       System.out.println(mobile.cost());
	}

}
@Mobile(cost = 45000.50F, ram = 4, rom = 128, version = "SAMSUNGV5")
class Product{
	
}
class Product_child extends Product{
	
}