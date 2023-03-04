package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CustomerDetails;
import com.example.demo.entity.CustomerModel;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/test")
	public String checkProject() {
		return "Jatin Kumar Sahoo";
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<CustomerDetails> save(@Valid @RequestBody CustomerModel user) {
		return new ResponseEntity<CustomerDetails>(customerService.createUser(user), HttpStatus.CREATED);
	
	}

}
