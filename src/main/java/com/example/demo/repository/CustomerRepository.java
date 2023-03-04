package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CustomerDetails;


@Repository
public interface CustomerRepository extends JpaRepository<CustomerDetails,Integer> {
	
	Boolean existsByEmail(String email);
	
	Optional<CustomerDetails> findByEmail(String email);

}
