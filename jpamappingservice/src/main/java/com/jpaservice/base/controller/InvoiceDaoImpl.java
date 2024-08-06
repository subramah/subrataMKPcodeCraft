package com.jpaservice.base.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.jpaservice.base.entity.Customer;

public class InvoiceDaoImpl implements InvoiceDao {

	@Autowired
	CustomerRepository customerRepository;
	
	
	@Override
	public Customer createOrder(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

}
