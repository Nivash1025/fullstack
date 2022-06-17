package com.fullstack.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fullstack.models.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    public Expense save(Expense expense);
    public void deleteById(long id);
    
    @Query("select exp from tbl_expenses exp where exp.amount<:a")
    List<Expense> getExpenseByAmount(@Param("a") BigDecimal amount);
}
