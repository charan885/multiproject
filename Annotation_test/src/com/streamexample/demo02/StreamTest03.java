package com.streamexample.demo02;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * store 6 books in obj
 * insert with  stream api
 * of---
 * create a new booklist below500books --contains below 500rs books
 * create a new books name java,headfirst , java func  --only java boks-- list
 * create a list 10discount book list  --map
 * crea above700book sum print 
 * 
 * @author user
 *
 */
public class StreamTest03 {

	public static void main(String[] args) {
		BookStore bookStore1=new BookStore(2365, 1, "Ravi", 230.00D, "Java Head First", true);
		BookStore bookStore2=new BookStore(2364, 2, "Raju", 330.76D, "Java Head First Servlets", true);
		BookStore bookStore3=new BookStore(3259, 3, "Ajay", 685.00D, " Head First Spring", true);
		BookStore bookStore4=new BookStore(7523, 4, "Arun", 758.65D, "Java Head First Springboot", true);
		BookStore bookStore5=new BookStore(8495, 5, "Vinay", 653.45D, " Head First networking", true);
		BookStore bookStore6=new BookStore(7455, 6, "Tarun", 897.00D, "Java Head First Microservices", false);
		
		
		
		
		Stream<BookStore> s=Stream.of(bookStore1,bookStore2,bookStore3,bookStore4,bookStore5,bookStore6);
        List<BookStore>   bookslist= s.collect(Collectors.toList());
		
        Stream<BookStore> s1=Stream.of(bookStore1,bookStore2,bookStore3,bookStore4,bookStore5,bookStore6);
        List<BookStore>   bookslist1= s1.collect(Collectors.toList());
		
        Stream<BookStore> s2=Stream.of(bookStore1,bookStore2,bookStore3,bookStore4,bookStore5,bookStore6);
        List<BookStore>   bookslist2= s2.collect(Collectors.toList());
        
        Stream<BookStore> s3=Stream.of(bookStore1,bookStore2,bookStore3,bookStore4,bookStore5,bookStore6);
        List<BookStore>   bookslist3= s3.collect(Collectors.toList());
        
        bookslist.forEach(System.out::println);
        System.out.println("----------------");
        List<BookStore>   books500Dlist=  bookslist.stream().filter(x->x.getBookprice()<500D).collect(Collectors.toList());
        books500Dlist.forEach(System.out::println);
        
        System.out.println("----------------");
        List<BookStore>   booksjavalist=  bookslist1.stream().filter(y->y.getBookname().startsWith("Java")).collect(Collectors.toList());
        booksjavalist.forEach(System.out::println);
        
        System.out.println("--------");
        List<Double>   books10Discountlist=  bookslist2.stream().map(y->y.getBookprice()-y.getBookprice()*0.1D).collect(Collectors.toList());
        books10Discountlist.forEach(System.out::println);
        
        System.out.println("--------");
        Double totalprice=  bookslist3.stream().filter(p->p.getBookprice()>700).map(pm->pm.getBookprice()).reduce((t1,t2)->(t1+t2)).get().doubleValue();
        System.out.println(totalprice);
        
       // System.out.println("--------");
      //  List<Double>   bookstotalDlist=  bookslist2.stream().reduce((x1,x2)->(x1+x2)).;
     //   bookstotalDlist.forEach(System.out::println);
        
	}

}
