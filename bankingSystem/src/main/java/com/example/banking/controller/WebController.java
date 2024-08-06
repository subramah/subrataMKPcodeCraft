package com.example.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.example.banking.dto.AccountDto;
import com.example.banking.dto.CustomerDto;
import com.example.banking.dto.DepositDto;
import com.example.banking.dto.TransactionDto;
import com.example.banking.dto.UserDto;
import com.example.banking.dto.WithdrawDto;

@Controller
public class WebController {

	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("index")
	public String home() {
		return "index";
	}

	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}

	// handler method to handle user registration request
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		UserDto user = new UserDto();
		model.addAttribute("user", user);
		return "register";
	}

	@GetMapping("/deposit")
	public String amountDepositForm(Model model) {
		DepositDto deposit = new DepositDto();
		model.addAttribute("deposit", deposit);
		List<AccountDto> accountList = restTemplate
				.getForObject("http://localhost:8182/api/account/getAccountsList", List.class);
		model.addAttribute("accountlist", accountList);
		return "deposit";
	}

	@GetMapping("/withdraw")
	public String amountWithdrawForm(Model model) {
		WithdrawDto withdraw = new WithdrawDto();
		model.addAttribute("withdraw", withdraw);
		return "withdraw";
	}

	
}
