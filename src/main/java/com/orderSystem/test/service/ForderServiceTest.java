package com.orderSystem.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;



import com.orderSystem.entiry.Forder;
import com.orderSystem.service.interfaces.ForderService;
import com.orderSystem.test.BaseTest;

public class ForderServiceTest extends BaseTest {
	
	@Autowired
	private ForderService forderMapper;
	
	@Test
	public void listProduct(){
		
		Forder forder = new Forder();
		
		forder.setAddress("asdsadsads");
		
		//int count = forderMapper.insertOrder(forder);
		System.out.println(forder.getFid());
				
	}
	
	@Test
	public void findProduct(){
		
	}

	
	
}
