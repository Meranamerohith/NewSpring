package com.tcs.springex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
  
	@GetMapping("/mycontactdetails")
	public String getContactDetails() {
		return "This are contact Details....";
	}
}
