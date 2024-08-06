package com.customer.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.demo.entity.Customer;

public interface CustomerServiceRepository extends JpaRepository<Customer, Integer> {

}
