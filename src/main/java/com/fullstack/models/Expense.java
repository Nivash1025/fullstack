package com.fullstack.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity(name="tbl_expenses")
@Table(name="tbl_expenses")
//@Getter
//@Setter
public class Expense {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
   private long id;
	
   private String expense;
   private String description;
   private BigDecimal amount;
   
   Expense(){
   }
   
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getExpense() {
	return expense;
}
public void setExpense(String expense) {
	this.expense = expense;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public BigDecimal getAmount() {
	return amount;
}
public void setAmount(BigDecimal amount) {
	this.amount = amount;
}
@Override
public String toString() {
	return "Expense [id=" + id + ", expense=" + expense + ", description=" + description + ", amount=" + amount + "]";
}
   
	
}
