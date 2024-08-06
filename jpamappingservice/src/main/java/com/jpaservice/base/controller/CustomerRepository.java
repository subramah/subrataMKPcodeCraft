package com.jpaservice.base.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpaservice.base.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
