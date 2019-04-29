package com.sales.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sales.models.Loan;
import com.sales.repositories.LoanRepository;

@Service
public class LoanService {

	@Autowired
	LoanRepository loanRepo;

	public Iterable<Loan> get() {
		return loanRepo.findAll();
	}

	public void add(Loan l) {
		loanRepo.save(l);
	}

	public Loan get(Long id) {
		return loanRepo.findOne(id);
	}

	public void delete(Loan l) {
		loanRepo.delete(l);
	}

}
