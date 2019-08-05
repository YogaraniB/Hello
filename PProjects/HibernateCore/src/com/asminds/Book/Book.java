package com.asminds.Book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Book_DB")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int bookid;
private String bookname;
private String bookprice;
public int getBookid() {
	return bookid;
}
public void setBookid(int bookid) {
	this.bookid = bookid;
}
public String getBookname() {
	return bookname;
}
public void setBookname(String bookname) {
	this.bookname = bookname;
}
public String getBookprice() {
	return bookprice;
}
public void setBookprice(String bookprice) {
	this.bookprice = bookprice;
}
public Book(int bookid, String bookname, String bookprice) {
	super();
	this.bookid = bookid;
	this.bookname = bookname;
	this.bookprice = bookprice;
}
public Book() {
	super();
	// TODO Auto-generated constructor stub
}


}
