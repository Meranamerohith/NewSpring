package com.tcs.web.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    @NotBlank(message =  "Product name is required")
    private String name;
    @NotBlank(message =  "Product madein is required")
    private String madeIn;
    @NotBlank(message =  "Product Brand is required")
    private String Brand;

    @NotNull(message= "Product Price must be null")
    @Min(value = 0 ,message="Product Price must not be negative")
    private double price;
	
}
