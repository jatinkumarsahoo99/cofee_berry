package com.example.demo.service;

import com.example.demo.entity.CustomerModel;
import com.example.demo.entity.UserNewModel;
import com.example.demo.entity.UserNewModel1;

public interface CustomerService {
	
	UserNewModel createUser(UserNewModel1 user);
	
	UserNewModel readUser();
	
	UserNewModel updateUser(UserNewModel1 user);
	
	void deleteUser();
	
	/* UserNewModel getLoggedInUser(); */
	
	/* Integer fetchCustomerCount(); */

}
