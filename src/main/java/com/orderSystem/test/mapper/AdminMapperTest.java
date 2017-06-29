package com.orderSystem.test.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orderSystem.dao.AdminMapper;
import com.orderSystem.entiry.Admin;
import com.orderSystem.test.BaseTest;


public class AdminMapperTest extends BaseTest {

	@Autowired
	private AdminMapper accountMapper;
	
	@Test
	public void selectByPrimaryKey(){
		//Admin account = accountMapper.selectByPrimaryKey(1);
		
		Admin account = accountMapper.selectByPrimaryKey(1);
		
		System.out.println( account);
	}
	
	@Test
	public void findByAdmin(){
		
		Admin account = accountMapper.findByAdmin("admin", "admin");
		
		System.out.println( account);
	}
}
