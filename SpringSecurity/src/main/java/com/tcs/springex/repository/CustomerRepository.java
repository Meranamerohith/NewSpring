package com.tcs.springex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.springex.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{


	
	
	
}
