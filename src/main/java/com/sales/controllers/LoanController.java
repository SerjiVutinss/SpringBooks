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

import com.sales.models.Loan;
import com.sales.services.LoanService;

@Controller
public class LoanController {
	
	@Autowired
	LoanService cs;

	@RequestMapping(value = "/showLoans", method = RequestMethod.GET)
	public String showLoans(Model m) {

		List<Loan> loans = (List<Loan>)cs.get();
		m.addAttribute("loans", loans);
		return "showLoans";
	}

	@RequestMapping(value = "/newLoan", method = RequestMethod.GET)
	public String addLoan(Model m) {
		Loan c = new Loan();
		m.addAttribute("loan", c);
		return "newLoan";
	}
	
	@RequestMapping(value = "/newLoan", method=RequestMethod.POST)
	public String addLoan(@Valid @ModelAttribute("loan") Loan loan, BindingResult result) {
		
		if(result.hasErrors()) {
			return "newLoan";
		}
		
		// add to repo
		cs.add(loan);
		
		return "redirect:showLoans";
	}

}
