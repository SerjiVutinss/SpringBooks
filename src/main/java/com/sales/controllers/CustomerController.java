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

import com.sales.models.Customer;
import com.sales.services.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService cs;

	@RequestMapping(value = "/showCustomers", method = RequestMethod.GET)
	public String showCustomers(Model m) {

		List<Customer> customers = (List<Customer>)cs.get();
		m.addAttribute("customers", customers);
		return "showCustomers";
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
	public String addCustomer(Model m) {
		Customer c = new Customer();
		m.addAttribute("customer", c);
		return "addCustomer";
	}
	
	@RequestMapping(value = "/addCustomer", method=RequestMethod.POST)
	public String addCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
		
		if(result.hasErrors()) {
			return "addCustomer";
		}
		
		// add to repo
		cs.add(customer);
		
		return "redirect:showCustomers";
	}

}
