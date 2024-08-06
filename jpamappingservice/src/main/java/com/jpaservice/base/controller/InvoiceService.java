package com.jpaservice.base.controller;

import org.springframework.stereotype.Service;

import com.jpaservice.base.entity.Customer;

@Service
public interface InvoiceService {

	public Customer createOrder(Customer customer);

}
