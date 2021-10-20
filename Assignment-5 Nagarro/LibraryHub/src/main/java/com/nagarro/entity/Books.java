package com.nagarro.entity;




public class Books {
	
	private String bookcode;
	private String bookname;
	private String author;
	private String dataadded;
	
	
	public Books() {
		
	}
	public Books(String bookcode, String bookname, String author, String dataadded) {
		super();
		this.bookcode = bookcode;
		this.bookname = bookname;
		this.author = author;
		this.dataadded = dataadded;
	}
	public String getBookcode() {
		return bookcode;
	}
	public void setBookcode(String bookcode) {
		this.bookcode = bookcode;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
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
