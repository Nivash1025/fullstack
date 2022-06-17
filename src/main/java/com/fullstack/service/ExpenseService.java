package com.fullstack.service;

import java.math.BigDecimal;
import java.util.List;

import com.fullstack.models.Expense;

public interface ExpenseService {
  List<Expense> findAll();
  Expense save(Expense expense);
  Expense findById(long id);
  void removeById(long id);
  List<Expense> filterByAmount(BigDecimal amount);
}
