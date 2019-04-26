package com.sales.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sales.models.Loan;

public interface LoanRepository extends CrudRepository<Loan, Long>{

}
