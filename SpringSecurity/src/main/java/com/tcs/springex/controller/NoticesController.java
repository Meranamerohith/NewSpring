package com.tcs.springex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {
  @GetMapping("/mynotices")
  public String noticeDetails() {
	  return "This is notice Details......";
  }
}
