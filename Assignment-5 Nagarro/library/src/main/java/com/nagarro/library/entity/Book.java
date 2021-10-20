package com.nagarro.library.entity;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="book_id")
	private int bookcode;
	private String bookname;
	
	
	private String author;
	private String dataadded;
	
	public Book() {
		
	}
	
	
	public Book(int bookcode, String bookname, String author, String dataadded) {
		super();
		this.bookcode = bookcode;
		this.bookname = bookname;
		this.author = author;
		this.dataadded = dataadded;
	}

	public int getbookcode() {
		return bookcode;
	}
	public void setbookcode(int bookcode) {
		this.bookcode = bookcode;
	}
	public String getbookname() {
		return bookname;
	}
	public void setbookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}



	public String getDataadded() {
		return dataadded;
	}



	public void setDataadded(String dataadded) {
		this.dataadded = dataadded;
	}
	
}
