package com.tcs.springex.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
    private String email;
    private String pwd;
    private String role;

	
}
