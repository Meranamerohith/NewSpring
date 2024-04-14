package com.tcs.springex.security;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppSecurityConfig {
		
//	@Bean
//	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//	http 
//	
//		.authorizeHttpRequests()
//	.requestMatchers("/myaccount","/mybalance","/mycards","/myloans")
//	.authenticated()
//	.requestMatchers("/mynotices","mycontactdetails")
//	.permitAll()
//	.and()
//	.formLogin()
//	.and()
//	.httpBasic();
//		
//	return http.build();
//	
//	}
	
	
	//	some url's permitted and authenticated
	//New code
//	@Bean
//	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//		http.
//		
//		authorizeHttpRequests(request->request.requestMatchers("/myaccount","/mybalance","/mycards","myloans")
//				.authenticated()
//				.requestMatchers("/mycontactdetails","mynotices")
//				.permitAll()
//				)
//				.formLogin(Customizer.withDefaults())
//				.httpBasic(Customizer.withDefaults());
//		
//		return http.build();
//		
//	}
//	
        //all url's are permitted
//	@Bean
//	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//	    http
//	    .authorizeHttpRequests(request->request.anyRequest()
//				.permitAll()
//				)
//				.formLogin(Customizer.withDefaults())
//				.httpBasic(Customizer.withDefaults());
//		
//		return http.build();      
//}	
	
//	

//	@Bean
//	InMemoryUserDetailsManager userDetailsManager() {
//		UserDetails   admin = User.withDefaultPasswordEncoder()
//				                .username("ratan")
//				                .password("Ratan@123")
//				                .authorities("admin")
//				                .build();
//		UserDetails user = User.withDefaultPasswordEncoder()
//				                .username("sairohith")
//				                .password("sai")
//				                .authorities("user")
//				                .build();
//		
//		return new InMemoryUserDetailsManager(admin,user);
//		
//	}
	
	
	
	//using NoopPassword encoder 
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
//	
//	@Bean
//	InMemoryUserDetailsManager userDetailsManager() {
//		UserDetails admin = User.withUsername("Ratan")
//	                            .password("Ratan@123")
//	                            .authorities("admin")
//	                            .build();
//		UserDetails user = User.withUsername("sairohith")
//				              .password("sai")
//				              .authorities("user")
//				              .build();
//		
//		return new InMemoryUserDetailsManager(admin,user);
//		                       
//	}
//	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		http.csrf().disable()
		.authorizeHttpRequests(request->
				request.requestMatchers("/myaccount","/mybalance","/mycards","/myloans")
				   .authenticated()
				   .requestMatchers("/mycontactdetails","/mynotices","/register","/h2-console/**")
				   .permitAll())
				   .formLogin(Customizer.withDefaults())
				   .httpBasic(Customizer.withDefaults())
				   .headers().frameOptions().disable(); 
		return http.build();	 	 
	}
	
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }	
	
	
	
}

