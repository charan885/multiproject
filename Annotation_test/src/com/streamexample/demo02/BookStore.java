package com.streamexample.demo02;

import java.io.Serializable;
import java.util.List;

public class BookStore implements Serializable {
	
	private int bookisbn;
	private int bookid;
	private String bookauthor;
	private Double bookprice;
	private String bookname;
	private boolean bookavailability;
	public BookStore() {
		super();
	}
	public BookStore(int bookisbn, int bookid, String bookauthor, Double bookprice, String bookname,
			boolean bookavailability) {
		super();
		this.bookisbn = bookisbn;
		this.bookid = bookid;
		this.bookauthor = bookauthor;
		this.bookprice = bookprice;
		this.bookname = bookname;
		this.bookavailability = bookavailability;
	}
	public int getBookisbn() {
		return bookisbn;
	}
	public void setBookisbn(int bookisbn) {
		this.bookisbn = bookisbn;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookauthor() {
		return bookauthor;
	}
	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}
	public Double getBookprice() {
		return bookprice;
	}
	public void setBookprice(Double bookprice) {
		this.bookprice = bookprice;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public boolean isBookavailability() {
		return bookavailability;
	}
	public void setBookavailability(boolean bookavailability) {
		this.bookavailability = bookavailability;
	}
	@Override
	public String toString() {
		return "BookStore [bookisbn=" + bookisbn + ", bookid=" + bookid + ", bookauthor=" + bookauthor + ", bookprice="
				+ bookprice + ", bookname=" + bookname + ", bookavailability=" + bookavailability + "]";
	}
	
	
	

}
