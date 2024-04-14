package com.tcs.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.web.model.Product;
import com.tcs.web.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
     ProductRepository productRepository;

	public boolean createProduct(Product product) {
	Product productsaved =	productRepository.save(product);
	if(productsaved!=null) {
		return true;
	}else
		return false;
	}

	public List<Product> getAllProducts() {
	List<Product> products=	productRepository.findAll();
	return products;
	}

	public void deleteProduct(Long proId) {
	productRepository.deleteById(proId);
		
	}

	public Optional<Product> getProductById(Long proId) {
		return productRepository.findById(proId);
	}

	public boolean updateProductById(Product product) {
	      Product product2=productRepository.save(product);
	      if(product2!=null) {
	    	  return true;
	      }else {
	    	  return false;
	      }
	}
	
	}
