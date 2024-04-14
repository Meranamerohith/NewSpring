package com.tcs.springex.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.tcs.springex.model.Quote;


@RestController
public class APIController {
   
	
	
	@GetMapping("/quotes")
	public ResponseEntity<Quote> getAllQuotes(){
		String url ="https://dummyjson.com/quotes";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Quote> result = restTemplate.getForEntity(url,Quote.class);
		return result;
	}


   @GetMapping("/quotes/{number}")
   public ResponseEntity<Quote> getQuotes(@PathVariable int number){
	   String url="https://dummyjson.com/quotes/"+number;
	   RestTemplate restTemplate = new RestTemplate();
	   ResponseEntity<Quote> result = restTemplate.getForEntity(url, Quote.class);
	   return result;
   }


  @GetMapping("/pincode/{number}")
	   public ResponseEntity<String> getPincodeInfo(@PathVariable int number){
		   String url = "https://api.postalpincode.in/pincode/" + number;
		   RestTemplate restTemplate = new RestTemplate();
		   ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
		   return result;
	   }
   
      @GetMapping("/weather/{location}")
      public ResponseEntity<String> getWeatherInfo(@PathVariable String location){
    	  String url ="http://api.weatherapi.com/v1/current.json?key=e730cc782fa0416d8d7124711240804&q="+location+"&aqi=yes";
    	  RestTemplate template = new RestTemplate();
    	  ResponseEntity<String> result = template.getForEntity(url , String.class);
    	  return result;
      }
   }

