package com.orderSystem.test.mapper;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.orderSystem.dao.AdminMapper;
import com.orderSystem.dao.ForderMapper;
import com.orderSystem.entiry.Admin;
import com.orderSystem.entiry.Forder;
import com.orderSystem.test.BaseTest;

public class OrderMapperTest extends BaseTest {
	
	@Autowired
	private ForderMapper fordermapper;
	
	@Autowired
	private AdminMapper accountMapper;
	
	@Test
	public void selectList(){

		List<Forder> list = fordermapper.selectList();
		
		System.out.println("----------------" + list);
	}
	
	@Test
	public void selectByPrimaryKey(){
		
		Admin account =  accountMapper.selectByPrimaryKey(1);
		
		System.out.println(account);
	}
	
	@Test
	public void findByAdmin(){
		
		Admin account = accountMapper.findByAdmin("admin", "admin");
		
		System.out.println(account);
	}
}
