package com.example.demo.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CustomerDetails;
import com.example.demo.entity.CustomerModel;
import com.example.demo.exception.ItemExistsException;
import com.example.demo.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	
	@Autowired
	private CustomerRepository customerRepository;
	
	

	@Override
	public CustomerDetails createUser(CustomerModel user) {
		if (customerRepository.existsByEmail(user.getCustomerEmail())) {
			throw new ItemExistsException("User is already register with email:"+user.getCustomerEmail());
		}
		CustomerDetails newUser = new CustomerDetails();
		BeanUtils.copyProperties(user, newUser);
		newUser.setPassword((newUser.getPassword()));
		return customerRepository.save(newUser);
	}

	@Override
	public CustomerDetails readUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDetails updateUser(CustomerModel user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CustomerDetails getLoggedInUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
