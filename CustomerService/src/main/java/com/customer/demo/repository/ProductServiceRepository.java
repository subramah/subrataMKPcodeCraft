package com.customer.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.demo.entity.Product;

@Repository
public interface ProductServiceRepository extends JpaRepository<Product, Integer> {

}
