package com.example.demo.service;

import com.example.demo.entity.CustomerDetails;
import com.example.demo.entity.CustomerModel;

public interface CustomerService {
	
	CustomerDetails createUser(CustomerModel user);
	
	CustomerDetails readUser();
	
	CustomerDetails updateUser(CustomerModel user);
	
	void deleteUser();
	
	CustomerDetails getLoggedInUser();

}
