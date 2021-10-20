package com.nagarro.library.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.library.Service.BookService;
import com.nagarro.library.entity.Book;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> list=this.bookService.getAllBooks();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			return ResponseEntity.status(HttpStatus.CREATED).body(list);
		}
		
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
		Book book= bookService.getBookById(id);	
		if(book==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book b=null;
		try {
			 b=this.bookService.addBook(book);
			 return ResponseEntity.of(Optional.of(b));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int  bookId) {
		 try{
			 this.bookService.deleteBook(bookId);
			 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		 }catch(Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		 }
	}
	
	//update book
		@PutMapping("/books/{bookId}")
		public ResponseEntity<Book> updateBook(@PathVariable("bookId") int bookId,@RequestBody Book book) {
			try{
				this.bookService.updateBook(bookId,book);
				return ResponseEntity.ok().body(book);
			}catch(Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			
		}

}
