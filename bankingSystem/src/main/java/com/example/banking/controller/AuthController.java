package com.example.banking.controller;

import com.example.banking.dto.AccountDto;
import com.example.banking.dto.CustomerDto;
import com.example.banking.dto.DepositDto;
import com.example.banking.dto.TransactionDto;
import com.example.banking.dto.UserDto;
import com.example.banking.dto.WithdrawDto;
import com.example.banking.entity.User;
import com.example.banking.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AuthController {
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private UserService userService;

	public AuthController(UserService userService) {
		this.userService = userService;
	}

	// handler method to handle register user form submit request
	@PostMapping("/register/save")
	public String registration(@Valid @ModelAttribute("user") UserDto user, BindingResult result, Model model) {
		User existing = userService.findByEmail(user.getEmail());
		if (existing != null) {
			result.rejectValue("email", null, "There is already an account registered with that email");
		}
		if (result.hasErrors()) {
			model.addAttribute("user", user);
			return "register";
		}

		User savedUser = userService.saveUser(user);
		if (savedUser.getId() != null) {
			String uri = "http://localhost:8182/api/account/addAccount";
			org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
			headers.set("Content-type", "application/json");
			// headers.setContentType(MediaType.APPLICATION_JSON);
			AccountDto accountDto = new AccountDto();
			accountDto.setAccountHolderName(user.getFirstName() + " " + user.getLastName());
			accountDto.setBalance(0.00);

			Map<String, AccountDto> mapObj = new HashMap<>();
			mapObj.put("accountdata", accountDto);

			HttpEntity<Map<String, AccountDto>> reqEntity1 = new HttpEntity<>(mapObj, headers);

			ResponseEntity<AccountDto> AccountDtoUpdate = restTemplate.exchange(uri, HttpMethod.POST, reqEntity1,
					AccountDto.class);
		}
		return "redirect:/register?success";
	}

	@GetMapping("/users")
	public String listRegisteredUsers(Model model) {
		List<UserDto> users = userService.findAllUsers();

		List<CustomerDto> customerDetails = restTemplate
				.getForObject("http://localhost:8181/api/customer/getCustomerList", List.class);

		AccountDto accountDetails = restTemplate.getForObject("http://localhost:8182/api/account/3", AccountDto.class);

		List<AccountDto> accountlist = restTemplate.getForObject("http://localhost:8182/api/account/getAccountsList",
				List.class);

		model.addAttribute("users", users);
		model.addAttribute("customerDetails", customerDetails);
		model.addAttribute("accountDetails", accountDetails);
		model.addAttribute("accountlist", accountlist);
		return "users";
	}

	@GetMapping("/transaction")
	public String transactionForm(Model model) {
		List<AccountDto> accountList = restTemplate.getForObject("http://localhost:8182/api/account/getAccountsList",
				List.class);
		model.addAttribute("accountlist", accountList);
		return "transaction";
	}

//	@PostMapping("/getResultsByAccId/{id}")
//    public String getResultsByAccId(@PathVariable("id") String accountId,Model model) {
//		System.out.println("inside============="+accountId);
//		List<TransactionDto> transList = restTemplate.getForObject("http://localhost:8183/api/transaction/getTransactionList/"+accountId, List.class);
//		System.out.println("resp============="+transList);
//		model.addAttribute("transList", transList);
//		return "redirect:/transaction";
//	}

}
