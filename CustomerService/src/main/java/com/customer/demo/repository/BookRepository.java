package com.customer.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.demo.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
