package com.tcs.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

	@Bean
	public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
		
		http
		
		.authorizeHttpRequests((requests)-> requests.anyRequest()
				                                    .authenticated())
		                                            .oauth2Login(Customizer.withDefaults());
		return http.build();
				                                    
	}
}
