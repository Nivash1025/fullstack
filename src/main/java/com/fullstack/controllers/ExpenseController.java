package com.fullstack.controllers;

import java.math.BigDecimal;
import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.models.Expense;
import com.fullstack.service.ExpenseService;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class ExpenseController {
	@Autowired
	ExpenseService service;

	@GetMapping("/all")
	public ResponseEntity<List<Expense>> getAllExpense() {
		List<Expense> list=service.findAll();
		return new ResponseEntity<List<Expense>>(list,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Expense> saveExpense(@RequestBody Expense expense){
		this.service.save(expense);
		return new ResponseEntity<Expense>(expense,HttpStatus.OK);
	}
	
	@GetMapping("/all/{id}")
	public ResponseEntity<Expense> getExpense(@PathVariable("id") long id){
		Expense exp=this.service.findById(id);
		return new ResponseEntity<Expense>(exp,HttpStatus.OK);
	}
	
	@DeleteMapping("/all/{id}")
	public ResponseEntity<String> deleteExpense(@PathVariable("id") long id){
		//Expense exp=this.service.findById(id);
		this.service.removeById(id);
		return new ResponseEntity<String>("Expense deleted successfully",HttpStatus.OK);
	}
	/*@DeleteMapping("/all/{id}")
	public ResponseEntity<Expense> getExpense(@PathVariable("id") long id){
		Expense exp=this.service.findById(id);
		return new ResponseEntity<Expense>(exp,HttpStatus.OK);
	} */
	
	@GetMapping("/amount/{amount}")
	public ResponseEntity<List<Expense>> filterByAmount(@PathVariable("amount") BigDecimal amount){
		List<Expense> expenses=this.service.filterByAmount(amount);
		return new ResponseEntity<List<Expense>>(expenses,HttpStatus.OK);
	}
}
