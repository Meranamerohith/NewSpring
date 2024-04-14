package com.tcs.springex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.springex.entity.Customer;
import com.tcs.springex.repository.CustomerRepository;

@RestController
public class RegisterController {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	CustomerRepository customerRepository;
	
	
	 @PostMapping("/register")
	    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
	        Customer savedCustomer = null;
	        ResponseEntity<String> response = null;
	        try {
	            
	        	String hashPassword = passwordEncoder.encode(customer.getPwd());
	        	customer.setPwd(hashPassword);
	        			
	        	savedCustomer = customerRepository.save(customer);
	            if (savedCustomer.getId() > 0) {
	                response = ResponseEntity
	                        .status(HttpStatus.CREATED)
	                        .body("Given user details are successfully registered");
	            }
	        } catch (Exception ex) {
	            response = ResponseEntity
	                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body("An exception occured due to " + ex.getMessage());
	        }
	        return response;
	    }

}
