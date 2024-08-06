package com.transaction.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transaction.demo.entity.Transaction;
import com.transaction.demo.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	
	public Transaction createTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return transactionRepository.save(transaction);
	}

	public List<Transaction> getTransactionList() {
		// TODO Auto-generated method stub
		return transactionRepository.findAll();
	}

	public List<Transaction> getTransactionDetailsByAccId(Long id) {
		// TODO Auto-generated method stub
		return transactionRepository.findByAccountId(id);
	}

}
