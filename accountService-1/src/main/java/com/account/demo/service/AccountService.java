package com.account.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.demo.entity.Account;
import com.account.demo.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	public Account createAccount(Account account) {
		return accountRepository.save(account);
	}

	public Optional<Account> getAccount(Long id) {
		return accountRepository.findById(id);
	}

	public Account deposit(Long id, double amount) {
		Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
		System.out.println("deposit controller");
		account.setBalance(account.getBalance() + amount);
		Account accountObj = accountRepository.save(account);
		/*
		 * try { String uri =
		 * "http://localhost:8183/api/transaction/addTransactionRecord";
		 * org.springframework.http.HttpHeaders headers = new
		 * org.springframework.http.HttpHeaders(); headers.set("Content-type",
		 * "application/json"); // headers.setContentType(MediaType.APPLICATION_JSON);
		 * TransactionDto transactionDto = new TransactionDto();
		 * transactionDto.setAccount_id(account.getId());
		 * transactionDto.setAccountHolderName(account.getAccountHolderName());
		 * transactionDto.setAmount(amount);
		 * transactionDto.setOpeningAmount(account.getBalance());
		 * transactionDto.setClosingAmount(accountObj.getBalance());
		 * 
		 * System.out.println("TTTTTTT" + transactionDto);
		 * 
		 * Map<String, TransactionDto> mapObj = new HashMap<>(); mapObj.put("transdata",
		 * transactionDto);
		 * 
		 * HttpEntity<Map<String, TransactionDto>>- reqEntity = new HttpEntity<>(mapObj,
		 * headers);
		 * 
		 * ResponseEntity<TransactionDto> accountupdate = restTemplate.exchange(uri,
		 * HttpMethod.POST, reqEntity, TransactionDto.class);
		 * 
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 */ return accountObj;
	}

	public Account withdraw(Long id, double amount) {
		Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
		if (account.getBalance() < amount) {
			throw new RuntimeException("Insufficient funds");
		}
		account.setBalance(account.getBalance() - amount);
		return accountRepository.save(account);
	}

	public List<Account> getAllAccountList() {
		// TODO Auto-generated method stub
		List<Account> accountList = accountRepository.findAll();
		return accountList;
	}

}
