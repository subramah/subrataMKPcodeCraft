package com.customer.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.demo.entity.Library;

public interface LibraryRepository extends JpaRepository<Library, Integer> {

}
