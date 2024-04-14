package com.tcs.web.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tcs.web.model.Product;
import com.tcs.web.service.ProductService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductContoller {
	private static final Logger logger = LoggerFactory.getLogger(ProductContoller.class);

	
	@Autowired ProductService productService;
	
	 // Display the product form
    @GetMapping("/getform")
    public String showProductForm(Model model) {
    	Product product =new Product();
    	logger.info("Displaying product form.........");
    	product.setMadeIn("IN");
    	
        model.addAttribute("product", product);
        return "new-product";
    }

    
 // Save the product data
    @PostMapping("/saveproduct")
    public String saveProduct(@Valid  @ModelAttribute Product product,BindingResult bindingResult,RedirectAttributes redirectAttributes) {
    	boolean status =  productService.createProduct(product);
		if(status)
		{	redirectAttributes.addFlashAttribute("savemessage",true);
		     logger.info("Saving product: {}", product);
			
			return "redirect:/products/getproducts";
		}
		else
		{
			logger.error("error in getting product details please check the validations",product);
			redirectAttributes.addFlashAttribute("savemessage",false);
			return "redirect:/products/getproducts";
		}
		
    }	
    
    //edit the product data
      @PostMapping("/updateproduct")
      public String updateProduct(@ModelAttribute Product product,RedirectAttributes redirectAttributes) {
    	  boolean status = productService.updateProductById(product);
    	  if(status) {
    		  redirectAttributes.addFlashAttribute("editmessage",true );
    		  logger.info("Updating product: {}", product);
    		  return "redirect:/products/getproducts";
    	  }
    	  else {
    		  logger.error("please check the validations.......",product);
    		  redirectAttributes.addFlashAttribute("editMessage",false);
  			return "redirect:/products/getproducts";
    	  }
      }

    //getting list of products
    @GetMapping("/getproducts")
	public String getAllProducts(Model model)
	{
		List<Product> products = productService.getAllProducts();
		 logger.info("Getting all products");
		model.addAttribute("products",products);
		
		return "product-list";
	}
  
    //deleting a product by its id 
    @GetMapping("/delete/{proId}")
	public String depeteProduct(@PathVariable Long proId,RedirectAttributes redirectAttributes)
	{
		productService.deleteProduct(proId);
		logger.info("Deleting product with ID: {}", proId);
		redirectAttributes.addFlashAttribute("deletemessage",true);
		return "redirect:/products/getproducts";
	}
    
    //editing a product 
    @GetMapping("/edit/{proId}")
	public String editProductById(@PathVariable Long proId,Model model,RedirectAttributes redirectAttributes)
	{
		Optional<Product> product = productService.getProductById(proId);
		 logger.info("Editing product with ID: {}", proId);
		redirectAttributes.addFlashAttribute("editmessage", true);
		model.addAttribute("product",product);
		return "edit-form";
	}


}
