package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CustomerModel;
import com.example.demo.entity.UserNewModel;
import com.example.demo.entity.UserNewModel1;
import com.example.demo.service.CustomerService;

@RestController
public class JpaControlleer {
	
	@Autowired()
	private CustomerService customerService;
	
	/*
	 * @Autowired(required = true) private CustomerCurdRepository cus;
	 */
	
	
	/*
	 * @Autowired(required = true) private CustomerRepository cus1;
	 */
	
	@GetMapping("/test")
	public String checkProject() {
		return "Jatin Kumar Sahoo";
	
	}
	
	@PostMapping("/register")
	public ResponseEntity<UserNewModel> save(@Valid @RequestBody UserNewModel1 user) {
		return new ResponseEntity<UserNewModel>(customerService.createUser(user), HttpStatus.CREATED);
	
	}

}
