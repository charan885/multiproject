package com.optionalexample.test01;

import java.util.Optional;

/*
 * Java introduced a new class Optional in jdk8. 
 * It is a public final class and used to deal with NullPointerException in Java application. 
 * You must import java.util package to use this class. 
 * It provides methods which are used to check the presence of value for particular variable.
 */


public class OptionalTest {

	public static void main(String[] args) {
		String[] str = new String[10];  
        Optional<String> checkNull = Optional.ofNullable(str[5]);  
        if(checkNull.isPresent()){  // check for value is present or not  
            String lowercaseString = str[5].toLowerCase();  
            System.out.print(lowercaseString);  
        }else  
            System.out.println("string value is not present");  
	}

}
