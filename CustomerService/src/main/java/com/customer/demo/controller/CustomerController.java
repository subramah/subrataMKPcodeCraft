package com.customer.demo.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.customer.demo.entity.Book;
import com.customer.demo.entity.Customer;
import com.customer.demo.entity.Library;
import com.customer.demo.entity.Product;
import com.customer.demo.repository.BookRepository;
import com.customer.demo.repository.CustomerServiceRepository;
import com.customer.demo.repository.LibraryRepository;
import com.customer.demo.repository.ProductServiceRepository;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	CustomerServiceRepository customerServiceRepository;
	@Autowired
	ProductServiceRepository productServiceRepository;

	private final BookRepository bookRepository;
	private final LibraryRepository libraryRepository;

	@Autowired
	public CustomerController(BookRepository bookRepository, LibraryRepository libraryRepository) {
		this.bookRepository = bookRepository;
		this.libraryRepository = libraryRepository; 
	}

	// http://localhost:8181/api/customer/addCustomer
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		try {

//			List<Product> prod= customer.getProduct();
//			for(int i =0;i<prod.size();i++) {
//				Product p=new Product();
//			
//			}
			// List<Product>
			// product=productServiceRepository.saveAll(customer.getProduct());
			Customer savedcustomer = customerServiceRepository.save(customer);

			return new ResponseEntity<>(savedcustomer, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
		}
	}

	// http://localhost:8181/api/customer/getCustomerList
	@GetMapping("/getCustomerList")
	public List<Customer> getCustomerList() {
		List<Customer> customerList = customerServiceRepository.findAll();
		return customerList;
	}

	@PostMapping("/books")
	public ResponseEntity<Book> create(@RequestBody @Validated Book book) {
		Optional<Library> optionalLibrary = libraryRepository.findById(book.getLibrary().getId());
		if (!optionalLibrary.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}

		book.setLibrary(optionalLibrary.get());

		Book savedBook = bookRepository.save(book);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedBook.getId())
				.toUri();

		return ResponseEntity.created(location).body(savedBook);
	}

	@PostMapping("/libraries")
	public ResponseEntity<Library> create(@Validated @RequestBody Library library) {
		Library savedLibrary = libraryRepository.save(library);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedLibrary.getId()).toUri();

		return ResponseEntity.created(location).body(savedLibrary);
	}

}
