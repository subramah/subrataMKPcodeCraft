package com.jpaservice.base.controller;

import com.jpaservice.base.entity.Customer;

public interface InvoiceDao {

	Customer createOrder(Customer customer);

}
