package com.transaction.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transaction.demo.entity.Transaction;
import com.transaction.demo.service.TransactionService;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@PostMapping("/addTransaction")
	public Transaction createTransaction(@RequestBody Transaction transaction) {
		System.out.println("addTransaction");
		return transactionService.createTransaction(transaction);
	}

	@PostMapping("/addTransactionRecord")
	public Transaction addTransactionRecord(@RequestBody Map<String, Transaction> data) {
		System.out.println("addTransactionRecord");
		Transaction trans = data.get("transdata");
		return transactionService.createTransaction(trans);
	}

	@GetMapping("/getTransactionList")
	public List<Transaction> getTransactionList() {
		List<Transaction> transactionList = transactionService.getTransactionList();
		return transactionList;
	}
	
	@GetMapping("/getTransactionList/{id}")
    public List<Transaction> getAccount(@PathVariable Long id) {
        return transactionService.getTransactionDetailsByAccId(id);
    }
}
