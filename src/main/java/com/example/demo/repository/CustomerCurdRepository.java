package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.CustomerDetails;

public interface CustomerCurdRepository extends CrudRepository<CustomerDetails,Integer> {

}
