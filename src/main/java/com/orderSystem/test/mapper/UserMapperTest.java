package com.orderSystem.test.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.orderSystem.dao.UserMapper;
import com.orderSystem.entiry.User;
import com.orderSystem.test.BaseTest;

public class UserMapperTest extends BaseTest {
	
	@Autowired
	private UserMapper usermapper;
	
	@Test
	public void listProduct(){
		User user = new User();
		
		user.setUsername("user");
		
		user.setPassword("user");
		int c = usermapper.checkUsername("user");
		System.out.println(c);
	}
	
	@Test
	public void qw(){
		User user = new User();
		user.setUsername("user");
		user.setPassword("user");
		
		User user2 = usermapper.login(user);
		System.out.println(user2 + "------");
	}
	
	
}
