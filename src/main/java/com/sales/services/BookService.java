package com.sales.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Book;
import com.sales.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepo;

	public Iterable<Book> get() {
		return bookRepo.findAll();
	}

	public Book get(Long id) {
		return bookRepo.findOne(id);
	}

	public void add(Book b) {
		bookRepo.save(b);
	}

}
