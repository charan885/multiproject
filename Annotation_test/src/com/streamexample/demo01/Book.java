package com.streamexample.demo01;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Book implements Serializable {
	
	private int id;
	private String name;
	private float cost;
	
	public Book() {
		
	}
	
	public Book(int id, String name, float cost) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
	}
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", cost=" + cost + "]";
	}

	public static void main(String[] args) throws NullBookNameException {
        
		List<Book> booklist=Stream.of(
				new Book(1, "Let us c", 450F) ,
				new Book(2, "Let us cpp", 300F) ,
				new Book(3, "Head First Java", 500F) ,
				new Book(4, "Head First Servlets", 100F) 				
				).collect(Collectors.toList());
		 //1.empty
		System.out.println(Optional.empty());
		Book book1=new Book(55, "MyBook1", 5000F);
		
		//2.of
		System.out.println(Optional.of(book1.getName()));
		
		Book book2=new Book(55, null, 5000F);
		//System.out.println(Optional.of(book2.getName()));//NPE--it will not check  null
		
		//3.ofNullable
		Book book3=new Book(55, null, 5000F);
		System.out.println(Optional.ofNullable(book3.getName()));
		
		Book book4=new Book(55, "Java By Sai", 5000F);
		System.out.println(Optional.ofNullable(book4.getName()));
		
		//4.get()
		System.out.println(Optional.ofNullable(book4.getName()).get());
		
		//5.isPresent()
		Book book5=new Book(55, "Java By Sai", 5000F);
		book5.setName(null);
		System.out.println(Optional.ofNullable(book5.getName()).isPresent()?book5.getName():"No Name Given");
		
		//6.orElse()
		Book book6=new Book(55, "Java By Sai", 5000F);
		book6.setName(null);
		System.out.println(Optional.ofNullable(book6.getName()).orElse("Book Name Not Given"));
		
		//7.orElseGet()
		Book book7=new Book(55, "Java By Sai", 5000F);
		book7.setName(null);
		System.out.println(Optional.ofNullable(book7.getName()).orElseGet(()->"Book name is null"));
		
		//8.orElseThrow()
		Book book8=new Book(55, "Java By Sai", 5000F);
		book8.setName(null);
		System.out.println(Optional.ofNullable(book8.getName()).orElseThrow(()->new NullBookNameException()));
		
	}

}
