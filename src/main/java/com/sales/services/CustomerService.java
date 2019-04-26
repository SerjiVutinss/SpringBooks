package com.sales.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Customer;
import com.sales.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepo;
	
	public Iterable<Customer> get() {
		return customerRepo.findAll();
	}
	
	public Customer get(Long id) {
		return customerRepo.findOne(id);
	}
	
	public void add(Customer c) {
		customerRepo.save(c);
	}
	
}
