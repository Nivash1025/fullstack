package com.fullstack.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstack.models.Expense;
import com.fullstack.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	ExpenseRepository repository;
	
	@Override
	public List<Expense> findAll() {
		return repository.findAll();
		
	}

	@Override
	public Expense save(Expense expense) {
		return repository.save(expense);
	}

	@Override
	public Expense findById(long id) {
		
		if(repository.findById(id).isPresent()) {
			return repository.findById(id).get();
		}
		else {
			return null;
		}
	}

	@Override
	public void removeById(long id) {
		this.repository.deleteById(id);
	}

	@Override
	public List<Expense> filterByAmount(BigDecimal amount) {
		return this.repository.getExpenseByAmount(amount);
	}

}
