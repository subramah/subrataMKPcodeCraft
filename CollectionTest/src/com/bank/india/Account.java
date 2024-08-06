package com.bank.india;

import java.util.ArrayList;
import java.util.List;

public class Account {
	private String accountNumber;
	private Customer customer;
	private double balance;
	private List<Transaction> transactions;

	public Account(String accountNumber, Customer customer) {
		this.accountNumber = accountNumber;
		this.customer = customer;
		this.balance = 0.0;
		this.transactions = new ArrayList<>();
	}

	public void deposit(double amount) {
		balance += amount;
		transactions.add(new Transaction("Deposit", amount));
	}

	public void withdraw(double amount) {
		if (balance >= amount) {
			balance -= amount;
			transactions.add(new Transaction("Withdrawal", -amount));
		} else {
			System.out.println("Insufficient funds. Current balance: $" + balance);
		}
	}

	public void transfer(Account targetAccount, double amount) {
		if (balance >= amount) {
			balance -= amount;
			targetAccount.deposit(amount);
			transactions.add(new Transaction("Transfer to " + targetAccount.getAccountNumber(), -amount));
		} else {
			System.out.println("Insufficient funds for transfer. Current balance: $" + balance);
		}
	}

	public void displayLast10Transactions() {
		System.out.println("Last 10 Transactions for Account " + accountNumber + ":");
		for (int i = Math.max(0, transactions.size() - 10); i < transactions.size(); i++) {
			System.out.println(transactions.get(i));
		}
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	class Transaction {
        private String type;
        private double amount;

        public Transaction(String type, double amount) {
            this.type = type;
            this.amount = amount;
        }
	}
}
