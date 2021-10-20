package com.nagarro.library.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nagarro.library.entity.Book;
import com.nagarro.library.repository.BookRepository;

@Component
public class BookService {
//	private static List<Book> list=new ArrayList<>();
	
	@Autowired
	private BookRepository bookRepository;
	
	//get all books
	public List<Book> getAllBooks(){
		
		List<Book> list= ( List<Book> )this.bookRepository.findAll();
		return list;
	}
	
	//get single book by id
	public Book getBookById(int id) {
		Book book=null;
		try {
//			book=list.stream().filter(e->e.getId()==id).findFirst().get();
			book=this.bookRepository.findById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	//adding book
	public Book addBook(Book b) {
//		 list.add(b);
		Book result=bookRepository.save(b);
		 return result;
	}
	
	//delete book
	public void deleteBook(int bid) {
//		list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
		bookRepository.deleteById(bid);
	}

	public void updateBook(int bookId, Book book) {
//		list = list.stream().map(b->{
//						if(b.getId()==bookId) {
//							b.setTitle(book.getTitle());
//							b.setAuthor(book.getAuthor());
//						}
//						return b;
//					}).collect(Collectors.toList());
		book.setbookcode(bookId);
		bookRepository.save(book);
		
	}
	
	
}
