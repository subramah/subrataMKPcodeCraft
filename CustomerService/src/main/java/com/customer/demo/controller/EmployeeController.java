//package com.customer.demo.controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.customer.demo.entity.Employee;
//import com.customer.service.EmployeeService;
//@RestController
//public class EmployeeController {
//	@Autowired
//	EmployeeService employeeService;
//	
//	@GetMapping("/employeeList")
//    public ResponseEntity <List<Employee>> getBookData()
//    
//      {
//      	       List<Employee> empdata= EmployeeService.getAllEmployee();
//      	       
//      	       if(empdata.size()<=0)
//      	       {
//      	    	   return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//      	    	     
//      	    	   
//      	       }
//      	       else
//      	       {
//      	    	 return  ResponseEntity.of(Optional.of(empdata));
//      	       }
//      }
//}
