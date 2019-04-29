package com.sales.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sales.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

	// SQL query which returns only books NOT currently on loan
	// SELECT * FROM books AS b WHERE b.bid NOT IN (SELECT bid FROM loans);
	@Query(value = "SELECT * FROM books AS b WHERE b.bid NOT IN (SELECT bid FROM loans)", nativeQuery = true)
	ArrayList<Book> getNotOnLoan();
	
}
