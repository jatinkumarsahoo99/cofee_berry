package com.example.demo.common.security;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserNewModel;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private CustomerRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("username==="+username);
		
		System.out.println("username==="+ userRepository.findByEmail(username).toString());
		
		UserNewModel userDetailsData  = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found for the email:"));
	
				System.out.println("userDetailsData"+userDetailsData.getEmail()); 
		return new org.springframework.security.core.userdetails.User(userDetailsData.getEmail(),userDetailsData.getUser_password(), new ArrayList<>());
	}

}
