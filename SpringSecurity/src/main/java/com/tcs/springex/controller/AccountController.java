package com.tcs.springex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
 
	
	@GetMapping("/myaccount")
	public String info() {
		return "This is your account Details.........";
	}
}
