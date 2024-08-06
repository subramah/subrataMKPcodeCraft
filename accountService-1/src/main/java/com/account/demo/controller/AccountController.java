package com.account.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.demo.entity.Account;
import com.account.demo.repository.AccountRepository;
import com.account.demo.service.AccountService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/account")
public class AccountController {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	AccountService accountService;

	@GetMapping("/getAccountsList")
	public List<Account> getAllAccountList() {
		List<Account> accountList = accountRepository.findAll();
		return accountList;
	}

	@PostMapping("/addAccount")
	public Account createAccount(@RequestBody Map<String, Account> data) {//@RequestBody Account account) {
		Account account = data.get("accountdata");
		return accountRepository.save(account);
	}

	@GetMapping("/{id}")
	public Optional<Account> getAccount(@PathVariable Long id) {
		return accountRepository.findById(id);
	}

	@PostMapping("/{id}/deposit")
	public Account deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {
		// System.err.println("deposit controller");
		Double amount = request.get("amount");
		return accountService.deposit(id, amount);
	}

	@PostMapping("/{id}/withdraw")
	public Account withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {
		Double amount = request.get("amount");
		return accountService.withdraw(id, amount);
	}
}
