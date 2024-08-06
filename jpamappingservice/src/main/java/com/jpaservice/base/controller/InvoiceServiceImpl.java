package com.jpaservice.base.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.jpaservice.base.entity.Customer;

public class InvoiceServiceImpl implements InvoiceService{

	@Autowired
	InvoiceDao invoiceDao;
	
	@Override
	public Customer createOrder(Customer customer) {
		// TODO Auto-generated method stub
		return invoiceDao.createOrder(customer);
	}

}
