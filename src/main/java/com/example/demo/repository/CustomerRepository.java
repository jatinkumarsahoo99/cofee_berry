package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserNewModel;

@Repository
public interface CustomerRepository extends JpaRepository<UserNewModel,Integer> {
	
     Boolean existsByEmail(String email);
	
     
	 Optional<UserNewModel> findByEmail(String email);
	 
	 
		/*
		 * @Query(value="Select u from tbl_user_mstr u where u.user_email == "
		 * ,nativeQuery = true) Integer fetchCustomerCount();
		 */
//	 Optional<UserNewModel> findByUserId(String userId);
	
	
	
	/*
	 * @Procedure (name = "count_users") public Integer fetchCustomerCount();
	 * 
	 * @Query(value = "CALL FIND_CARS_AFTER_YEAR(:year_in);", nativeQuery = true)
	 * public Integer findCarsAfterYear();
	 */

}
