package com.tcs.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
  
	@GetMapping("/")
	public String wish() {
		return "oauth.html";
	}
}
