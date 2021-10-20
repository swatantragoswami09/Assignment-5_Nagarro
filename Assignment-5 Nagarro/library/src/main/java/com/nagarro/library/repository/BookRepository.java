package com.nagarro.library.repository;

import org.springframework.data.repository.CrudRepository;

import com.nagarro.library.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{
	public Book findById(int id);

}
