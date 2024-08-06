package com.jpaservice.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpaservice.base.entity.Customer;

@RestController
public class InvoiceController {
	@Autowired
    InvoiceService invoiceService;
	
	
	public InvoiceController(InvoiceService invoiceService) {
		super();
		this.invoiceService = invoiceService;
	}
	@GetMapping("/demotest")
	public String demoTest() {
		return "JPA Implementation Started....";
	}
	@PostMapping("/createOrder")
	public Customer saveInvoice(@RequestBody Customer customer) {
		
		//Customer c=invoiceService.createOrder(customer);
		
		
		return customer;
	}
	
}
