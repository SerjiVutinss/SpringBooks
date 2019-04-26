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

@Controller
public class LoanController {
	
	@Autowired
	LoanService ls;
	
	@Autowired
	CustomerService cs;
	
	@Autowired
	BookService bs;

	@RequestMapping(value = "/showLoans", method = RequestMethod.GET)
	public String showLoans(Model m) {

		List<Loan> loans = (List<Loan>)ls.get();
		m.addAttribute("loans", loans);
		return "showLoans";
	}

	@RequestMapping(value = "/newLoan", method = RequestMethod.GET)
	public String addLoan(Model m) {
		AddLoanModel lm = new AddLoanModel();
		m.addAttribute("loanModel", lm);
		return "newLoan";
	}
	
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
	
	@RequestMapping(value = "/newLoan", method=RequestMethod.POST)
	public String addLoan(@Valid @ModelAttribute("loanModel") AddLoanModel lm, BindingResult result) {
		
		
		Customer c = cs.get(lm.getCustomerId());
		Book b = bs.get(lm.getBookId());
		
		Loan l = new Loan();
		l.setCust(c);
		l.setBook(b);
		l.setDueDate("2019-12-01");
		
		if(result.hasErrors()) {
			return "newLoan";
		}
		
		// add to repo
		ls.add(l);
		
		return "redirect:showLoans";
	}

}
