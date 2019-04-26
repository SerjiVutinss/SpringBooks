package com.sales.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sales.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
