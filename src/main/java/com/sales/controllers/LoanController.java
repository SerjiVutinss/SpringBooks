package com.sales.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.AddLoanModel;
import com.sales.models.Book;
import com.sales.models.Customer;
import com.sales.models.Loan;
import com.sales.services.BookService;
import com.sales.services.CustomerService;
import com.sales.services.LoanService;
import com.sales.utils.DateUtils;

@Controller
public class LoanController {

	@Autowired
	LoanService loanService;
	@Autowired
	CustomerService customerService;
	@Autowired
	BookService bookService;

	//// show loans
	@RequestMapping(value = "/showLoans", method = RequestMethod.GET)
	public String showLoans(Model m) {

		List<Loan> loans = (List<Loan>) loanService.get();
		m.addAttribute("loans", loans);
		return "showLoans";
	}
	//// end show loans

	//// new loan
	@RequestMapping(value = "/newLoan", method = RequestMethod.GET)
	public String addLoan(Model m) {

		//// Customers dropdown
		// get all customers from db
		ArrayList<Customer> customers = (ArrayList<Customer>) customerService.get();
		// add customers to a map
		Map<Long, String> customersMap = new HashMap<Long, String>();
		for (Customer c : customers) {
			customersMap.put(c.getcId(), c.getcName());
		}
		m.addAttribute("customerList", customersMap);
		//// End Customer Dropdown

		//// Books dropdown
		// get all books from db
		ArrayList<Book> books = (ArrayList<Book>) bookService.get();
		// add books to a map
		Map<Long, String> booksMap = new HashMap<Long, String>();
		for (Book b : books) {
			booksMap.put(b.getBid(), b.getTitle());
		}
		// add map to model
		m.addAttribute("bookList", booksMap);
		//// End Books Dropdown

		// create new custom AddLoanModel and add to model
		AddLoanModel lm = new AddLoanModel();
		m.addAttribute("loanModel", lm);
		
		return "newLoan";
	}

	@RequestMapping(value = "/newLoan", method = RequestMethod.POST)
	public String addLoan(@Valid @ModelAttribute("loanModel") AddLoanModel lm, BindingResult result) {

		// get the related customer and book models
		Customer c = customerService.get(lm.getCustomerId());
		Book b = bookService.get(lm.getBookId());

		// create a new loan model and set its customer and book attributes to the
		// retrieved models
		Loan l = new Loan();
		l.setCust(c);
		l.setBook(b);

		// static helper method which adds the customer's loan period to the current
		// date
		String dueDate = DateUtils.addToCurrentDate(c.getLoanPeriod());

		l.setDueDate(dueDate);

		if (result.hasErrors()) {
			return "newLoan";
		}

		// add to repo
		loanService.add(l);

		return "redirect:showLoans";
	}
	//// end new loan

	//// delete loan
	@RequestMapping(value = "/deleteLoan", method = RequestMethod.GET)
	public String deleteLoan(Model m) {
		
		// get all loans and create list
		ArrayList<Loan> loans = (ArrayList<Loan>) loanService.get();
		// create a map to hold all loans
		Map<Long, String> loansMap = new HashMap<Long, String>();
		// add all loans to map
		String loanDescription;
		for(Loan l: loans) {
			loanDescription = l.getBook().getTitle() + " on loan to " + l.getCust().getcName() + " until " + l.getDueDate();
			loansMap.put(l.getLid(), loanDescription);
		}
		m.addAttribute("loansList", loansMap);
		
		Loan l = new Loan();
		m.addAttribute("loan", l);
		return "deleteLoan";
	}

	@RequestMapping(value = "/deleteLoan", method = RequestMethod.POST)
	public String deleteLoanPost(@ModelAttribute("loanModel") Loan l, BindingResult result) {

		Long loanID = l.getLid();
		Loan loan = loanService.get(loanID);
		loanService.delete(loan);

		if (result.hasErrors()) {
			return "deleteLoan";
		}

		return "redirect:showLoans";
	}
	//// end delete loan

//// Testing creating new loan using 'Loan' model
////	
//	@RequestMapping(value = "/newLoan", method = RequestMethod.GET)
//	public String addLoan(Model m) {
//		Loan loan = new Loan();
//		m.addAttribute("loanModel", loan);
//		return "newLoan";
//	}
//
////	 TODO: try to get this method working instead of using the AddLoanModel method
//	@RequestMapping(value = "/newLoan", method = RequestMethod.POST)
//	public String addLoan(@Valid @ModelAttribute("loanModel") Loan lm, BindingResult result) {
//
//		
//		if (result.hasErrors()) {
//			return "newLoan";
//		}
//		Loan savedLoan = loanService.add(lm);
//		System.out.println(savedLoan.getCust().getcName());
//		// set the due date using the static helper method
//		savedLoan.setDueDate(DateUtils.addToCurrentDate(savedLoan.getCust().getLoanPeriod()));
//
//		// add to repo
//		loanService.add(savedLoan);
//
//		return "redirect:showLoans";
//	}
////
//// End testing create loan using Loan model

}
