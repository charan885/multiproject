package com.annotationexample.demo01;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public @interface MyAnnotation {
	
	/**
	 * annotation created with @interface 
	 * data is defined with methods
	 * method should return value 
	 * should not return void
	 * should return string, primitive ,userdefined classes
	 * method should not have parameters
	 * 
	 * 
	 * 
	 * @Documented--To write any documentation 
@Inherited--to apply annotation to child class 
@Target(value = { ElementType.TYPE })--at which level it should be applied
@Retention(value = RetentionPolicy.RUNTIME)-- at runtime,compile,class loading time values should load
	 * 
	 */
	
	int x() default 10;
	String y() default "Apple";

}
