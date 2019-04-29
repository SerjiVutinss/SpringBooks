package com.sales.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Book;
import com.sales.services.BookService;

@Controller
public class BookController {

	@Autowired
	BookService bookService;

	@RequestMapping(value = "/showBooks", method = RequestMethod.GET)
	public String showbooks(Model m) {

		List<Book> books = (List<Book>) bookService.get();
		m.addAttribute("books", books);
		return "showBooks";
	}

	@RequestMapping(value = "/addBook", method = RequestMethod.GET)
	public String addBook(Model m) {

		Book b = new Book();
		m.addAttribute("book", b);
		return "addBook";
	}

	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public String addbook(@Valid @ModelAttribute("book") Book book, BindingResult result) {


		if (result.hasErrors()) {
			return "addBook";
		}

		// add to repo
		bookService.add(book);

		return "redirect:showBooks";
	}

}
