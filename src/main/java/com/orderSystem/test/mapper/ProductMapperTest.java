package com.orderSystem.test.mapper;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.orderSystem.dao.ProductMapper;
import com.orderSystem.entiry.Product;
import com.orderSystem.test.BaseTest;

public class ProductMapperTest extends BaseTest {
	
	@Autowired
	private ProductMapper productmapper;
	
	@Test
	public void listProduct(){
		
		List<Product> list = productmapper.listProduct();
		
		System.out.println(list);
	}
	
	@Test
	public void addpro(){
		Product product = new Product();
		product.setSprice(200.00);
		product.setCprice(100.00);
		product.setIsHot(true);
		
		int i = productmapper.insert(product);
		System.out.println(i);
	}

	//public void upeadPro(){
		//Product product = new Product(24, "haha", 100, 50, "asa.jpg", "更新", true, 1000);
		//Product product = new Product(24, "haha", 100.00, 50.00, "asa.jpg", "更新", true,Date("222"), 1000);
		//int i = productmapper.updateByPrimaryKey(product);
		//System.out.println(i);
	//}
	
	@Test
	public void findbyname(){
		List<Product>list = productmapper.findByPname("女装");
		System.out.println(list);
	}
	
	@Test
	public void frontlist(){
		List<Product>list = productmapper.frontlistNew();
		//List<Product>list = productmapper.frontlistHot();
		System.out.println(list.size());
		
		System.out.println(list);
	}
}
