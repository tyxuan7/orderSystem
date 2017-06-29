package com.orderSystem.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.orderSystem.entiry.Product;
import com.orderSystem.service.interfaces.ProductService;
import com.orderSystem.test.BaseTest;

public class ProductServiceTest extends BaseTest {
	
	@Autowired
	private ProductService productService;
	
	@Test
	public void listProduct(){
		
		Product product = productService.findById(5);
		
		System.out.println(product+"----------------------");
	}
	
	@Test
	public void findProduct(){
		
	}

}
