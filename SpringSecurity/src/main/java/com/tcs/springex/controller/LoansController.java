package com.tcs.springex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {

	
	@GetMapping("/myloans")
	public String getLoanDetails() {
		return "This is your details .....";
	}
}
