package com.example.demo.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CustomerDetails;
import com.example.demo.entity.CustomerModel;
import com.example.demo.entity.UserNewModel;
import com.example.demo.entity.UserNewModel1;
import com.example.demo.exception.ItemExistsException;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired(required = true)
	private CustomerRepository customerRepository;
	
	/*
	 * @Autowired(required = true) private CustomerCurdRepository customecurdRepo;
	 */
	
	

	@Override
	public UserNewModel createUser(UserNewModel1 user) {
		if (customerRepository.existsByEmail(user.getUser_email())) {
			throw new ItemExistsException("User is already register with email:"+user.getEmail());
		}
		UserNewModel newUser = new UserNewModel();
		BeanUtils.copyProperties(user, newUser);
		newUser.setUser_password(user.getUser_password());

		return customerRepository.save(newUser);
		
		
	}

	@Override
	public UserNewModel readUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserNewModel updateUser(UserNewModel1 user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser() {
		// TODO Auto-generated method stub
		
	}

	/*
	 * @Override public UserNewModel getLoggedInUser() { // TODO Auto-generated
	 * method stub return null; }
	 */
	

}
