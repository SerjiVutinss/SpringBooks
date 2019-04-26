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

	@RequestMapping(value = "/showLoans", method = RequestMethod.GET)
	public String showLoans(Model m) {

		List<Loan> loans = (List<Loan>) loanService.get();
		m.addAttribute("loans", loans);
		return "showLoans";
	}

	@RequestMapping(value = "/newLoan", method = RequestMethod.GET)
	public String addLoan(Model m) {
		AddLoanModel lm = new AddLoanModel();
		m.addAttribute("loanModel", lm);
		return "newLoan";
	}

	// TODO: try to get this method working instead of using the AddLoanModel method
//	@RequestMapping(value = "/newLoan", method=RequestMethod.POST)
//	public String addLoan(@Valid @ModelAttribute("loan") Loan loan, BindingResult result) {
//		
//		if(result.hasErrors()) {
//			return "newLoan";
//		}
//		
//		// add to repo
//		cs.add(loan);
//		
//		return "redirect:showLoans";
//	}

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

}
