package com.orderSystem.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.orderSystem.service.interfaces.AdminService;
import com.orderSystem.test.BaseTest;
import com.orderSystem.util.IPTimeStamp;

public class AdminServiceTest extends BaseTest {
	
	@Autowired
	private AdminService addminService;
	
	@Test
	public void login(){
		/*Admin admin = addminService.login("admin", "admin");
		System.out.println(admin);*/
		IPTimeStamp ip = new IPTimeStamp();
		
		System.out.println(ip.getTimeStamp()); 
	}
}
