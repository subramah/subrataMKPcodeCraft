package com.example.banking.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.example.banking.dto.AccountDto;
import com.example.banking.dto.DepositDto;
import com.example.banking.dto.TransactionDto;
import com.example.banking.dto.WithdrawDto;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountTransactionController {

	@Autowired
	RestTemplate restTemplate;

	// http://localhost:1244/deposit/save
	@PostMapping("/deposit/save")
	// @RequestParam("selectedAccount") Long accountId
	public String amountDeposit(@Valid @ModelAttribute("deposit") DepositDto deposit, Model model) {
		try {
			String uri = "http://localhost:8182/api/account/" + deposit.getId() + "/deposit";
			org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
			headers.set("Content-type", "application/json");
			Map<String, Double> obj = new HashMap();
			obj.put("amount", deposit.getBalance());
			HttpEntity<Map> reqEntity = new HttpEntity<>(obj, headers);
			ResponseEntity<AccountDto> accountupdate = restTemplate.exchange(uri, HttpMethod.POST, reqEntity,
					AccountDto.class);
			AccountDto accountDto = new AccountDto();
			if (accountupdate.getStatusCode().is2xxSuccessful()) {
				// Handle success
				accountDto = accountupdate.getBody();
				System.out.println("Account update successful. Account details: " + accountDto);

				try {
					String uri1 = "http://localhost:8183/api/transaction/addTransactionRecord";
					org.springframework.http.HttpHeaders headers1 = new org.springframework.http.HttpHeaders();
					headers1.set("Content-type", "application/json");
					// headers.setContentType(MediaType.APPLICATION_JSON);
					TransactionDto transactionDto = new TransactionDto();
					transactionDto.setAccountId(deposit.getId());
					transactionDto.setAccountHolderName(accountDto.getAccountHolderName());
					transactionDto.setAmount(deposit.getBalance());
					transactionDto.setType("deposit");
					transactionDto.setOpeningAmount(accountDto.getBalance() - deposit.getBalance());
					transactionDto.setClosingAmount(accountDto.getBalance());

					Map<String, TransactionDto> mapObj = new HashMap<>();
					mapObj.put("transdata", transactionDto);

					HttpEntity<Map<String, TransactionDto>> reqEntity1 = new HttpEntity<>(mapObj, headers);

					ResponseEntity<TransactionDto> Transactionupdate = restTemplate.exchange(uri1, HttpMethod.POST,
							reqEntity1, TransactionDto.class);

				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				// Handle error
				System.out.println("Account update failed. Status code: " + accountupdate.getStatusCode());
				System.out.println("Error message: " + accountupdate.getBody());
			}

			return "redirect:/deposit?success"; // Or any other appropriate view name

		} catch (Exception e) {
			// Handle exceptions (e.g., connection errors, invalid response)
			model.addAttribute("error", "An error occurred while processing the deposit.");
			return "error"; // Or any other appropriate view name
		}
	}

	@PostMapping("/withdraw/save")
	public String amountWithDraw(@Valid @ModelAttribute("deposit") WithdrawDto withdraw, Model model) {
		try {
			String uri = "http://localhost:8182/api/account/" + withdraw.getId() + "/withdraw";
			org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
			headers.set("Content-type", "application/json");
			Map<String, Double> obj = new HashMap();
			obj.put("amount", withdraw.getBalance());
			HttpEntity<Map> reqEntity = new HttpEntity<>(obj, headers);
			ResponseEntity<AccountDto> accountupdate = restTemplate.exchange(uri, HttpMethod.POST, reqEntity,
					AccountDto.class);
			AccountDto accountDto = new AccountDto();
			if (accountupdate.getStatusCode().is2xxSuccessful()) {
				// Handle success
				accountDto = accountupdate.getBody();
				System.out.println("Account update successful. Account details: " + accountDto);

				try {
					String uri1 = "http://localhost:8183/api/transaction/addTransactionRecord";
					org.springframework.http.HttpHeaders headers1 = new org.springframework.http.HttpHeaders();
					headers1.set("Content-type", "application/json");
					// headers.setContentType(MediaType.APPLICATION_JSON);
					TransactionDto transactionDto = new TransactionDto();
					transactionDto.setAccountId(withdraw.getId());
					transactionDto.setAccountHolderName(accountDto.getAccountHolderName());
					transactionDto.setAmount(withdraw.getBalance());
					transactionDto.setType("withdraw");
					transactionDto.setOpeningAmount(accountDto.getBalance() + withdraw.getBalance());
					transactionDto.setClosingAmount(accountDto.getBalance());

					Map<String, TransactionDto> mapObj = new HashMap<>();
					mapObj.put("transdata", transactionDto);

					HttpEntity<Map<String, TransactionDto>> reqEntity1 = new HttpEntity<>(mapObj, headers);

					ResponseEntity<TransactionDto> transactionupdate = restTemplate.exchange(uri1, HttpMethod.POST,
							reqEntity1, TransactionDto.class);

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				// Handle error
				System.out.println("Account update failed. Status code: " + accountupdate.getStatusCode());
				System.out.println("Error message: " + accountupdate.getBody());
			}
			return "redirect:/deposit?success"; // Or any other appropriate view name
		} catch (Exception e) {
			// Handle exceptions (e.g., connection errors, invalid response)
			model.addAttribute("error", "An error occurred while processing the deposit.");
			return "error"; // Or any other appropriate view name
		}
	}

	@PostMapping("/transaction/getResultsByAccId/{id}")
	public String getResultsByAccId(@RequestParam("selectedAccount") Long accountId, Model model) {
		// Assuming you have a method to get results by account ID
		List<TransactionDto> results = restTemplate
				.getForObject("http://localhost:8183/api/transaction/getTransactionList/" + accountId, List.class);
		model.addAttribute("transList", results);
		List<AccountDto> accountList = restTemplate.getForObject("http://localhost:8182/api/account/getAccountsList",
				List.class);
		model.addAttribute("accountlist", accountList);
		return "transaction"; // Return the name of your HTML template to display results
	}

}
