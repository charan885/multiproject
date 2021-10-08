package com.streamexample.demo01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamTest02 {

	public static void main(String[] args) {
         Employee employee1=new Employee(1, "Depak", 25000D);
         Employee employee2=new Employee(2, "Tarun",35000D);
         Employee employee3=new Employee(3, "Ajay", 29000D);
         Employee employee4=new Employee(4, "Arun", 40000D);
         ArrayList<Employee> arrayList=new ArrayList<Employee>();
         arrayList.add(employee1);
         arrayList.add(employee2);
         arrayList.add(employee3);
         arrayList.add(employee4);
         
         //create the emplist whose sal is greater than 30000D
         ArrayList<Employee> above30KarrayList=new ArrayList<Employee>();
         arrayList.forEach(emp->{
        	 if(emp.getEsal()>30000D) {
        		 above30KarrayList.add(emp);
        	 }
         });
         
         above30KarrayList.forEach(System.out::println);

         List<Employee> above30KempList  =  arrayList.stream().filter(x->x.getEsal()>30000D).collect(Collectors.toList());
         above30KempList.forEach(System.out::println);
         
         List<Integer> intergersList=   Arrays.asList(100,250,1000,600,800);
         Stream<Integer> items= intergersList.stream();
         Stream<Integer> items1= intergersList.stream();
         Stream<Integer> items2= intergersList.stream();
         
         //add above 500rs 
         List<Integer> int500aboveList  = items.filter(x->x>500).collect(Collectors.toList());
         int500aboveList.forEach(System.out::println);
         
         List<Integer> add15rsList  = items1.map(y->y+15).collect(Collectors.toList());
         add15rsList.forEach(System.out::println);
         
         int total=  items2.reduce((x1,x2)->(x1+x2)).get().intValue();
         System.out.println(total);
         
         
	}

}
